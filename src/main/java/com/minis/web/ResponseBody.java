package com.minis.web;

import java.lang.annotation.*;

/**
 * @author yjc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ResponseBody {
}
