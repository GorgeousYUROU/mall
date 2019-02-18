package cn.tedu.mall.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspect {
	
	@Before("bean(userService) || bean(goodsService) || bean(goodsCategoriesService)")
	public void beforeService()
	{
		System.out.println("hello world，开始执行");
	}
	
	@After("bean(userService) || bean(goodsService) || bean(goodsCategoriesService)")
	public void afterService()
	{
		System.out.println("我被执行了");
	}
	
	@AfterThrowing("bean(userService) || bean(goodsService) || bean(goodsCategoriesService)")
	public void afterServiceThrowing()
	{
		System.out.println("我出异常了");
	}
	
	@AfterReturning("bean(userService) || bean(goodsService) || bean(goodsCategoriesService)")
	public void afterServiceReturning()
	{
		System.out.println("我成功返回了");
	}

}
