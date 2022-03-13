package br.com.incubie.api.controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.incubie.api.dtos.PlanetDTO;
import br.com.incubie.api.models.PlanetModel;
import br.com.incubie.api.services.StarWarsPlanetService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/planets")
public class StarWarsPlanetController {
	
	private final StarWarsPlanetService planetService;

  @GetMapping
  public ResponseEntity<Collection<PlanetDTO>> findPlanets() {
    return ResponseEntity.ok(planetService.findAll());
  }
  
  @GetMapping("/name")
  public ResponseEntity<PlanetDTO> findPlanetByName(
		  @RequestParam(value = "name") String name) {
    return ResponseEntity.ok(planetService.findPlanetByName(name));
  }
  
  @GetMapping("/identifier")
  public ResponseEntity<PlanetDTO> findPlanetById(
		  @RequestParam(value = "identifier") Integer identifier) {
    return ResponseEntity.ok(planetService.findPlanetById(identifier));
  }
  
  @GetMapping("/integration")
  public ResponseEntity<Collection<PlanetModel>> findPlanetsFromStarWarsService(
		  @RequestParam(value = "page", defaultValue = "1") String page) {
    return ResponseEntity.ok(planetService.findPlanetsFromStarWarsService(page));
  }

  @PostMapping
  public ResponseEntity<PlanetDTO> addPlanet(@RequestBody PlanetDTO content) {
    return ResponseEntity.ok(planetService.addPlanet(content));
  }
  
  @DeleteMapping
  public ResponseEntity<PlanetDTO> removePlanet(
		  @RequestParam(value = "identifier") Integer identifier) {
	  planetService.removePlanet(identifier);
    return ResponseEntity.ok().build();
  }
	
}
