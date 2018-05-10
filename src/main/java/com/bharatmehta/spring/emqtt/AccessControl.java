/**
 * 
 */
package com.bharatmehta.spring.emqtt;

import java.util.Map;

/**
 * @author Bharat Mehta
 *
 */
public interface AccessControl {
	
	
	
	/**
	 * Configures a client's access on a Mqtt topic.The method replaces the existing permission for the topic
	 * @param client Client Id
	 * @param topic Topic name or Topic filter
	 * @param permission 
	 */
	public void configure(String client, String topic, BrokerPermission permission);
	
	
	/**
	 * Configures a client with map of topic filters and broker permission. Replaces older ACLs with new ACLs
	 * @param client
	 * @param permission
	 */
	public void configure(String client, Map<String,BrokerPermission> permission);
	
	
	/**
	 * Returns a map with topic names/ topic filters and permissions
	 * @param client Client Id
	 * @return
	 */
	public Map<String,BrokerPermission> get(String client);

}
