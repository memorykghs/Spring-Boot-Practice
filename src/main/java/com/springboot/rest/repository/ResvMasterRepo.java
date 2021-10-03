package com.springboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.rest.entity.ResvMaster;

@Repository
public interface ResvMasterRepo extends JpaRepository<ResvMaster, String>{

}
