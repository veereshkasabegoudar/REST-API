package org.jsp.crudrest.helper;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Responsestructure<T> {
	String msg;
	int status;
	T data;
}
