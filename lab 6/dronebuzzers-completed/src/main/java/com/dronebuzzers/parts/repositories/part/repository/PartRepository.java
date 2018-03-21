package com.dronebuzzers.parts.repositories.part.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dronebuzzers.parts.repositories.part.Part;

@Repository
public interface PartRepository extends JpaRepository<Part, Long>{
	
	List<Part> findAll();

	List<Part> findByType(String type);

	List<Part> findByCategory(String category);

	Part findByPartId(String id);


}
