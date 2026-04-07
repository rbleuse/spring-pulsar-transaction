package com.github.rbleuse.springpulsartransaction

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<SpringPulsarTransactionApplication>().with(TestcontainersConfiguration::class).run(*args)
}
