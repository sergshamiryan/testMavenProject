package org.example;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeviceTest {
        @Test
        void testName() throws Exception {
            // only run on Linux
            Assumptions.assumeFalse(System.getProperty("os.name").contains("Linux"));
            assertTrue(true);
        }

}
