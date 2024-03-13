package com.jw.spring.ex.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jw.spring.ex.jpa.domain.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Integer>{
	public List<Computer> findAllByOrderByPowerDesc();
}
