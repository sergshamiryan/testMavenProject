package org.example.testDoublesDummy;

import org.example.testDoubleDummy.EmailService;

/**
 * We use DummyEmailService, just for the code to compile
 */
public class DummyEmailService implements EmailService {
    @Override
    public void sendEmail(String message) {
        throw new AssertionError("Method not implemented");
    }
}
