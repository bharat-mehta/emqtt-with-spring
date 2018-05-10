/**
 * 
 */
package com.bharatmehta.spring.emqtt;

import java.text.MessageFormat;

import org.springframework.integration.handler.AbstractMessageHandler;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/**
 * @author Bharat Mehta
 *
 */
public class MqttMessageHandler extends AbstractMessageHandler {

	public MqttMessageHandler() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	protected void handleMessageInternal(Message<?> message) throws Exception {
		Object payload = message.getPayload();

        MessageHeaders messageHeaders = message.getHeaders();

            String topicForThisMessage = (String) messageHeaders.get(MqttHeaders.RECEIVED_TOPIC);
            System.out.println(MessageFormat.format("Topic: {0}, Message :{1}", topicForThisMessage , payload));
            		
		
	}

	
	

	

	
	
}
