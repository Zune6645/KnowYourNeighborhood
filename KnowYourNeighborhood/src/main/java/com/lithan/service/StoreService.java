package com.lithan.service;
import java.util.List;
import java.util.Optional;

import com.lithan.model.Store;

public interface StoreService {
	Store addStore(Store sname);
	List<Store> getAllStores();
	void deleteStore(int sid);
	Optional<Store> findStoreById(int sid);
	public List<Store> search(String keyword);
}


