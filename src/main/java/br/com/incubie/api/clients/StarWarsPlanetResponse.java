package br.com.incubie.api.clients;

import java.util.Collection;

import br.com.incubie.api.models.PlanetModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StarWarsPlanetResponse {

	private Integer count;
	private String next;
	private String previous;
	private Collection<PlanetModel> results;
	
}
