package com.example.demo.Repository;

import com.example.demo.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface SubjectRepository extends JpaRepository<Subject,Long> {

       Optional<Subject> findBySubject(String subject);






}
