package de.stattauto.demo.restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.stattauto.demo.entity.Kunde;
import de.stattauto.demo.repository.KundenRepository;

@RefreshScope // enable /actuator/refresh to refresh config
@RestController
public class DemoRestController {
	
	private KundenRepository repo;
	
	@Value("${welcome.msg}")
	private String welcomeMsg;
	
	public DemoRestController(KundenRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return String.format("%s %s", welcomeMsg, name);
	}
	
	@GetMapping("/hello2")
	public String hello(@RequestParam String vorname, @RequestParam String nachname) {
		return "Hello " + vorname + " " + nachname;
	}
	
	@GetMapping("/kunde/{id}")
	public ResponseEntity<Kunde> holeKundenMitId(@PathVariable Long id){
		Optional<Kunde> kunde = repo.findById(id);
		if (kunde.isPresent()) {
			return new ResponseEntity<Kunde>(kunde.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Kunde>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/kunde2/{id}")
	public Kunde holeKundenMitId(@PathVariable("id") Kunde kunde){
		return kunde;
	}
	
	@PostMapping("/kunde")
	public void kundeHinzufuegen(@RequestBody Kunde kunde){
		repo.save(kunde);
	}
	
	@DeleteMapping("/kunde/{id}")
	public void kundeLoeschen(@PathVariable Long id){
		repo.deleteById(id);
	}

}
