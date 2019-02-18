package cn.tedu.mall.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class BaseController {

	public BaseController() {
		super();
	}

	/**
	 * @ExceptionHandler 是 Spring MVC 提供的统一异常处理方法， 可以简化异常处理过程减少try...catch
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