package com.github.osmundf.tpc.example;

import com.intuit.karate.junit5.Karate;

public class Example {

    @Karate.Test
    Karate testAddEmployee() {
        return Karate.run("hello-world").relativeTo(getClass());
    }
}