package com.app.gogol.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**
 * @author unalpolat
 */
@Documented
@Constraint(
    validatedBy = {}
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Pattern(
    regexp = "0?\\(?[1-9][0-9]{2}\\)?\\s?[0-9]{3}\\s?[0-9]{2}\\s?[0-9]{2}",
    message = "Lutfen telefon numara formatinizi kontrol ediniz"
)
public @interface PhoneNumber {

  String message() default "Lutfen telefon numara formatinizi kontrol ediniz";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
