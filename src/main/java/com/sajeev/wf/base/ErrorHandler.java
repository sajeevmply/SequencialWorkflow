package com.sajeev.wf.base;

import org.springframework.beans.factory.BeanNameAware;

import com.sajeev.wf.exception.WorkflowException;

/**
 * Class:ErrorHandler
 * 
 */
public interface ErrorHandler extends BeanNameAware {

	public void handleError(WorkflowContext context, Throwable th) throws WorkflowException;

}
