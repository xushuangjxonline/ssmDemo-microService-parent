package com.jxonline.sword;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author xs
 * @date 2022/9/8
 **/

//Spring和Junit5整合
@ExtendWith(SpringExtension.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class SwordTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println("connection =" + connection);
    }

}
