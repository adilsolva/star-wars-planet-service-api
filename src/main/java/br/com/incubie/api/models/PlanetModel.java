package br.com.incubie.api.models;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlanetModel {
	
	//	name string -- The name of this planet.
	private String name;
	
	//	diameter string -- The diameter of this planet in kilometers.
	private String diameter;
	
	//	rotation_period string -- The number of standard hours it takes for this planet to complete a single rotation on its axis.
//	private String rotation;
	
	//	orbital_period string -- The number of standard days it takes for this planet to complete a single orbit of its local star.
//	private String orbitalPeriod;
	
	//	gravity string -- A number denoting the gravity of this planet, where "1" is normal or 1 standard G. "2" is twice or 2 standard Gs. "0.5" is half or 0.5 standard Gs.
	private String gravity;
	
	//	population string -- The average population of sentient beings inhabiting this planet.
	private String population;
	
	//	climate string -- The climate of this planet. Comma separated if diverse.
	private String climate;
	
	//	terrain string -- The terrain of this planet. Comma separated if diverse.
	private String terrain;
	
	//	surface_water string -- The percentage of the planet surface that is naturally occurring water or bodies of water.
//	private String surfaceWater;
	
	//	residents array -- An array of People URL Resources that live on this planet.
//	private String[] residents;
	
	//	films array -- An array of Film URL Resources that this planet has appeared in.
	private String[] films;
	
	//	url string -- the hypermedia URL of this resource.
//	private String url;
	
	//	created string -- the ISO 8601 date format of the time that this resource was created.
	private LocalDateTime created;
	
	//	edited string -- the ISO 8601 date format of the time that this resource was edited.
//	private LocalDateTime edited;

}
