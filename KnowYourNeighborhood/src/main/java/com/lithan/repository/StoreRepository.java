package com.lithan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lithan.model.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {
	@Query(value =
			  "SELECT s FROM Store s WHERE s.sid LIKE '%' || :keyword || '%'" +
			  " OR s.sname LIKE '%' || :keyword || '%'" +
			  " OR s.phone LIKE '%' || :keyword || '%'" +
			  " OR s.location LIKE '%' || :keyword || '%'")
			  public List<Store>
			  search(@Param("keyword") String keyword);
}



