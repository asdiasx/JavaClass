package com.adrianodias.userdeptmnt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.adrianodias.userdeptmnt.entities.User;
import com.adrianodias.userdeptmnt.repositories.UserRepository;

@RestController
//@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/users")
	public List<User> findAll() {
		List<User> result = repository.findAll();
		return result;

	}

	@GetMapping(value = "users/{id}")
	public User findById(@PathVariable Long id) {
		User result = repository.findById(id).get();
		return result;

	}

	@PostMapping
	public User insert(@RequestBody User user) {
		User result = repository.save(user);
		return result;
	}	

	@GetMapping(value = "/loterias")
	public String getLotteryResults() {
//		String url = "https://servicebus2.caixa.gov.br/portaldeloterias/api/home/ultimos-resultados";
		String url = "https://servicebus2.caixa.gov.br/portaldeloterias/api/lotofacil";
//		RestTemplate rest = new RestTemplate();
		Object results = restTemplate.getForObject(url, Object.class);

		return results.toString();

	}

}
