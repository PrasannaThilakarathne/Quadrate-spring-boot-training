package com.springAOP.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LogginAspect {
	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		
		Object proceed = joinPoint.proceed();
		
		long executionTime = System.currentTimeMillis()-start;
		
		System.out.printf("%s executed in %sms %s", joinPoint.getSignature(), executionTime, System.lineSeparator());
		
		return proceed;
		
	}
}
