package com.project.professor.alocation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.professor.alocation.model.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
