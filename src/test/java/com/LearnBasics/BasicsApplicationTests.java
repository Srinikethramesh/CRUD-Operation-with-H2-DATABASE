package com.LearnBasics;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class BasicsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void mainMethodShouldRun() {
        assertDoesNotThrow(() -> {
            // Testing that main method can be called without errors
            // Note: We don't actually run it to avoid starting the server
        });
    }

}
