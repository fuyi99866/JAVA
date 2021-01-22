package com.fy.ssm.controller;
import com.fy.ssm.domain.SysLog;
import com.fy.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService sysLogService;

    private Date startTime;//访问时间
    private Class executionClass;//访问的类
    private Method executionMethod;//执行的方法

    /**
     * 获取访问时间、访问的类、访问的方法
     * @param joinPoint
     * @throws NoSuchMethodException
     */
    @Before("execution(* com.fy.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException ,SecurityException{
        //访问时间
        startTime = new Date();
        //获取访问的类
        executionClass = joinPoint.getTarget().getClass();
        //获取访问的方法
        String methodName = joinPoint.getSignature().getName();//获取访问方法的名称
        Object[] args = joinPoint.getArgs();//获取访问的参数
        if ((args == null || (0 == args.length))){//无参数
            executionMethod = executionClass.getMethod(methodName);
        }else {
            //有参数，就将args中所有的元素遍历，获取对应的class，装入到一个class[]
            Class[] classeArgs = new Class[args.length];
            for(int i= 0;i<args.length;i++){
                classeArgs[i] = args[i].getClass();
            }
            executionMethod = executionClass.getMethod(methodName,classeArgs);
        }
    }

    @After("execution(* com.fy.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception {
        //获取类上的@RequestMapping对象
        if(executionClass!= SysLogController.class){
            RequestMapping classAnnotation = (RequestMapping) executionClass.getAnnotation(RequestMapping.class);
            if(classAnnotation != null){
                //获取方法上的@RequestMapping对象
                RequestMapping methodAnnocation = executionMethod.getAnnotation(RequestMapping.class);
                if(methodAnnocation != null){
                    String url = "";// 它的值应该是类上的@RequestMapping的value+方法上的 @RequestMapping的value
                    url = classAnnotation.value()[0]+methodAnnocation.value()[0];
                    SysLog sysLog = new SysLog();
                    //获取访问时长
                    Long executionTime = new Date().getTime() - startTime.getTime();
                    //将sysLog对象封装
                    sysLog.setExecutionTime(executionTime);
                    sysLog.setUrl(url);
                    //获取IP
                    String ip = request.getRemoteAddr();
                    sysLog.setIp(ip);

                    //可以通过securityContext获取，也可以从request.getSession中获取
                    SecurityContext context = SecurityContextHolder.getContext();//request.getSession().getAttribute("SPRING_SECURITY_CONTEXT")
                    String username = ((User)(context.getAuthentication().getPrincipal())).getUsername();
                    sysLog.setUsername(username);
                    sysLog.setMethod("[类名]"+executionClass.getName()+"[方法名]"+executionMethod.getName());
                    sysLog.setVisitTime(startTime);

                    //调用Service,调用dao将sysLog 插入到数据库
                    sysLogService.save(sysLog);
                }
            }
        }
    }
}
