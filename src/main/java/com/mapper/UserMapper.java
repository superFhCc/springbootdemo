package com.mapper;

import com.model.User;

public interface UserMapper {
    // 根据手机号和密码查找用户
    User getByMobileAndPwd(String mobile, String password);


    // 通过手机号查找用户
    User getUserByMobile(String mobile, int language);

    User getUserNameAndPassword(String username, String password);
}
