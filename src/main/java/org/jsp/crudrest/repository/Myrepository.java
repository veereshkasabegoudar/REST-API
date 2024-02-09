package org.jsp.crudrest.repository;

import java.util.List;

import org.jsp.crudrest.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Myrepository extends JpaRepository<Student, Integer>{

	List<Student> findByName(String name);

	Student findByMobile(long mobile);

	List<Student> findByPercentageGreaterThanEqual(double percentage);

	List<Student> findByPercentageBetween(double percentage1, double percentage2);

	List<Student> findByPercentageLessThan(double percentage);

	List<Student> findByMathsGreaterThanEqualAndEnglishGreaterThanEqual(int marks, int marks2);

	List<Student> findByNameOrMobile(String name, long number);

	List<Student> findByResult(String result);

}
