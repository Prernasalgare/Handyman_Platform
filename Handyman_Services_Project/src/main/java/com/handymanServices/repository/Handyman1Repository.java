package com.handymanServices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.handymanServices.entity.Handyman1;

public interface Handyman1Repository extends JpaRepository<Handyman1, Long> {
    Optional<Handyman1> findByNameIgnoreCase(String name);
}
