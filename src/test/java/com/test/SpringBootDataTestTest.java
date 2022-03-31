package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@RestController
public class SpringBootDataTestTest {

    @Autowired
    DataSource dataSource;

    @Resource
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("/getPersions")
    public List<Map<String, Object>> getPersion(){

        List<Map<String, Object>> mapList = jdbcTemplate.queryForList("SELECT a0000,a0101,a0107,a0184,a0104 FROM a01 WHERE a0104 IN (98,99) ");
/*        try {
            Connection connection = dataSource.getConnection();
            final DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("数据源>>>>>>" + dataSource.getClass());
            System.out.println("连接>>>>>>>>" + connection);
            System.out.println("连接地址>>>>" + connection.getMetaData().getURL());
            System.out.println("驱动名称>>>>" + metaData.getDriverName());
            System.out.println("驱动版本>>>>" + metaData.getDriverVersion());
            System.out.println("数据库名称>>" + metaData.getDatabaseProductName());
            System.out.println("数据库版本>>" + metaData.getDatabaseProductVersion());
            System.out.println("连接用户名称>" + metaData.getUserName());
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        return mapList;
    }

}