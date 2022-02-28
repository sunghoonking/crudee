package com.example.demo.Repository;

import com.example.demo.dto.response.StudentResponseDto;
import com.example.demo.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


   Page<Student> findAllByOrderByCreatedAtDesc(Pageable pageable);
}
