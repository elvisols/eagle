/**
 * 
 */
package com.exelon.ee.qualifier;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;
/**
 * @author ukaegbu
 *
 */

@Qualifier
@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER })
public @interface UserDatabase {

}
