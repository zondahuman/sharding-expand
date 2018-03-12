package com.abin.lee.sharding.expand.api.aop;

import com.abin.lee.sharding.expand.api.datasource.DynamicDataSourceContextHolder;
import com.abin.lee.sharding.expand.api.datasource.LocationIdentity;
import com.abin.lee.sharding.expand.api.enums.DefaultDataType;
import com.abin.lee.sharding.expand.api.logic.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Order(-1) // 保证该AOP在@Transactional之前执行
@Component
@Slf4j
public class DynamicElectAspect {

    @Autowired
    LocationService locationService;


    @Pointcut("execution(* com.abin.lee.sharding.expand.api.service.impl..*.*(..))")
    public void pointCut() {
    }

    //    @Before(value = "pointCut()" + " && @annotation(SelectIdentity)" )
    @Before("@annotation(locationIdentity)")
//    @Before("execution(@SelectIdentity public * com.abin.lee.sharding.dbtable.api.service.impl..*.*(..))")
//    @Before("execution(public * com.abin.lee.sharding.dbtable.api.service.impl..*.*(..))")
    public void beforeSwitch(JoinPoint joinPoint, LocationIdentity locationIdentity) throws Throwable {

        String typeName = typeName(joinPoint);
        String dataSource = typeName;
        log.info("DATABASE-------------= " + dataSource);
        //为了省事，其他代码就不写了，
        // 切换数据源
        if (StringUtils.equals(typeName, DefaultDataType.dataSource.name())) {
            DynamicDataSourceContextHolder.setDataSourceType(dataSource);
        }

    }

    public static String typeName(JoinPoint joinPoint) throws Throwable {
        String result = "";
        String method = joinPoint.getSignature().getName();
        Object target = joinPoint.getTarget();
        Class<?> classz = target.getClass();
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
        Method m = classz.getMethod(method, parameterTypes);
        LocationIdentity locationIdentity = m.getAnnotation(LocationIdentity.class);
        if (locationIdentity != null) {
            result = locationIdentity.source().name();
        }
        return result;
    }


    @After("@annotation(locationIdentity)")
    public void afterSwitch(JoinPoint point, LocationIdentity locationIdentity) {

        DynamicDataSourceContextHolder.clearDataSourceType();

    }

}
