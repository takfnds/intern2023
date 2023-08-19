package com.example.demo.repositories;

import com.example.demo.models.Rice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RiceSaleRepository extends JpaRepository<Rice, Integer> {




}
