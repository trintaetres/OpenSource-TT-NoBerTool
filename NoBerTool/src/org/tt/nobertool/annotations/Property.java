package org.tt.nobertool.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.tt.nobertool.core.datasource.DatasourceEnum;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) 
public @interface Property {

	DatasourceEnum datasource() default DatasourceEnum.Hibernate;
	
}
