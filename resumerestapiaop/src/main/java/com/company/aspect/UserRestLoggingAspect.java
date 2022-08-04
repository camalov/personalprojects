package com.company.aspect;

import com.company.dto.ResponseDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserRestLoggingAspect {

    //order(3)
    @Before("execution(* com.company.controller.UserRestController.getAllUser(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println
                ("LogBefore is running()\n"
                        + joinPoint.getSignature().getName()
                        + "\n**********"
                );
    }

    //order(5)
    @After("execution(* com.company.controller.UserRestController.getAllUser(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println
                ("LogAfter is running()\n"
                        + joinPoint.getSignature().getName()
                        + "\n**********"
                );
    }

    /*
        // order(1)
        @Around("execution(* com.company.controller.UserRestController.getAllUser(..))")
        public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
            System.out.println
                    ("LogAround is running()\n"
                            + joinPoint.getSignature().getName()
                            + "\n**********"
                    );

            Object obj = joinPoint.proceed(); // order(2)

            // order(6)
            System.out.println("in around. last step. printing value : " + obj);
        }
    */
    // order(4)
    @AfterReturning(
            pointcut = "execution(* com.company.controller.UserRestController.getAllUser(..))",
            returning = "retVal")
    public ResponseEntity<ResponseDTO> logAfterReturning(JoinPoint joinPoint, ResponseEntity<ResponseDTO> retVal) {
        System.out.println
                ("AfterReturning is running()\n"
                        + joinPoint.getSignature().getName()
                        + "\n**********"
                );

//        System.out.println(retVal);
//
//        ResponseEntity<ResponseDTO> re = (ResponseEntity<ResponseDTO>) retVal;
//
//        System.out.println(re);
        return retVal;
    }

    @AfterThrowing(pointcut = "execution(* com.company.controller.UserRestController.getAllUser(..)) ",
            throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        System.out.println("LogAfterThrowing is running");
        System.out.println(joinPoint.getSignature().getName());
        System.out.println(ex.getMessage());
    }

}
