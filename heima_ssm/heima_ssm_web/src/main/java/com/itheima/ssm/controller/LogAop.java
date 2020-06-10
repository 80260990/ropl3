package com.itheima.ssm.controller;

import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
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
import java.security.Security;
import java.util.Date;

/**
 * @Classname LogAop
 * @Description TODO
 * @Date 2020/5/26 10:55
 * @Created by Leslie
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    ISysLogService sysLogService;

    @Autowired
    private HttpServletRequest request;


    private Date visitTime;     //开始时间
    private Class clazz;        //访问的类
    private Method method;      //访问的方法


    //前置通知  主要是获取开始时间，执行的类是哪一个，执行的方法是哪一个
    @Before("execution(* com.itheima.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime=new Date();                   //当前时间，就是访问时间
        clazz = jp.getTarget().getClass();      //具体要访问的类
        String methodName = jp.getSignature().getName();   //获取访问方法的名称
        Object[] args = jp.getArgs();                        //获取访问方法的参数


//        获取具体执行的方法的Method对象
        if(args==null||args.length==0){
            method = clazz.getMethod(methodName);           //只能获取无参数的方法
        }else{
            Class[] classArgs = new Class[args.length];
            for (int i = 0 ;i< args.length;i++){
                classArgs[i]=args[i].getClass();
            }
            method = clazz.getMethod(methodName,classArgs);
        }

    }

    //前置通知
    @After("execution(* com.itheima.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp){
        long time = new Date().getTime()-visitTime.getTime();       //获取访问时长

        String url="";
        //获取URL
        if(clazz!=null&& method!=null&&clazz!= LogAop.class){
            //1。获取类上的@RequestMapping("/orders")
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if(classAnnotation!=null){
               String[] classValue =  classAnnotation.value();

               //获取方法上的@RequestMapping的值
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if(methodAnnotation!=null){
                    String[] methodValue = methodAnnotation.value();

                    url=classValue[0]+methodValue[0];


                    //        获取访问的ip
                    String ip = request.getRemoteAddr();


                    //获取当前操作用户
                    //可以通过securityContext获取，也可以从request.getSession中获取
                    SecurityContext context = SecurityContextHolder.getContext();       //从上下文中获取当前登录的用户
                    //request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将日志相关信息封装到SysLog对象
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);      //执行时长
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名]"+clazz.getName()+"[方法名]"+method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);

                    //调用service完成保存操作
                    sysLogService.save(sysLog);
                }

            }
        }

    }



}
