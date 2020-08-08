package com.springAOP.spring;

import net.sourceforge.retroweaver.runtime.java.lang.annotation.ElementType;
import net.sourceforge.retroweaver.runtime.java.lang.annotation.Retention;
import net.sourceforge.retroweaver.runtime.java.lang.annotation.RetentionPolicy;
import net.sourceforge.retroweaver.runtime.java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {

}
