package com.app.gogol.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;

/**
 * @author unalpolat
 */
@Documented
@Constraint(
    validatedBy = {}
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@javax.validation.constraints.Email(
    regexp = "^[^ığüşöçİĞÜŞÖÇ]+@[^ığüşöçİĞÜŞÖÇ]+\\.[a-z-A-Z]{2,}$",
    message = "Lutfen gecerli bir email adresi giriniz"
)
@Size(max = 64, message = "En fazla 64 karakterli email adresi girebilirsiniz")
public @interface Email {

  String message() default "Lutfen gecerli bir email adresi giriniz";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
