package de.yggdrasil.core.placeholder;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface FindPlaceholder { }
