import org.example.ConverterUtil;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterUtilTest {
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


}
