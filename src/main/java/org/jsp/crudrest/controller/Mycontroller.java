package org.jsp.crudrest.controller;

import java.util.List;

import org.jsp.crudrest.dto.Student;
import org.jsp.crudrest.helper.Responsestructure;
import org.jsp.crudrest.service.Myservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Mycontroller {
	@Autowired
	Myservice myservice;

	// save one record
	@PostMapping("/students")
	public ResponseEntity<Responsestructure<Student>> insert(@RequestBody Student student) {
		return myservice.insert(student);
	}

	// save multiple record
	@PostMapping("/students/many")
	public ResponseEntity<Responsestructure<List<Student>>> insert(@RequestBody List<Student> student) {
		return myservice.insertAll(student);
	}

	@GetMapping("/students")
	public ResponseEntity<Responsestructure<List<Student>>> fetchAll() {
		return myservice.fetchAll();
	}

	@GetMapping("/students/name")
	public ResponseEntity<Responsestructure<List<Student>>> fetchByName(@RequestParam String name) {
		return myservice.fetchByName(name);
	}

	@GetMapping("/students/id")
	public ResponseEntity<Responsestructure<Student>> fetchbyid(@RequestParam int id) {
		
		return myservice.fetchbyid(id);

	}
	// Fetch By Mobile
		@GetMapping("/students/mobile/{mobile}")
		public ResponseEntity<Responsestructure<Student>> fetchByMobile(@PathVariable long mobile) {
			return myservice.fetchByMobile(mobile);
		}

		// Fetch By Result
		@GetMapping("/students/result/{result}")
		public ResponseEntity<Responsestructure<List<Student>>> fetchByResult(@PathVariable String result) {
			return myservice.fetchByResult(result);
		}

		// Fetch By Percentage Greater
		@GetMapping("/students/percentage/greater/{percentage}")
		public ResponseEntity<Responsestructure<List<Student>>> fetchByPercentageGreater(@PathVariable double percentage) {
			return myservice.fetchByPercentageGreater(percentage);
		}

		// Fetch By Percentage Between
		@GetMapping("/students/percentage/{percentage1}/{percentage2}")
		public ResponseEntity<Responsestructure<List<Student>>> fetchByPercentageBetween(@PathVariable double percentage1,
				@PathVariable double percentage2) {
			return myservice.fetchByPercentageBetween(percentage1, percentage2);
		}

		// Fetch By Percentage Lesser
		@GetMapping("/students/percentage/lesser/{percentage}")
		public ResponseEntity<Responsestructure<List<Student>>> fetchByPercentageLesser(@PathVariable double percentage) {
			return myservice.fetchByPercentageLesser(percentage);
		}

		// Fetch By Maths and English
		@GetMapping("/students/maths/english/{marks}")
		public ResponseEntity<Responsestructure<List<Student>>> fetchByMathsEnglish(@PathVariable int marks) {
			return myservice.fetchByMathsEnglish(marks);
		}

		// Fetch By Name or Number
		@GetMapping("/students/nameornumber/{data}")
		public ResponseEntity<Responsestructure<List<Student>>> fetchByNameorNumber(@PathVariable String data) {
			return myservice.fetchByNameorNumber(data);
		}

		// Delete By Id
		@DeleteMapping("/students/id/{id}")
		public ResponseEntity<Responsestructure<Student>> deleteById(@PathVariable int id) {
			return myservice.deleteById(id);
		}

		// Update One Record
		@PutMapping("/students")
		public ResponseEntity<Responsestructure<Student>> update(@RequestBody Student student) {
			return myservice.update(student);
		}
		
		//Update Particular 
		@PatchMapping("/students/id/{id}")
		public ResponseEntity<Responsestructure<Student>> update(@PathVariable int id,@RequestBody Student student) {
			return myservice.update(id,student);
		}
}
