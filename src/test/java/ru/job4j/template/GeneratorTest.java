package ru.job4j.template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class GeneratorTest {

    @Test
    public void whenProduce() {
        Generator generator = new SimpleGenerator();
        assertThat(
                generator.produce("Test template: ${placeholder}", Map.of("placeholder", "success"))
        ).isNull();
    }

    public void whenKeyDoesNotExist() {
        Generator generator = new SimpleGenerator();
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> generator.produce("Test template: ${no_such_key}", Map.of("placeholder", "fail"))
        );
    }

    public void whenTooManyKeysInMap() {
        Generator generator = new SimpleGenerator();
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> generator.produce(
                        "Test template: ${placeholder}",
                        Map.of("placeholder", "success",
                                "extra_key", "fail")
                )
        );
    }
}