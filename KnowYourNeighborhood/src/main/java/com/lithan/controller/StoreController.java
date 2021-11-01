package com.lithan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lithan.model.Store;
import com.lithan.service.StoreService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/store")
public class StoreController {
	@Autowired
	public StoreService service;
	
	@GetMapping(value="/")
	public String home() {
		return "Store";}
	
	@PostMapping(value="/addStore")
	public Store addStore(@RequestBody Store sname) {
		System.out.println("Add New Store Controller");
		return service.addStore(sname);}
	 
	@DeleteMapping(value="/deleteStore/{sid}")
	public void deleteStore(@PathVariable int sid) {
		service.deleteStore(sid);}
	
	@GetMapping(value="/allStores")
	public List<Store> getAllStores(){
		return service.getAllStores();}
	
	@GetMapping(value="/allStores/{sid}")
	public Optional<Store> findStoreById(@PathVariable int sid){
		return service.findStoreById(sid);}
	
	@PutMapping(value="/updateStore/{sid}")
	public Store updateStore(@RequestBody Store store, @PathVariable int sid){
		Optional<Store> oldInfo=service.findStoreById(sid);
		if(oldInfo.isPresent()) {
			Store obj=oldInfo.get();
			obj.setSid(store.getSid());
			obj.setSname(store.getSname());
			obj.setPhone(store.getPhone());
			obj.setLocation(store.getLocation());
			return service.addStore(obj);}
		else{
			return null;
		}}
	
	@GetMapping(value="/searchStore/{keyword}")
    public List<Store> searchStoresByKeyword(@PathVariable String keyword){
        return service.search(keyword); }	
}
