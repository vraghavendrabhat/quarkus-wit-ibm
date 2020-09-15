package com.example;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.jboss.logging.Logger;

@LogEvent
@Interceptor
public class LogEventInterceptor {

	private static Logger logger = Logger.getLogger(LogEventInterceptor.class);

	@AroundInvoke
	public Object logEvent(InvocationContext ctx) throws Exception {
		logger.info("started....");
		Object object = ctx.proceed();
		logger.info("finished....");
		return object;
	}

}
