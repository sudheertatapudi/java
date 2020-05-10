package com.travel.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travel.entity.Station;

@Repository
public interface StationRepo extends StopBaseRepo<Station> {
	
	Station findByNameAndTrainnumber(String name,String train_no);
	List<Station> findByTrainnumber(String train_no);
	
}