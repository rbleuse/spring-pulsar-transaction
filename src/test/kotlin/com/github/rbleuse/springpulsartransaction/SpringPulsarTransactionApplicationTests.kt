package com.github.rbleuse.springpulsartransaction

import com.github.rbleuse.springpulsartransaction.listener.MessageListener
import com.github.rbleuse.springpulsartransaction.listener.TestMessage
import com.ninjasquad.springmockk.MockkSpyBean
import io.mockk.verify
import org.apache.pulsar.client.api.PulsarClient
import org.apache.pulsar.client.api.Schema
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import kotlin.test.Test

@Import(TestcontainersConfiguration::class)
@SpringBootTest
class SpringPulsarTransactionApplicationTests @Autowired constructor(
    private val pulsarClient: PulsarClient,
    @MockkSpyBean private val listener: MessageListener,
) {
    fun PulsarClient.sendMessageToTopic(
        payload: TestMessage,
        key: String,
    ) {
        this.newProducer(Schema.JSON(TestMessage::class.java))
            .topic("persistent://public/default/test-topic")
            .create().use { producer ->
                producer
                    .newMessage()
                    .key(key)
                    .value(payload)
                    .send()
            }
    }


    @Test
    fun `should consume first message`() {
        val message = TestMessage("Hello, Pulsar!")

        pulsarClient.sendMessageToTopic(message, "message1")

        verify(exactly = 1, timeout = 1000) {
            listener.consumeMessage(any(), any())
        }
    }

    @Test
    fun `should consume second message`() {
        val message = TestMessage("Hello, Pulsar 2!")

        pulsarClient.sendMessageToTopic(message, "message2")

        verify(exactly = 1, timeout = 1000) {
            listener.consumeMessage(any(), any())
        }
    }
}
