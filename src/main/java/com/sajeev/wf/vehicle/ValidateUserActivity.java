package com.sajeev.wf.vehicle;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import com.sajeev.wf.base.BaseActivity;
import com.sajeev.wf.base.WorkflowContext;
import com.sajeev.wf.bom.RequestModel;
import com.sajeev.wf.constant.ServiceErrorConstants;
import com.sajeev.wf.constant.StatusEnum;
import com.sajeev.wf.domain.User;
import com.sajeev.wf.exception.WorkflowException;


public class ValidateUserActivity extends BaseActivity {

	/** The Constant ACTIVITY_NAME. */
	private static final String ACTIVITY_NAME = ValidateUserActivity.class.getName();

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(ValidateUserActivity.class);
	
	
	@Override
	public WorkflowContext execute(WorkflowContext context) throws WorkflowException {
		
		LOG.info("Executing " + ACTIVITY_NAME + "...");
		
		VehicleWorkflowContext oContext = (VehicleWorkflowContext) context;
		
		RequestModel requestModel = oContext.getRequestModel();
		LOG.info(requestModel);
		
		List<User> userList = new ArrayList<User>();
		//TODO::Comment the below to check exception--start
		User usr = new User();
		usr.setId("F597413");
		usr.setStatus(StatusEnum.ACTIVE.getCode());
		userList.add(usr);
		//--end
		//If user id does't exists
		if(userList == null || CollectionUtils.isEmpty(userList)){
			throw new WorkflowException(ServiceErrorConstants.INVALID_USER);
		}
		
		User user = userList.get(0);
		
		//If user status is neither ACTIVE nor CREATED
		if(user.getStatus().intValue() != StatusEnum.ACTIVE.getCode().intValue()
				&& user.getStatus().intValue() != StatusEnum.CREATED.getCode().intValue()){
			throw new WorkflowException(ServiceErrorConstants.INVALID_USER);
		}

		oContext.setUser(user);
		
		LOG.info("Execution of " + ACTIVITY_NAME + " completed.");
		return context;
	}

}
