package com.matthew.springbootgradle.dal.conf;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.Reader;

/**
 * @author zeyuan
 * Create Time : 2019/2/13 11:46 PM
 */
@Configuration
public class MybatisConfig {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("datasource.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

}
