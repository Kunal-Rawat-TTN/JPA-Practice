package com.example.demo.Repository;

import com.example.demo.Models.Students.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //    @Query("from Product")
//    List<Product> findAllStudents();
    @Query("from Student")
    List<Student> findAllStudents();

    @Query("select firstName, lastName from Student")
    List<Object[]> findAllStudentsPartial();

    @Query("from Student where firstName=:fname")
    List<Student> findAllStudentsByFirstName(@Param("fname") String fname);

    @Query("from Student where score<:max and score>:min")
    List<Student> findAllStudentsByScores(@Param("min") Integer min, @Param("max") Integer max);

    @Modifying
    @Query("delete from Student where id=:id")
    void deleteStudentById(@Param("id")Long id);

    @Query("from Student")
    List<Student> findAllStudentsPagingAndSorting(Pageable pageable);

    @Query(value = "select * from student", nativeQuery = true)
    List<Student> findAllStudentsNQ();

    @Query(value = "select * from student where fname=:fname", nativeQuery = true)
    List<Student> findAllStudentsByFirstNameNQ(@Param("fname") String fname);
}
