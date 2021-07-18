package ru.ilin.charactercounter.validator;

public class ValidatorImpl implements Validator {

    @Override
    public void validate(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input text is null");
        }
    }
}
