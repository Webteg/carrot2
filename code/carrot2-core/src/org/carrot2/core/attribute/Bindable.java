package org.carrot2.core.attribute;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * When a given type is bindable, its fields can be bound to attribute values by the
 * {@link AttributeBinder} class.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Bindable
{
    String prefix() default "";
}
