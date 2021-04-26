package com.yicj.mybatis.plugins;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import java.sql.PreparedStatement;

@Slf4j
@Intercepts({
    @Signature(type = ParameterHandler.class, method = "setParameters", args = {PreparedStatement.class})
})
public class MyParameterHandlerPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("=====> {}", invocation.getMethod().getName());
        return invocation.proceed();
    }
}
