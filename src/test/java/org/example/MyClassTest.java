package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyClassTest {

    MyClass myClass;

    @BeforeEach
    void create() {
        myClass = new MyClass();
    }

    @Test
    void shouldThrowExceptionAndTestMultiply() {
        assertAll(() -> assertThrows(IllegalArgumentException.class, () -> myClass.multiply(1000,5)),
                () -> assertEquals(50, myClass.multiply(10, 5), "10 x 5 must be 50"));
    }

}