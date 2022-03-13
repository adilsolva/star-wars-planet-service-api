package br.com.incubie.api.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "StarWarsFeignClient", configuration = FeignStarWarsConfiguration.class, url = "${star-wars-api.base-url}")
public interface StarWarsPlanetClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/planets")
    StarWarsPlanetResponse getPlanets(@RequestParam String page);
	
	@RequestMapping(method = RequestMethod.GET, value = "/planets")
    StarWarsPlanetResponse search(@RequestParam String search);

}
