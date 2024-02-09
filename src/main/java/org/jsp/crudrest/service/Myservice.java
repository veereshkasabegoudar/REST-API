package org.jsp.crudrest.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.jsp.crudrest.dao.Mydao;
import org.jsp.crudrest.dto.Student;
import org.jsp.crudrest.helper.Responsestructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class Myservice {
	@Autowired
	Mydao mydao;
	@Autowired
	Responsestructure<Student> structure;
	@Autowired
	Responsestructure<List<Student>> structure1;

	public ResponseEntity<Responsestructure<Student>> insert(Student student) {
		double percentage = (student.getEnglish() + student.getMaths() + student.getScience()) / 3.0;
		student.setPercentage(percentage);

		if (percentage < 60 && student.getEnglish() < 35 || student.getMaths() < 35 || student.getScience() < 35) {
			student.setResult("fail");

		} else {
			if (percentage >= 85)
				student.setResult("Distinction");

			else if (percentage >= 60) {
				student.setResult("First class");
			} else {
				student.setResult("Second class");

			}
		}

		structure.setData(mydao.save(student));
		structure.setMsg("Data saved success");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<Responsestructure<Student>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<Responsestructure<List<Student>>> insertAll(List<Student> student1) {
		for (Student student : student1) {
			double percentage = (student.getEnglish() + student.getMaths() + student.getScience()) / 3.0;
			student.setPercentage(percentage);

			if (percentage < 60 && student.getEnglish() < 35 || student.getMaths() < 35 || student.getScience() < 35) {
				student.setResult("fail");

			} else {
				if (percentage >= 85)
					student.setResult("Distinction");

				else if (percentage >= 60) {
					student.setResult("First class");
				} else {
					student.setResult("Second class");

				}
			}
			structure1.setData(mydao.save(student1));
			structure1.setMsg("Data saved success");
			structure1.setStatus(HttpStatus.CREATED.value());
		}
			return new ResponseEntity<Responsestructure<List<Student>>>(structure1, HttpStatus.CREATED);

		
		

	}

	public ResponseEntity<Responsestructure<List<Student>>> fetchAll() {
		List<Student> student=mydao.finfAll();
		structure1.setData(mydao.save(student));
		structure1.setMsg("Data found success");
		structure1.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<Responsestructure<List<Student>>>(structure1, HttpStatus.FOUND);
		
	}

	

	public ResponseEntity<Responsestructure<Student>> fetchbyid(int id) {
		Student student=mydao.fetchById(id);
		structure.setData(student);
		structure.setMsg("Data found success");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<Responsestructure<Student>>(structure, HttpStatus.FOUND);
			}

	public ResponseEntity<Responsestructure<List<Student>>> fetchByName(String name) {
		List<Student> student=mydao.fetchByName(name);
		structure1.setData(mydao.save(student));
		structure1.setMsg("Data found success");
		structure1.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<Responsestructure<List<Student>>>(structure1,HttpStatus.FOUND);
			
	}
	public ResponseEntity<Responsestructure<Student>> fetchByMobile(long mobile) {
		Student student = mydao.fetchByMobile(mobile);
		if (student == null)
			throw new NoSuchElementException("No Records with mobile: " + mobile);
		structure.setMsg("Data Foud");
		structure.setData(student);
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<Responsestructure<Student>>(structure, HttpStatus.FOUND);

	}

	public ResponseEntity<Responsestructure<List<Student>>> fetchByResult(String result) {
		List<Student> students = mydao.fetchByResult(result);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present with Result: " + result);
		structure1.setMsg("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<Responsestructure<List<Student>>>(structure1, HttpStatus.FOUND);

	}

	public ResponseEntity<Responsestructure<List<Student>>> fetchByPercentageGreater(double percentage) {
		List<Student> students = mydao.fetchByPercentageGreater(percentage);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present with Percentage Greater: " + percentage);
		structure1.setMsg("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<Responsestructure<List<Student>>>(structure1, HttpStatus.FOUND);

	}

	public ResponseEntity<Responsestructure<List<Student>>> fetchByPercentageBetween(double percentage1,
			double percentage2) {
		List<Student> students = mydao.fetchByPercentageBetween(percentage1, percentage2);
		if (students.isEmpty())
			throw new NoSuchElementException(
					"No Records Present with Percentage between: " + percentage1 + " and " + percentage2);
		structure1.setMsg("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<Responsestructure<List<Student>>>(structure1, HttpStatus.FOUND);

	}

	public ResponseEntity<Responsestructure<List<Student>>> fetchByPercentageLesser(double percentage) {
		List<Student> students = mydao.fetchByPercentageLesser(percentage);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure1.setMsg("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<Responsestructure<List<Student>>>(structure1, HttpStatus.FOUND);

	}

	public ResponseEntity<Responsestructure<List<Student>>> fetchByMathsEnglish(int marks) {
		List<Student> students = mydao.fetchByMathsEnglish(marks);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure1.setMsg("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<Responsestructure<List<Student>>>(structure1, HttpStatus.FOUND);

	}

	public ResponseEntity<Responsestructure<List<Student>>> fetchByNameorNumber(String data) {
		List<Student> students = null;
		try {
			students = mydao.fetchByNameOrNumber(null, Long.parseLong(data));
		} catch (NumberFormatException e) {
			students = mydao.fetchByNameOrNumber(data, 0);
		}

		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure1.setMsg("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<Responsestructure<List<Student>>>(structure1, HttpStatus.FOUND);

	}

	public ResponseEntity<Responsestructure<Student>> deleteById(int id) {
		structure.setData(mydao.fetchById(id));
		mydao.deleteById(id);
		structure.setMsg("Data Deleted Success");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<Responsestructure<Student>>(structure, HttpStatus.FOUND);

	}

	public ResponseEntity<Responsestructure<Student>> update(Student student) {
		student.setPercentage((student.getMaths() + student.getScience() + student.getEnglish()) / 3);
		if (student.getScience() < 35 || student.getEnglish() < 35 || student.getMaths() < 35)
			student.setResult("Fail");
		else {
			if (student.getPercentage() >= 85)
				student.setResult("Distinction");
			else if (student.getPercentage() >= 60)
				student.setResult("First Class");
			else
				student.setResult("Second Class");
		}

		structure.setMsg("Data Updated Success");
		structure.setData(mydao.save(student));
		structure.setStatus(HttpStatus.OK.value());

		return new ResponseEntity<Responsestructure<Student>>(structure, HttpStatus.OK);

	}

	public ResponseEntity<Responsestructure<Student>> update(int id, Student student) {
		Student student2 = mydao.fetchById(id);

		if (student.getName() != null)
			student2.setName(student.getName());
		if (student.getMobile() != 0)
			student2.setMobile(student.getMobile());
		if (student.getDob() != null)
			student2.setDob(student.getDob());
		if (student.getMaths() != 0)
			student2.setMaths(student.getMaths());
		if (student.getScience() != 0)
			student2.setScience(student.getScience());
		if (student.getEnglish() != 0)
			student2.setEnglish(student.getEnglish());

		student2.setPercentage((student2.getMaths() + student2.getScience() + student2.getEnglish()) / 3);
		if (student2.getScience() < 35 || student2.getEnglish() < 35 || student2.getMaths() < 35)
			student2.setResult("Fail");
		else {
			if (student2.getPercentage() >= 85)
				student2.setResult("Distinction");
			else if (student2.getPercentage() >= 60)
				student2.setResult("First Class");
			else
				student2.setResult("Second Class");
		}

		structure.setMsg("Data Updated Success");
		structure.setData(mydao.save(student2));
		structure.setStatus(HttpStatus.OK.value());

		return new ResponseEntity<Responsestructure<Student>>(structure, HttpStatus.OK);
	}


	
		
}
