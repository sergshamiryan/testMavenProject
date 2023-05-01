package org.example.junit;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ConverterUtilTest {

    void ConvertUtilTest() {
        System.out.println("a");
        int x = 6;
        int b;

    }

    final public int aa(){
        return 0;
    }

    int[][] celsiusFahrenheitMapping = new int[][]{{10, 50}, {40, 104}, {0, 32}};

    @TestFactory
    Stream<DynamicTest> ensureThatCelsiumConvertsToFahrenheit() {
        return Arrays.stream(celsiusFahrenheitMapping)
                .map((n) -> {
                    int celsius = n[0];
                    int fahrenheit = n[1];
                    return DynamicTest.dynamicTest("Celsius to fahrenheit",
                            () -> assertEquals(fahrenheit, ConverterUtil.convertCelsiusToFahrenheit(celsius)));
                });

    }

    public static void main(String[] args) {
        Object i = new ArrayList().iterator();
        System.out.print((i instanceof List) + ",");
        System.out.print((i instanceof Iterator) + ",");
        System.out.print(i instanceof ListIterator);
        Object a = new ConverterUtilTest();
        ConverterUtilTest converterUtilTest = (ConverterUtilTest) a;
    }


}
