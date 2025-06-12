package com.handymanServices.repository;


import com.handymanServices.entity.Handyman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HandymanRepository extends JpaRepository<Handyman, Long> {
}


