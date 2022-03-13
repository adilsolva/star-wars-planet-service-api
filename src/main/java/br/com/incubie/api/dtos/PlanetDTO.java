package br.com.incubie.api.dtos;

import br.com.incubie.api.entities.PlanetEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PlanetDTO {

    private Integer id;
    private String name;
    private String terrain;
    private String atmosphere;
    private Integer filmQty;
    
    public static PlanetDTO toDTO(PlanetEntity entity) {
    	return PlanetDTO.builder()
    			.id(entity.getId())
    			.name(entity.getName())
    			.terrain(entity.getTerrain())
    			.filmQty(entity.getFilmsQty())
    			.atmosphere(entity.getAtmosphere()).build();
    	
    }
}
