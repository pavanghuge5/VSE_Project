package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Interest;
@Repository
public interface InterestRepository extends JpaRepository<Interest, Integer> {

}
