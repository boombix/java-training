package com.company.Validators;

import com.company.Domain.Animal;
import com.company.Exceptions.ValidationException;

public class AnimalValidator {
    public static void validate(Animal animal) throws ValidationException {
        String errors = "";
        if(animal.getColor().length() <= 3)
            errors += "Color must have at least 3 letters!\n";
        if(animal.getWeight() < 0)
            errors += "Weight must be greater than 0!\n";
        if(animal.getName().length() <= 3)
            errors += "Name must have at least 3 letters!\n";

        if(!errors.isEmpty())
            throw new ValidationException(errors);

    }
}
