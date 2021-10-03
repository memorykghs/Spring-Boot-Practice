package com.springboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.rest.entity.ResvBiz;

@Repository
public interface ResvBizRepo extends JpaRepository<ResvBiz, String>{

}
