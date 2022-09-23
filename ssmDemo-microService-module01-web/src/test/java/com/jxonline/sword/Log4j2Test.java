package com.jxonline.sword;



import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xs
 * @date 2022/9/18
 **/


public class Log4j2Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(Log4j2Test.class);


    @Test
    public void Log4j2Test(){
        LOGGER.trace("Log4j2日志输出：This is trace message.");
        LOGGER.debug("Log4j2日志输出：This is debug message.");
        LOGGER.info("Log4j2日志输出：This is info message.");
        LOGGER.error("Log4j2日志输出：This is error message.");


    }
}
