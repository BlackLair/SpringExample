package com.jw.spring.ex.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jw.spring.ex.jpa.domain.Student;
													// <Entity 클래스, primary key 타입>
public interface StudentRepository extends JpaRepository<Student, Integer>{
	// id 기준으로 내림차순으로 정렬한 모든 행 조회
	// ORDER BY `id` DESC
	public List<Student> findAllByOrderByIdDesc();
	
	// id를 기준으로 내림차순으로 정렬 후 2개만 조회
	// ORDER BY `id` DESC LIMIT 2
	public List<Student> findTop2ByOrderByIdDesc();
	
	// name컬럼이 일치하는 데이터 조회
	// WHERE `name` = #{name}
	public List<Student> findByName(String name);
	
	// name 컬럼 일치하는 데이터 조회
	// WHERE `name` IN (#{name1}, #{name2})
	public List<Student> findByNameIn(List<String> nameList);
	
	// email 컬럼에 특정 문자열 포함 데이터 조회
	// WHERE `email` LIKE `%naver%`
	public List<Student> findByEmailContaining(String email);
	
	// id가 특정 값 사이에 속하는 데이터를 id 기준으로 내림차순 조회
	// WHERE `id` BETWEEN 3 AND 5 ORDER BY `id` DESC
	public List<Student> findByIdBetweenOrderByIdDesc(int start, int end);
	
	// Native query : 쿼리를 통한 조회
	// dreamJob 컬럼이 일치하는 데이터 조회
	@Query(value="SELECT * FROM `new_student` WHERE `dreamJob` = :dreamJob", nativeQuery=true)
	public List<Student> findByNativeQuery(@Param("dreamJob") String dreamJob);
}
