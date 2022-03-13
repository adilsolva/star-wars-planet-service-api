package br.com.incubie.api.configurations;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class CustomerContractsHealthIndicator implements HealthIndicator {

	@Override 
	public Health health() {
		return new Health.Builder(Status.UP).build();
	}
}