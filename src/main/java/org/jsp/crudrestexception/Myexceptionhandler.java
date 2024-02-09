package org.jsp.crudrestexception;

import java.util.NoSuchElementException;

import org.jsp.crudrest.helper.Responsestructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class Myexceptionhandler {
	@Autowired
	Responsestructure<String> structure;

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Responsestructure<String>> handler(DataIntegrityViolationException exception) {
		structure.setMsg("Data Can not be Saved");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Mobile Number Already Exists");

		return new ResponseEntity<Responsestructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Responsestructure<String>> handler(NoSuchElementException exception) {
		structure.setMsg("Data Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());

		return new ResponseEntity<Responsestructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
