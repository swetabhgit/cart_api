package com.example.cart.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.cart.model.Item;
import com.example.cart.ItemRepository;

@RestController
public class ItemController {

	@Autowired
	private ItemRepository repository;
	@PostMapping("/addItem")
	 public ResponseEntity<String> newItem(@RequestBody Item newItem) {
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.set("Content-Type", "application/json");
	    repository.save(newItem);
	    return new ResponseEntity<String>(newItem.toString(), httpHeader, HttpStatus.ACCEPTED);
	  }
	@GetMapping("/items")
	public List<Item> getItems()
	{
		return repository.findAll();
	}
	@PutMapping("/deleteitem")
	public Optional<Item> deleteItem(@RequestParam String id)
	{
		Optional<Item> requiredItem = repository.findById(id);
		if(requiredItem != null)
		{
			
			repository.deleteById(id);
		}
		return requiredItem;
		}
	@GetMapping("/item") 
	ResponseEntity<String> getByItemId(@RequestParam String id)
	{

		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.set("Content-Type", "application/json");
		try
		{
		Item requiredItem = repository.getById(id);
		
		 return new ResponseEntity<String>(requiredItem.toString(), httpHeader, HttpStatus.ACCEPTED);		
		}
		catch(EntityNotFoundException e)
		{
			 return new ResponseEntity<String>("{\"message\""+":"+"\"item not found\"}", httpHeader, HttpStatus.NOT_FOUND);		
		}
	}
}
