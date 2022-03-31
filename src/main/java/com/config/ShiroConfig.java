package com.config;

import com.util.MyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    // 将自己的验证方式加入容器
    @Bean
    public MyRealm myRealm() {
        System.out.println("注入 realm");
        MyRealm myRealm = new MyRealm();
        return myRealm;
    }

    @Bean(name = "sessionDAO")
    public MemorySessionDAO getMemorySessionDAO() {
        return new MemorySessionDAO();
    }

    @Bean(name = "sessionManager")
    public DefaultWebSessionManager getDefaultWebSessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(getMemorySessionDAO());
        sessionManager.setGlobalSessionTimeout(-1000l);
        return sessionManager;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealm());
        // 将sessionDAO放进来
        defaultWebSecurityManager.setSessionManager(getDefaultWebSessionManager());
        return defaultWebSecurityManager;
    }

    // Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        System.out.println("shiro 过滤器");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/pages/**", "anon");
        filterChainDefinitionMap.put("/pay/**", "anon");
        filterChainDefinitionMap.put("/index", "anon");
        filterChainDefinitionMap.put("/login", "anon");// 登录
        filterChainDefinitionMap.put("/sendVerifyCode", "anon");// 发送验证码
        filterChainDefinitionMap.put("/sendLoginVerifyCode", "anon");
        filterChainDefinitionMap.put("/checkVerifycode", "anon");
        filterChainDefinitionMap.put("/live/getItems", "anon");
        filterChainDefinitionMap.put("/live/getRoomByItem", "anon");
        filterChainDefinitionMap.put("/dynamic/findDynamicByKeywords", "anon");
        filterChainDefinitionMap.put("/dynamic/getDynamicByType", "anon");
        filterChainDefinitionMap.put("/user/findUser", "anon");
        filterChainDefinitionMap.put("/user/regist", "anon");
        filterChainDefinitionMap.put("/user/updateUser", "anon");
        filterChainDefinitionMap.put("/domainName/getList", "anon");
        filterChainDefinitionMap.put("/pay/result", "anon");
        filterChainDefinitionMap.put("/pay/page", "anon");
        filterChainDefinitionMap.put("/user/forgetPassword", "anon");
        filterChainDefinitionMap.put("/skip", "anon");
        // filterChainDefinitionMap.put("/*:8081/domainName/getList", "anon");
        // 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        // filterChainDefinitionMap.put("/logout", "logout");
        // <!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        //filterChainDefinitionMap.put("/**", "authc");
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/nologin");
        // 登录成功后要跳转的链接
        // shiroFilterFactoryBean.setSuccessUrl("/user/list");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/nologin");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
}
