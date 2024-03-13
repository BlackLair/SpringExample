package com.jw.spring.ex.jpa.domain;

import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="computers")
@Entity
public class Computer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String motherboard;
	private String cpu;
	private String gpu;
	private int ram;
	private int power;
	private int ssdCapacity;
	private int hddCapacity;
	
	@UpdateTimestamp
	@Column(updatable=false)
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
}
