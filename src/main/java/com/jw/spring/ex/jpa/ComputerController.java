package com.jw.spring.ex.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jw.spring.ex.jpa.domain.Computer;

@Controller
public class ComputerController {
	
	@GetMapping("/computer/mycomputer")
	@ResponseBody
	public Computer getMyComputer() {
//		Computer computer = new Computer();
//		computer.setMotherboard("B550M");
//		computer.setCpu("Ryzen 7 5800X");
//		computer.setGpu("RTX 3070");
//		computer.setRam(32);
//		computer.setSsdCapacity(4096);
//		computer.setHddCapacity(2048);
//		computer.setPower(600);
//		Computer computer = new Computer(
//				"B550"
//				, "Ryzen 7 5800X"
//				, "RTX 3070"
//				, 32
//				, 4096
//				, 2048
//				, 600);
//		Computer computer = Computer.builder()
//				.motherboard("B550M")
//				.cpu("Ryzen 7 5800X")
//				.gpu("RTX 3070")
//				.ram(32)
//				.ssdCapacity(4096)
//				.hddCapacity(2048)
//				.power(600)
//				.build();
		Computer computer = new Computer("B550M", "Ryzen 7 5800X");
		return computer;
	}
}
