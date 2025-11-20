package com.mayuri.studentcrud.service.impl;

import com.mayuri.studentcrud.model.Student;
import com.mayuri.studentcrud.repository.StudentRepository;
import com.mayuri.studentcrud.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository repository;

	public StudentServiceImpl(StudentRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Student> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Student> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Student save(Student student) {
		return repository.save(student);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}