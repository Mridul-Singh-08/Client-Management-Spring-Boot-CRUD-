package com.ClientReq.controller;

import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ClientReq.dao.ClientRepo;
import com.ClientReq.dto.Client;
import com.ClientReq.exception.ClientException;


@RestController
@RequestMapping("/api/version1/")
public class ClientController {
	
	@Autowired
	 ClientRepo cr;  

	@PostMapping("/clients")
	public Client createClient(@RequestBody Client client) {
		return cr.save(client);
	}
	
	@GetMapping("/clients")
	public List<Client> getAllClient(){
		return cr.findAll();
		
	}

	


	@GetMapping("/clients/{id}")
	public ResponseEntity <Client> getClientById(@PathVariable int id) throws ClientException {
		
		Client client = cr.findById(id).orElseThrow(()-> new ClientException("Client does not exist with id:" + id));
		
		return ResponseEntity.ok(client);
		
	}
	
	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable int id, @RequestBody Client clientDetails) throws ClientException{
		Client client = cr.findById(id).orElseThrow(() -> new ClientException("Client not exist with id :" + id));
		
		client.setClientName(clientDetails.getClientName());
		client.setRequirement(clientDetails.getRequirement());
		client.setEmailId( clientDetails.getEmailId());
		
		Client updatedClient = cr.save(client);
		return ResponseEntity.ok(updatedClient);
	}
	
	@DeleteMapping("/clients/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteClient(@PathVariable int id) throws ClientException{
		Client client = cr.findById(id).orElseThrow(() -> new ClientException("Client not exist with id :" + id));
		
		cr.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
	


}
