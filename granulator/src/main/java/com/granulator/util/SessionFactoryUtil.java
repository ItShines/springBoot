package com.granulator.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author Future
 */
public class SessionFactoryUtil {

    public static SessionFactory sessionFactory = null;

    /**
     * 获取session
     * @return
     */
    public static Session getSession(){
        //判断sessionFactory是否为空
        if(sessionFactory == null ){
            sessionFactory = getSessionFactory();
        }
        //获取session
        return sessionFactory.getCurrentSession();
    }
    /**
     * 获取sessionFactory
     * @return
     */
    public static SessionFactory getSessionFactory(){
        //1. 解析我们在hibernate.cfg.xml中的配置
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        //2. 创建服务注册类,进一步注册初始化我们配置文件中的属性
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        //3. 判断sessionFactory是否为空
        if(sessionFactory == null ){
            //4. 创建我们的数据库访问会话工厂
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}
