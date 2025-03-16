package com.example.demo;

import com.example.demo.Models.Students.Student;
import com.example.demo.Repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Rollback(value = false)
class DemoApplicationTests {

	@Autowired
	ProductService productService;

	@Autowired
	StudentRepository studentRepository;

//	@Test
//	void testingL1Cache()
//	{
//		productService.testingL1Cache();
//	}

	@Test
	void insertValuesInStudent()
	{
		Student student=new Student();
		student.setScore(98);
		student.setFirstName("Kunal");
		student.setLastName("Rawat");

		Student student2=new Student();
		student2.setScore(78);
		student2.setFirstName("Akshat");
		student2.setLastName("Shrivastva");

		studentRepository.save(student);
		studentRepository.save(student2);
	}

	@Test
	void testFindAll()
	{
		List<Student> allStudents = studentRepository.findAllStudents();
		System.out.println(allStudents);
//		List<Product> allStudents = studentRepository.findAllStudents();
//		System.out.println(allStudents);
	}

	@Test
	void testFindAllPartial()
	{
//		List of records
//		Each record will have a array of object having different values
		studentRepository.findAllStudentsPartial().forEach(student-> Arrays.asList(student).forEach(System.out::println));
	}
	@Test
	void testFindAllName()
	{
		studentRepository.findAllStudentsByFirstName("Kunal").forEach(System.out::println);
	}
	@Test
	void testFindbtwScores()
	{
		studentRepository.findAllStudentsByScores(80,99).forEach(System.out::println);
	}

	@Test
	@Transactional  // Without @Transactional, Spring throws InvalidDataAccessApiUsageException because modifying queries require a transactional context.
	void testdeleteById()
	{
		studentRepository.deleteStudentById(252L);
	}

	@Test
	void testFindAllPagingAndSorting()
	{
		List<Student> allStudents = studentRepository.findAllStudentsPagingAndSorting(PageRequest
				.of(0,3, Sort.by(Sort.Order.desc("id"))));
		System.out.println(allStudents);
	}

	@Test
	void testFindAllNQ()
	{
		List<Student> allStudents = studentRepository.findAllStudentsNQ();
		System.out.println(allStudents);
	}

	@Test
	void testFindAllNameNQ()
	{
		studentRepository.findAllStudentsByFirstNameNQ("Kunal").forEach(System.out::println);
	}
}
