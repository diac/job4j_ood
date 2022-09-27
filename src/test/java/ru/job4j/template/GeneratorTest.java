package ru.job4j.template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
class GeneratorTest {

    @Test
    public void whenProduce() {
        Generator generator = new SimpleGenerator();
        assertThat(
                generator.produce("Test template: ${placeholder}", Map.of("placeholder", "success"))
        ).isEqualTo("Test template: success");
    }

    @Test
    public void whenKeyDoesNotExist() {
        Generator generator = new SimpleGenerator();
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> generator.produce("Test template: ${no_such_key}", Map.of("placeholder", "fail"))
        );
    }

    @Test
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