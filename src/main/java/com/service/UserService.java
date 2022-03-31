package com.service;

import com.model.User;
import net.sf.json.JSONObject;

public interface UserService {
   JSONObject login(String user, String password, String code);

    User getUserByMobileAndPassword(String mobile, String password);

    User getUserByUserNameAndPassword(String username, String password);
}
