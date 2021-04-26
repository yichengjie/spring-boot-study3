package com.yicj.mybatis.plugins;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 * @Intercepts 拦截器注解，包括一个或多个 @Signature
 * @Signature 拦截的目标类信息，包括 type、method、args
 * * type 要拦截的接口类型
 * * method 接口中的方法名
 * * args 方法的所有入参类型
 */
@Intercepts({
    @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class MyStatementHandlerPlugin implements Interceptor {
    /**
     * 拦截目标对象的目标方法的执行，将自定义逻辑写在该方法中
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("MyStatementHandlerPlugin...intercept:" + invocation.getMethod());
        // MetaObject 是 Mybatis 提供的一个用于访问对象属性的对象
        MetaObject metaObject = SystemMetaObject.forObject(invocation);
        System.out.println("当前拦截到的对象：" + metaObject.getValue("target"));
        System.out.println("SQL语句：" + metaObject.getValue("target.delegate.boundSql.sql"));
        System.out.println("SQL语句入参：" + metaObject.getValue("target.delegate.parameterHandler.parameterObject"));
        System.out.println("SQL语句类型：" + metaObject.getValue("target.delegate.parameterHandler.mappedStatement.sqlCommandType"));
        System.out.println("Mapper方法全路径名：" + metaObject.getValue("target.delegate.parameterHandler.mappedStatement.id"));
        // 修改 SQL 语句
        String newSQL = metaObject.getValue("target.delegate.boundSql.sql") + " limit 2";
        metaObject.setValue("target.delegate.boundSql.sql", newSQL);
        System.out.println("修改后SQL语句：" + newSQL);
        // 返回执行结果
        return invocation.proceed();
    }

    /**
     * 为目标对象创建一个代理对象，使用 Plugin.wrap(target,this) 即可
     * @param target 上次包装的代理对象
     * @return 本次包装过的代理对象
     */
    @Override
    public Object plugin(Object target) {
        System.out.println("MyStatementHandlerPlugin...plugin:" + target);
        return Plugin.wrap(target, this);
    }

    /**
     * 获取自定义配置参数
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件配置信息：" + properties);
        System.out.println("someProperty：" + properties.get("someProperty"));
    }
}
