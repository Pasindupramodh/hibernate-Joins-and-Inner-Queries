package org.example.dto;

import org.example.entity.Student;

public record CountedEnrollmentForStudent(
        String student,
        Long count
) {
}
