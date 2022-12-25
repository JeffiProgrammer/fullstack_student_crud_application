package com.jeffiprogrammer.studentcrudapp.repositories;

import com.jeffiprogrammer.studentcrudapp.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
