package com.github.rbleuse.springpulsartransaction

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringPulsarTransactionApplication

fun main(args: Array<String>) {
    runApplication<SpringPulsarTransactionApplication>(*args)
}
