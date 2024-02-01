package org.example.dto;

import org.example.entity.Enrollment;
import org.example.entity.Student;

public record EnrolledStudents (
        Student student,
         Enrollment enrollment

){



}
