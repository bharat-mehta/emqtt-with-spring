package com.bharatmehta.spring.emqtt;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmqttWithSpringApplicationTests {

	
	@Autowired
	private IMqttClient client;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void test() throws MqttPersistenceException, MqttException {
		client.publish("testTopic", new MqttMessage("TestMessage".getBytes(StandardCharsets.UTF_8)));
	}

}
