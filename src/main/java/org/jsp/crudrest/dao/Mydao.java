package org.jsp.crudrest.dao;

import java.util.List;

import org.jsp.crudrest.dto.Student;
import org.jsp.crudrest.repository.Myrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class Mydao {
	@Autowired
	Myrepository myrepository;

	public Student save(Student student) {
		return myrepository.save(student);
	}

	public List<Student> save(List<Student> student1) {
		return myrepository.saveAll(student1);
	}

	public List<Student> finfAll() {

		return myrepository.findAll();
	}

	public Student fetchById(int id) {

		return myrepository.findById(id).get();
	}

	public List<Student> fetchByName(String name) {
		return myrepository.findByName(name);
	}
	public Student fetchByMobile(long mobile) {
		return myrepository.findByMobile(mobile);
	}

	public List<Student> fetchByResult(String result) {
		return myrepository.findByResult(result);
	}

	public List<Student> fetchByPercentageGreater(double percentage) {
		return myrepository.findByPercentageGreaterThanEqual(percentage);
	}

	public List<Student> fetchByPercentageBetween(double percentage1, double percentage2) {
		return myrepository.findByPercentageBetween(percentage1, percentage2);
	}

	public List<Student> fetchByPercentageLesser(double percentage) {
		return myrepository.findByPercentageLessThan(percentage);
	}

	public List<Student> fetchByMathsEnglish(int marks) {
		return myrepository.findByMathsGreaterThanEqualAndEnglishGreaterThanEqual(marks, marks);
	}

	public List<Student> fetchByNameOrNumber(String name, long number) {
		return myrepository.findByNameOrMobile(name, number);
	}

	public void deleteById(int id) {
		myrepository.deleteById(id);
	}

}
