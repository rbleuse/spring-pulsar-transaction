package com.github.rbleuse.springpulsartransaction

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.pulsar.PulsarContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

    private fun PulsarContainer.withBrokerPublishTime(): PulsarContainer =
        this
            .withEnv(
                "PULSAR_PREFIX_brokerEntryMetadataInterceptors",
                "org.apache.pulsar.common.intercept.AppendBrokerTimestampMetadataInterceptor",
            ).withEnv("PULSAR_PREFIX_exposingBrokerEntryMetadataToClientEnabled", "true")

    @Bean
    @ServiceConnection
    fun pulsarContainer(): PulsarContainer {
        return PulsarContainer(DockerImageName.parse("apachepulsar/pulsar:4.1.3"))
            .withTransactions()
            .withBrokerPublishTime()
    }

}
