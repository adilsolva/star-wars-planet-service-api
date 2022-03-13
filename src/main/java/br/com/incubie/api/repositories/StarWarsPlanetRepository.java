package br.com.incubie.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.incubie.api.entities.PlanetEntity;

public interface StarWarsPlanetRepository extends JpaRepository<PlanetEntity, Integer> {

	 List<PlanetEntity> findAll();
	 
	 Optional<PlanetEntity> findByName(String name);
	 
	 Optional<PlanetEntity> findById(Integer identifier);
	 
}
