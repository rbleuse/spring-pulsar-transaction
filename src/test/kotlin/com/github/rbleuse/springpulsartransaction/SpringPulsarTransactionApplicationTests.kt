package com.github.rbleuse.springpulsartransaction

import com.github.rbleuse.springpulsartransaction.listener.MessageListener
import com.github.rbleuse.springpulsartransaction.listener.TestMessage
import com.ninjasquad.springmockk.MockkSpyBean
import io.mockk.slot
import io.mockk.verify
import org.apache.pulsar.client.impl.transaction.TransactionImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.pulsar.core.PulsarTemplate
import org.springframework.pulsar.listener.Acknowledgement
import java.lang.reflect.Field
import kotlin.test.Test

@Import(TestcontainersConfiguration::class)
@SpringBootTest(
    properties = [
        "spring.pulsar.consumer.subscription.name=test-subscription-\${random.uuid}",
    ],
)
class SpringPulsarTransactionApplicationTests @Autowired constructor(
    private val pulsarTemplate: PulsarTemplate<TestMessage>,
    @MockkSpyBean private val listener: MessageListener,
) {

    @Test
    fun `should consume first message`() {
        val message = TestMessage("Hello, Pulsar!")

        pulsarTemplate.send("persistent://public/default/test-topic", message)

        val slot = slot<Acknowledgement>()

        verify(exactly = 1, timeout = 1000) {
            listener.consumeMessage(any(), capture(slot))
        }

        val receivedAcknowledgement = slot.captured

        val transaction = getTransaction(receivedAcknowledgement)
        println("txn = ${transaction.txnID}")
    }

    @Test
    fun `should consume second message`() {
        val message = TestMessage("Hello, Pulsar 2!")

        pulsarTemplate.send("persistent://public/default/test-topic", message)

        val slot = slot<Acknowledgement>()

        verify(exactly = 1, timeout = 1000) {
            listener.consumeMessage(any(), capture(slot))
        }

        val receivedAcknowledgement = slot.captured

        val transaction = getTransaction(receivedAcknowledgement)
        println("txn = ${transaction.txnID}")
    }

    private fun getTransaction(acknowledgement: Acknowledgement): TransactionImpl {
        val field = getFieldRecursively(
            acknowledgement.javaClass,
            "txn"
        )
        field.isAccessible = true

        return field.get(acknowledgement) as TransactionImpl
    }

    private fun getFieldRecursively(clazz: Class<*>, fieldName: String): Field {
        var current: Class<*>? = clazz
        while (current != null) {
            try {
                return current.getDeclaredField(fieldName)
            } catch (ex: NoSuchFieldException) {
                current = current.superclass
            }
        }
        throw NoSuchFieldException(fieldName)
    }
}
