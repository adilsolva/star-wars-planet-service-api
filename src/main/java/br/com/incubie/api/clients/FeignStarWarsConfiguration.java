package br.com.incubie.api.clients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.incubie.api.exceptions.FeignException;
import feign.Logger;
import feign.RequestInterceptor;
import feign.okhttp.OkHttpClient;

@Configuration
public class FeignStarWarsConfiguration {

	@Bean
	public RequestInterceptor requestInterceptor() {
		return requestTemplate -> {
			requestTemplate.header("Content-Type", "application/json");
			requestTemplate.header("Accept", "application/json");
		};
	}

	@Bean
	public OkHttpClient client() {
		return new OkHttpClient();
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	public FeignException customFeignExceptionLogging() {
		return new FeignException();
	}

}
