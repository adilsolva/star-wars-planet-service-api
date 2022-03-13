package br.com.incubie.api.services;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.incubie.api.clients.StarWarsPlanetClient;
import br.com.incubie.api.clients.StarWarsPlanetResponse;
import br.com.incubie.api.dtos.PlanetDTO;
import br.com.incubie.api.entities.PlanetEntity;
import br.com.incubie.api.models.PlanetModel;
import br.com.incubie.api.repositories.StarWarsPlanetRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StarWarsPlanetService {

	private final StarWarsPlanetClient planetClient;
	private final StarWarsPlanetRepository planetRepository;
	

	public Collection<PlanetDTO> findAll() {
		return planetRepository.findAll().stream().map(PlanetDTO::toDTO).collect(Collectors.toList());
	}

	public PlanetDTO findPlanetByName(String name) {
		
		return planetRepository.findByName(name).map(PlanetDTO::toDTO).get();
	}

	public PlanetDTO findPlanetById(Integer identifier) {
		
		return planetRepository.findById(identifier).map(PlanetDTO::toDTO).get();
	}

	public Collection<PlanetModel> findPlanetsFromStarWarsService(String page) {
		
		return planetClient.getPlanets(page).getResults();
	}

	public PlanetDTO addPlanet(PlanetDTO content) {
		
		final StarWarsPlanetResponse response = planetClient.search(content.getName());
		
		final PlanetModel model = response.getResults()
				.stream()
				.filter(result -> result.getName().equalsIgnoreCase(content.getName()))
				.findFirst().get();
		
		return PlanetDTO.toDTO(
				planetRepository.save(PlanetEntity.toEntity(content, model)));
	}

	public void removePlanet(Integer identifier) {
		
		planetRepository.deleteById(findPlanetById(identifier).getId());
	}

}
