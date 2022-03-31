package com;

import com.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class PersionController {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @Resource
    JdbcTemplate jdbcTemplate;

    @Resource
    RedisUtils redisUtils;


    @ResponseBody
    @RequestMapping("/getPersionss")
    public List<Map<String, Object>> getPersion(String key){
        HashMap<String, Object>  persionMap;
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList("SELECT a0000,a0101,a0107,a0184,a0104 FROM a01 WHERE a0104 IN (98,99) ");
        for(int i=0;i<mapList.size();i++){
            persionMap = new HashMap();
            Object a0101 = mapList.get(i).get("a0101");
            Object a0184 = mapList.get(i).get("a0184");
            persionMap.put("名字",a0101);
            persionMap.put("身份证",a0184);
            redisUtils.hmset(key, persionMap);
        }

        /** ========= 基本配置 =========
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(hostName);
        configuration.setPort(port);
        configuration.setDatabase(database);
        if (!ObjectUtils.isEmpty(password)) {
            RedisPassword redisPassword = RedisPassword.of(password);
            configuration.setPassword(redisPassword);
        }
         **/


        try {
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
        }

        return mapList;
    }
}
