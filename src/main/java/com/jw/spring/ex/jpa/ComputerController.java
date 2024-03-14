package com.jw.spring.ex.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jw.spring.ex.jpa.domain.Computer;
import com.jw.spring.ex.jpa.service.ComputerService;

@Controller
public class ComputerController {
	@Autowired
	private ComputerService computerService;
	
	@GetMapping("/computer/search")
	@ResponseBody
	public Computer getMyComputer(@RequestParam("id") int id) {
		return computerService.getComputer(id);
	}
	
	@GetMapping("/computer/list")
	@ResponseBody
	public List<Computer> computerList(){
		return computerService.computerList();
	}
	
	@GetMapping("/computer/create")
	@ResponseBody
	public Computer createComputer() {
		return computerService.createComputer(
				"B550M"
				, "Ryzen 7 5800X"
				, "RTX 3070"
				, 32
				, 600
				, 4096
				, 2048);
	}
	
	@GetMapping("/computer/update")
	@ResponseBody
	public Computer updateComputer(@RequestParam("id") int id, @RequestParam("ram") int ram) {
		return computerService.updateComputerRam(id, ram);
	}
	
	@GetMapping("/computer/remove")
	@ResponseBody
	public String removeComputer(@RequestParam("id") Integer id) {
		if(computerService.deleteComputer(id)) {
			return "삭제되었습니다.";
		}
		return "삭제 실패";
	} 
}
