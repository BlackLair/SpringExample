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
@Table(name="new_student")
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="phoneNumber")  // camel case인 경우만 컬럼명 매칭시켜줌
	private String phoneNumber;
	private String email;
	
//	@Column(name="dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp
	@Column(name="createdAt", updatable=false)
	// @UpdateTimestamp는 update시마다 갱신되므로 createdAt은 수정할 수 없도록 한다.
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updatedAt")
	private Date updatedAt;
}
