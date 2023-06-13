package com.programming.techie.discoveryserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.runApplication
@SpringBootApplication
@EnableEurekaServer

class DiscoveryServerApplication

fun main(args: Array<String>) {
    runApplication<DiscoveryServerApplication>(*args)
}
