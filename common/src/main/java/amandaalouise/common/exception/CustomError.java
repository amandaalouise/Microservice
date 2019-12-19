package common.src.main.java.amandaalouise.common.exception;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;;

/**
 * CustomError
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomError {

    String code();
    
}