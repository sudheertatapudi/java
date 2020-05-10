package com.travel.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.travel.entity.Station;
import com.travel.entity.Stop;

@NoRepositoryBean
public interface StopBaseRepo<T extends Stop> extends JpaRepository<T, String>{
	
	List<T> findByName(String name);

	List<T> findByCode(String code);
	
	@Query("select distinct s.name from #{#entityName} as s")
	List<String> findnames();
}
