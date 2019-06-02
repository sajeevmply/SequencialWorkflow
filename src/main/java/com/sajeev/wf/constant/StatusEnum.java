package com.sajeev.wf.constant;

public enum StatusEnum {
	
	/** The locked. */
	LOCKED (1, "Locked"),
	
	/** The delete. */
	DELETE (2, "Delete"),
	
	/** The inactive. */
	INACTIVE (3, "InActive"),
	
	/** The active. */
	ACTIVE (4, "Active"),
	
	/** The accepted. */
	ACCEPTED (5, "Accept"),
	
	/** The rejected. */
	REJECTED (6, "Reject"),
	
	/** The pending. */
	PENDING (7, "Pending"),
	
	/** The success. */
	SUCCESS (8, "Success"),
	
	/** The Failed. */
	FAILED (9, "Failed"), 
	
	/** The reset. */
	RESET (10 , "Reset"), 
	
	/** The Constant DUPLICATE. */
	DUPLICATE (11, "Duplicate"),
			
	/** The Constant COMPLETED. */
	COMPLETED (12, "Completed"),
	
	/** The Constant PROCESSED. */
	PROCESSED (13, "Processed"),
	
	/** The Constant EXPIRED. */
	EXPIRED (14, "Expired"),
	
	/** The Constant OTP_SENT. */
	OTP_SENT (15, "Otp Send"),
	
	CREATED (16, "Created");
	
	/** The code. */
	private Integer code;
	
	/** The text. */
	private String text;
	
	
	/**
	 * Instantiates a new status enum.
	 *
	 * @param code the code
	 * @param text the text
	 */
	private StatusEnum(Integer code, String text) {
		this.code = code;
		this.text = text;
	}

	/**
	 * Gets the code.
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * Gets the text.
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	public static StatusEnum getStatus(Integer code){
		for(StatusEnum statusEnum: values()){
			if(statusEnum.code.equals(code)){
				return statusEnum;
			}
		}
		return null;
	}
}
