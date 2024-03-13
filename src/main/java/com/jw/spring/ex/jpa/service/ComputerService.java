package com.jw.spring.ex.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.spring.ex.jpa.domain.Computer;
import com.jw.spring.ex.jpa.repository.ComputerRepository;

@Service
public class ComputerService {
	@Autowired
	private ComputerRepository computerRepository;
	
	public Computer getComputer(int id) {
		Optional<Computer> optionalComputer = computerRepository.findById(id);
		Computer computer = optionalComputer.orElse(null);
		return computer;
	}
	
	public List<Computer> computerList(){
		return computerRepository.findAllByOrderByPowerDesc();
	}
	
	public Computer createComputer(
			String motherboard
			, String cpu
			, String gpu
			, int ram
			, int power
			, int ssdCapacity
			, int hddCapacity
			) {
		Computer computer = computerRepository.save(Computer.builder()
				.motherboard(motherboard)
				.cpu(cpu)
				.gpu(gpu)
				.ram(ram)
				.power(power)
				.ssdCapacity(ssdCapacity)
				.hddCapacity(hddCapacity)
				.build());
		return computer;
	}
	
	public Computer updateComputerRam(int id, int ram) {
		Optional<Computer> optionalComputer = computerRepository.findById(id);
		Computer computer = optionalComputer.orElse(null);
		if(computer != null) {
			computer = computer.toBuilder()
					.ram(ram)
					.build();
			return computerRepository.save(computer);
		}
		return null;
	}
	
	public boolean deleteComputer(int id) {
		Optional<Computer> optionalComputer = computerRepository.findById(id);
		Computer computer = optionalComputer.orElse(null);
		if(computer != null) {
			computerRepository.delete(computer);
			return true;
		}
		return false;
	}
}
