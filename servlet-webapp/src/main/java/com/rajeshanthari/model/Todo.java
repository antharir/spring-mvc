package com.rajeshanthari.model;

import java.util.Date;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

	private int id;
	private String user;
	@Size(min = 6, message = "Enter at least 6 charaters")
	private String desc;
	private Date targetDate;
	private boolean done;

}
