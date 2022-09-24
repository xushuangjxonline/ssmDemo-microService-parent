package com.jxonline.sword.aspect;

import com.jxonline.sword.annotation.MethodLog;
import com.jxonline.sword.util.JsonUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**用于打印方法执行时间,入参,结果的log的切面
 * @author xs
 * @date 2022/9/24
 **/

//声明当前类是一个切面
@Aspect
//@Component允许在Spring IOC对当前对象实例化并管理
@Component
public class MethodLogAspect {

    //说明切面的作用范围,任何增加了@MethodLog的方法,都将在执行方法前,先执行该切面
    //@Around环绕通知,最强大的通知类型,可以控制方法入参,执行,返回结果等等
    //入参joinPoint(切点) 是加了@MethodLog注解的方法

    @Around("@annotation(com.jxonline.sword.annotation.MethodLog)")
    public Object MethodLog(ProceedingJoinPoint joinPoint)throws Throwable{

        Logger LOGGER = LoggerFactory.getLogger(MethodLog.class);
        long st = new Date().getTime();
        //执行目标方法 获取方法返回值
        Object proceed =joinPoint.proceed();
        long et = new Date().getTime();

        //将入参的json序列化
        String jsonParam = JsonUtil.object2JsonStr(joinPoint.getArgs());
        //将返回结果序列化
        String jsonResult = null;
        if (proceed != null){
            jsonResult = JsonUtil.object2JsonStr(proceed);
        }else{
            jsonResult = "null";
        }

        //将收集到的信息打印
        LOGGER.debug("正在上报服务器请求的调用过程:\ntarget:{}.{}()\nexecution:{}ms,\nparameter:{}\nresult:{}"
                    ,joinPoint.getTarget().getClass().getSimpleName()
                    ,joinPoint.getSignature().getName()
                    ,(et-st)
                    ,jsonParam
                    ,jsonResult);

        return proceed;
    }
}
