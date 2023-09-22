package com.cg.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceAspect {
	
	//This will run just before execution of any method
	@Before(value = "execution(* com.cg.aop..*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Before usersServiceAspect advice >>>");
	}
	
	
	//This will run just after execution of method
		@After(value = "execution(* com.cg.aop..*(..))")
		public void afterAdvice(JoinPoint joinPoint) {
			System.out.println("after usersServiceAspect advice >>>");
		}
		
		//This will run as soon as function return value
		@AfterReturning(value = "execution(* com.cg.aop..*(..))")
		public void afterReturningAdvice(JoinPoint joinPoint) {
			System.out.println("After returning usersServiceAspect advice >>>");
		}
		
		//It executes before and after joint point
		@Around(value = "execution(* com.cg.aop..*(..))")
		public void aroundAdvice(ProceedingJoinPoint joinPoint) {
			System.out.println("Around advice of userServiceAspect >>>");
			try {
				joinPoint.proceed();
			}catch(Throwable e){
				System.out.println("Exception occured "+e);
			}
		}
}
