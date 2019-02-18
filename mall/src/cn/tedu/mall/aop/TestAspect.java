package cn.tedu.mall.aop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.concurrent.LinkedBlockingQueue;

import javax.annotation.PostConstruct;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {
	private File file;
	private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(1000);
	private Thread writeThread;
	
	@PostConstruct
	public void init(){
		file = new File("E:/log.txt");
		writeThread = new Thread(){
			public void run(){
				while(true){
					try{
						String log = queue.take();
						PrintWriter out = new PrintWriter(new FileOutputStream(file,true)); 
						out.println(log);
						
						out.close();
						System.out.println(log);
						
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		};
		writeThread.start();
	}
	
	@Around("bean(*Service)")
	public Object test(ProceedingJoinPoint joinPoint) throws Throwable{
		
		Signature signature = joinPoint.getSignature();
		long t1 = System.nanoTime();
		Object obj = joinPoint.proceed();
		long t2 = System.nanoTime();
		long t=t2-t1;
		queue.put(signature+"Ê±¼ä"+":"+t);
		return obj;
	}

}
