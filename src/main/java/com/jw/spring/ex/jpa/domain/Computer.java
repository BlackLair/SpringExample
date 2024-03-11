package com.jw.spring.ex.jpa.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@Getter
@Setter
public class Computer {
	

	@NonNull
	private String motherboard;
	
	final private String cpu;
	
	private String gpu;
	private int ram;
	private int power;
	private int ssdCapacity;
	private int hddCapacity;
	
}
