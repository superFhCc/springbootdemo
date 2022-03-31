package com.Customer.controller;

import com.util.RedisUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PersionNameController {

    @Resource
    RedisUtils redisUtils;

    @ResponseBody
    @RequestMapping("/getPersionName")
    public Map getPersionName(){
        HashMap hashMap = new HashMap();
        String a = "dsfsd";
        hashMap.put("aaa",a);
        return hashMap;
    }


    public Integer getPersionNum(@PathParam("jsonString") String jsonString){

        return 0;
    }


}
