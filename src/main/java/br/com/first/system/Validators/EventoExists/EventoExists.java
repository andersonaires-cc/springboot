package br.com.first.system.Validators.EventoExists;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = EventoExistsValidator.class)
@Target({ElementType.METHOD ,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EventoExists {
    String message() default "Evento inexsitente.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
