package com.util;

import com.model.User;
import com.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private SessionDAO sessionDAO;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user = (User) principal.fromRealm(this.getClass().getName()).iterator().next();// 获取session中的用户
        List<String> permissions = new ArrayList<>();
        /*
         * Set<RoleDto> roles = user.getRoleDtos(); if (roles.size() > 0) { for (RoleDto role : roles) {
         * permissions.add(role.getRole()); } } SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
         */
        permissions.add(user.getUsername());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(permissions);// 将权限放入shiro中.
        // return info;
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        // 加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if(authenticationToken.getPrincipal() == null) {
            return null;
        }
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        System.out.println("userName=" + userName + ",password=" + password);
        User loginUser = new User();
        loginUser.setUsername(userName);
        loginUser.setPassword(password);
        // 获取用户名。通过 username 找到该用户
        User user = userService.getUserByUserNameAndPassword(userName,password);
        if(user != null) {
            String userId = user.getUserId();
            // 获取所有session
            // todo
//            Collection<Session> sessions = sessionDAO.getActiveSessions();
            
            Serializable sessionId = jedisClient.get("user_session_"+user.getUserId());
            if(sessionId!=null) {
            	Session redisSession = null;
            	try {
            		redisSession = sessionDAO.readSession(sessionId);
            	}catch(UnknownSessionException e) {
//            		session1=null;
            		System.out.println("session is not exist");
            	}
	            if(redisSession != null) {
//	            	session1.setTimeout(0); // 这里就把session清除
	            	redisSession.stop();
	            	sessionDAO.delete(redisSession);
	                System.out.println("清除了");
	            }
            }
//            System.out.println("sessions' size:" + sessions.size());
            /*if(sessions.size() > 0) {
                for (Session session : sessions) {
                    // System.out.println("::::::::::::::::" + session);
                    // 获得session中已经登录用户的名字
                    if(null != session.getAttribute("USER_SESSION")) {
                        String loginUserId = ((User) session.getAttribute("USER_SESSION")).getUserId();
                        System.out.println("::::::::::::::::" + loginUserId);
                        // 如果session里面有当前登陆的，则证明是重复登陆的，则将其剔除
                        if(userId.equals(loginUserId)) { // 这里的username也就是当前登录的username
                        	session.setTimeout(0); // 这里就把session清除
                        	sessionDAO.delete(session);
                            System.out.println("清除了");
                        }
                    }
                	

                }
            }*/
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),
                    ByteSource.Util.bytes(userId), getName());
            return authenticationInfo;
        }
        return null;
    }
}
