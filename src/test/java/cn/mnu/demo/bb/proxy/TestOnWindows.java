/**
 * 
 */
package cn.mnu.demo.bb.proxy;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@Documented
@Retention(RUNTIME)
@Target(METHOD)
@Test
@EnabledOnOs(OS.WINDOWS)
/**
 * @author zhouufen
 *
 */
public @interface TestOnWindows {

}
