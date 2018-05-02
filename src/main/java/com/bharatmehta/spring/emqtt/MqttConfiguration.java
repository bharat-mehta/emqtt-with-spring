package com.bharatmehta.spring.emqtt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.handler.AbstractMessageHandler;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;


@Configuration
public  class MqttConfiguration {


	
	@Bean
	public String clientId() {
		return new String("emqtt-with-spring");
	}

	@Bean
	public AbstractMessageHandler mqttMessageHandler() {
		MqttMessageHandler messageHandler = new MqttMessageHandler();
		return messageHandler;
	}
	
	@Bean
	public IntegrationFlow mqttInFlow() {
		return IntegrationFlows.from(mqttInbound())
				.handle(mqttMessageHandler())
				.get();
	}
	
	@Bean
	public MqttPahoClientFactory mqttPahoClientFactory() {
		DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
		factory.setServerURIs("tcp://localhost:1883");
		factory.setCleanSession(true);
		factory.setConnectionTimeout(3000);
		factory.setUserName("guest");
		factory.setUserName("guest");
		return factory;
	}

	
	@Bean
	public MessageProducerSupport mqttInbound() {
		
	
		MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(
				clientId(),
				 mqttPahoClientFactory(),
				 new String[] {"testTopic1","testTopic2","testTopic"});
		adapter.setCompletionTimeout(5000);
		adapter.setConverter(new DefaultPahoMessageConverter());
		adapter.setQos(QualityOfService.AT_LEAST_ONCE.ordinal());
		return adapter;
	}
	
	@Bean
    public MessageChannel channel() {

    	return new DirectChannel();

    }
}