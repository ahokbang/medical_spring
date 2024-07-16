package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpDepDto {
	
/*  방법 1
	private int employee_id;
	private String emp_name;
	private String email;
	private String phone_number;
	private Timestamp hire_date;
	private double salary;
//	private int manager_id;
//	private int commission_pct;
//	private Timestamp retire_date;
	private int department_id;
	private String job_id;
//	private Timestamp create_date;
//	private Timestamp update_date;
	
//	private int department_id;
	private String department_name;
	private int parent_id;
//	private int manager_id;
//	private Timestamp create_date;
//	private Timestamp update_date;
*/

//	방법 2
	private int employee_id;
	private String emp_name;
//	private String email;
//	private String phone_number;
	private Timestamp hire_date;
	private double salary;
//	private int manager_id;
//	private int commission_pct;
//	private Timestamp retire_date;
	private int department_id;
//	private String job_id;
//	private Timestamp create_date;
//	private Timestamp update_date;
	
//	private int department_id;
	private String department_name;
	private int parent_id;
//	private int manager_id;
//	private Timestamp create_date;
//	private Timestamp update_date;
	 
	
}
