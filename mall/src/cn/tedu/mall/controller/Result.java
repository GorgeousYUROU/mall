package cn.tedu.mall.controller;
import java.io.Serializable;




public class Result implements Serializable{

	private static final long serialVersionUID = 855226553849288642L;
	
	public static final int SUCCESS=1;
	public static final int ERROR=0;
	
	private int state=SUCCESS;
	private String message="ok";
	private Object data=null;
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Result(Throwable e)
	{
		this.state=ERROR;
		message=e.getMessage();
		 System.out.print(100000);
	}
	
	public Result(String successMessage)
	{
		this.state=SUCCESS;
		this.message=successMessage;
	}
	
	public Result(int state, String message, Object data) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
	}

	public Result(Object object) {
		this.state = Result.SUCCESS;
		this.message = "";
		this.data = object;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	

}
