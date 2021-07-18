package ru.ilin.charactercounter.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTests {

    private Validator validator = new ValidatorImpl();

    @Test
    void validateShouldIllegalArgumentExceptionWhenNull(){
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> validator.validate(null));
    }

    @Test
    void validateShouldDoesNotThrowExceptionWhenSuccessFullString(){
        Assertions.assertDoesNotThrow(() -> validator.validate("null"));
    }
}
