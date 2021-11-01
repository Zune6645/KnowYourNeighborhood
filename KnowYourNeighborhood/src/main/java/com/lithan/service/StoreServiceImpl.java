package com.lithan.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lithan.model.Store;
import com.lithan.repository.StoreRepository;
@Service
@Transactional
public class StoreServiceImpl implements StoreService {
	@Autowired
	public StoreRepository repo;
	
	@Override
	public Store addStore(Store sname) {
		System.out.println("Add New Store Service");
		return repo.save(sname);}
	
	@Override
	public List<Store> getAllStores() {
		return repo.findAll();}
	
	@Override
	public void deleteStore(int sid) {
		repo.deleteById(sid);}
	
	@Override
	public Optional<Store> findStoreById(int sid) {
		return repo.findById(sid);}

	@Override
	public List<Store> search(String keyword) {
		return repo.search(keyword);}
}
