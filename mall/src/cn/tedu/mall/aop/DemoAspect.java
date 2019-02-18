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
		System.out.println("hello world����ʼִ��");
	}
	
	@After("bean(userService) || bean(goodsService) || bean(goodsCategoriesService)")
	public void afterService()
	{
		System.out.println("�ұ�ִ����");
	}
	
	@AfterThrowing("bean(userService) || bean(goodsService) || bean(goodsCategoriesService)")
	public void afterServiceThrowing()
	{
		System.out.println("�ҳ��쳣��");
	}
	
	@AfterReturning("bean(userService) || bean(goodsService) || bean(goodsCategoriesService)")
	public void afterServiceReturning()
	{
		System.out.println("�ҳɹ�������");
	}

}
