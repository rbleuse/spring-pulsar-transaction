package com.github.rbleuse.springpulsartransaction.listener

import org.apache.pulsar.client.api.Message
import org.apache.pulsar.client.impl.transaction.TransactionImpl
import org.slf4j.LoggerFactory
import org.springframework.pulsar.annotation.PulsarListener
import org.springframework.pulsar.listener.AckMode
import org.springframework.pulsar.listener.Acknowledgement
import org.springframework.stereotype.Service

data class TestMessage(val message: String)

@Service
class MessageListener {
    companion object {
        private val logger = LoggerFactory.getLogger(MessageListener::class.java)
    }

    @PulsarListener(
        topics = ["persistent://public/default/test-topic"],
        subscriptionName = "message",
        ackMode = AckMode.MANUAL,
        transactional = "false"
    )
    fun consumeMessage(message: Message<TestMessage>,
        acknowledgment: Acknowledgement
    ) {
        val field = acknowledgment.javaClass.superclass.getDeclaredField("txn")
        field.isAccessible = true

        val transaction = field.get(acknowledgment) as TransactionImpl?

        logger.info("Received message ID {}, with txn ID {} and txn state {}", message.messageId, transaction?.txnID, transaction?.state)

        acknowledgment.acknowledge()
    }
}
