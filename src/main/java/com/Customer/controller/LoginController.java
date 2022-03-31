package com.Customer.controller;


import com.model.User;
import com.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(String username,String password,String code){
        JSONObject jsonobject = userService.login(username, password, code);
        User userByMobileAndPassword = userService.getUserByMobileAndPassword("13111111111", password);
        return jsonobject;
    }
}
