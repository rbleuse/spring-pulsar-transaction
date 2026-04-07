package com.github.rbleuse.springpulsartransaction.listener

import org.apache.pulsar.client.api.Message
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
        logger.info("Received message ID {}", message.messageId)
        acknowledgment.acknowledge()
    }
}
