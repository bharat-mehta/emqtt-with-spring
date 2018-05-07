/**
 * 
 */
package com.bharatmehta.spring.emqtt;

/**
 * @author Bharat Mehta
 *
 */
public enum BrokerPermission {
	
	BLOCKED(0),
	READ(1),
	WRITE(2),
	READ_WRITE(3);
	
	int value;

	private BrokerPermission(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	
	
	

}
