package br.com.incubie.api.entities;

import br.com.incubie.api.dtos.PlanetDTO;
import br.com.incubie.api.models.PlanetModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PLANET")
public class PlanetEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NAME")
    private String name;
    
    @Column(name = "TERRAIN")
    private String terrain;
    
    @Column(name = "FILMS_QTY")
    private Integer filmsQty;
    
    @Column(name = "ATMOSPHERE")
    private String atmosphere;
    
    
    public static PlanetEntity toEntity(PlanetDTO dto, PlanetModel model) {
    	return PlanetEntity.builder()
    			.id(dto.getId())
    			.name(dto.getName())
    			.terrain(dto.getTerrain())
    			.filmsQty(model.getFilms().length)
    			.atmosphere(dto.getAtmosphere()).build();
    }
    
}
