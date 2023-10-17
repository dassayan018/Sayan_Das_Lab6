package com.sayan.CollegeFest.service;

import java.util.List;

import com.sayan.CollegeFest.entity.Student;

public interface StudentService {
	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student theBook);

	public void deleteById(int theId);
}
