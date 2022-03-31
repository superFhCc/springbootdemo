package com.Customer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CodeImageController {

    @RequestMapping(value = "/getLoginQr" ,method = RequestMethod.GET)
    public void createCodeImg(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");

        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

       /* try {
            //这里没啥操作 就是生成一个UUID插入 数据库的表里
            String uuid = userService.createQrImg();
            response.setHeader("uuid", uuid);
            // 这里是开源工具类 hutool里的QrCodeUtil
            // 网址：http://hutool.mydoc.io/
            QrCodeUtil.generate(uuid, 300, 300, "jpg",response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

}
