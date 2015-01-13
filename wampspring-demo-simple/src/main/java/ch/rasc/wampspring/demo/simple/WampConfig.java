package ch.rasc.wampspring.demo.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import ch.rasc.wampspring.config.DefaultWampConfiguration;
import ch.rasc.wampspring.config.WampEndpointRegistry;
import ch.rasc.wampspring.cra.AuthenticationSecretProvider;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class WampConfig extends DefaultWampConfiguration {

	// Reusing the objectMapper that spring boot provides

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public ObjectMapper objectMapper() {
		return objectMapper;
	}

	@Override
	public void registerWampEndpoints(WampEndpointRegistry registry) {
		registry.addEndpoint("/wamp").withSockJS();
	}

	@Override
	public AuthenticationSecretProvider authenticationSecretProvider() {
		return new MySecretProvider();
	}

}