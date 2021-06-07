package com.github.osmundf.tpc.example;

import com.github.osmundf.tpc.application.Application;
import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class ApplicationBacked {

    private static Application server = null;

    @BeforeAll
    static void startServer() {
        if (server == null) { // keep spring boot side alive for all tests including package 'mock'
            server = new Application();
            server.start(new String[]{"--server.port=0"});
        }
        System.setProperty("application.server.port", server.getPort());
    }

    @AfterAll
    static void stopServer() {
        server.stop();
    }

    @Karate.Test
    Karate testGreeting() {
        return Karate.run("hello-world").relativeTo(getClass());
    }

    @Karate.Test
    Karate testScenarioOutline() {
        return Karate.run("scenario-outline-csv").scenarioName("Send CSV Row").relativeTo(getClass());
    }
}
