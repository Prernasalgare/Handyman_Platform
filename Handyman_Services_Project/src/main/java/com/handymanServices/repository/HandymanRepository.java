package com.handymanServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.handymanServices.entity.Handyman;

public interface HandymanRepository extends JpaRepository<Handyman, Long> {
	
	
}


