package com.service.impl;

import com.mapper.UserMapper;
import com.model.User;
import com.service.UserService;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject login(String username, String password, String code) {

        return loginMethod(username,password,code);
    }

    public JSONObject loginMethod(String username,String password,String code) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        JSONObject jsonObject = new JSONObject();
        String code1 = code;
        String msg = "登录成功！";
        int flag=0;
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            msg = "未知账户";
        } catch (IncorrectCredentialsException ice) {
            msg = "密码不正确";
        } catch (LockedAccountException lae) {
            msg = "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
            msg = "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            msg = "用户名或密码不正确！";
        }
        if (subject.isAuthenticated()) {
            flag=1;

            msg = "登录成功";
        } else {
            token.clear();
            msg = "登录失败";
        }
        jsonObject.put("flag", flag);
        jsonObject.put("msg", msg);
        return jsonObject;
    }

    @Override
    public User getUserByMobileAndPassword(String mobile, String password) {
        return userMapper.getByMobileAndPwd(mobile, password);
        //User user = new User();
        //return user;
    }

    @Override
    public User getUserByUserNameAndPassword(String username, String password) {
        return userMapper.getUserNameAndPassword(username, password);
    }
}
