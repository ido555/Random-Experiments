package springBoot.facade;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component // for Spring to recognize this class. can alternatively use @Configuration
@Aspect // for Aspect programming - reflection will read the annotations below
public class EmployeeServiceAspect {
	// 1. method that i want to run an Advice before
	// so Before ANY method that returns employee - execution(Employee packagePath)
	// * - before ANY method that runs
	// package - optional
	// execution - run at a Point in Joint point
	// execution (returnType package.class.method  (method.args) )
	// (..) 0 - infinity args
	// (*,*,*) 3 args of any kind
	@Before("execution(springBoot.beans.Employee * (..)  )")
	public void runBeforeCreateEmployee(JoinPoint joinPoint) {
		System.out.println("BEFORE: " + joinPoint);
	}
	
	@Around("execution(springBoot.beans.Employee * (..)  )")
	public Object wow(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("before");

		//run the method
		Object obj = pjp.proceed();
		System.out.println("after");
		
		return obj;
		
	}
}
