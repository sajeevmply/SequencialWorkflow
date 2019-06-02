package com.sajeev.wf.base;

import com.sajeev.wf.exception.WorkflowException;


public interface Activity {

	/**
	 * Called by the encompassing processor to activate the execution of the Activity
	 * 
	 * @param context
	 *            - process context for this workflow
	 * @return resulting process context
	 * @throws Exception
	 */
	public WorkflowContext execute(WorkflowContext context) throws WorkflowException;

	/**
	 * Get the fine-grained error handler wired up for this Activity
	 * 
	 * @return
	 */
	public ErrorHandler getErrorHandler();

	public String getBeanName();

}
