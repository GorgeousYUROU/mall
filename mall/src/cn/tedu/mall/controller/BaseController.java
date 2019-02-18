package cn.tedu.mall.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class BaseController {

	public BaseController() {
		super();
	}

	/**
	 * @ExceptionHandler �� Spring MVC �ṩ��ͳһ�쳣�������� ���Լ��쳣������̼���try...catch
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result HandleException(Exception e) {
		e.printStackTrace();
		
		return new Result(e);
	}

}