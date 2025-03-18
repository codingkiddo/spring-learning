package com.spring.quickstarts.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
 
@Entity
@Table(name="employees")
public class Employee {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no", nullable = false)
    private int emp_no;
 
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @Column(name = "birth_date", nullable = false)
//    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private Date birth_date;
    
    @Column(name = "first_name", nullable = false)
    private String first_name;
    
    @Column(name = "last_name", nullable = false)
    private String last_name;
 
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @Column(name = "hire_date", nullable = false)
//    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private Date hire_date;
 
    @NotNull
    @Column(name = "gender", columnDefinition = "char(1)")
    @Sex
    private Character gender;

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}
}