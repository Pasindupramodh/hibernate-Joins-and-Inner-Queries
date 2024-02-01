package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.dto.CountedEnrollmentForStudent;
import org.example.dto.EnrolledStudents;
import org.example.entity.Student;
import org.example.persistence.PersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Map<String, String> props = new HashMap<>();

        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "none");


//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new PersistenceUnitInfo(), props);
        EntityManager entityManager = emf.createEntityManager();//represent the context
        try {
            entityManager.getTransaction().begin();

//            String jpql = """
//                    select s,e from Student s INNER JOIN s.enrollments e
//                    """
//            String jpql = """
//                    select s,e from Student s JOIN s.enrollments e
//                    """;
//            String jpql = """
//                    select s,e from Student s ,Enrollment e where s.id = e.student.id
//                    """;
//            String jpql = """
//                    select s,e from Student s ,Enrollment e where s = e.student
//                    """;
//            String jpql = """
//                    select s,e from Student s LEFT JOIN s.enrollments e
//                    """;
//            String jpql = """
//                    select s,e from Student s LEFT JOIN s.enrollments e
//                    """;
//            TypedQuery<Object[]> q= entityManager.createQuery(jpql,Object[].class);
//            q.getResultList().forEach(
//                    objects ->
//                            System.out.println(objects[0]+" "+objects[1])
//            );
//            String jpql = """
//                    select NEW  org.example.dto.EnrolledStudents(s,e) from Student s JOIN s.enrollments e
//                    """;
//            TypedQuery<EnrolledStudents> q= entityManager.createQuery(jpql,EnrolledStudents.class);
//            q.getResultList().forEach(
//                    object ->
//                            System.out.println(object.student()+" "+object.enrollment())
//            );
//            String jpql = """
//                    select s FROM Student s WHERE
//                    (SELECT COUNT (e) FROM Enrollment  e WHERE e.student.id = s.id)>1
//                    """;
//
//            TypedQuery<Student> query = entityManager.createQuery(jpql,Student.class);
//            query.getResultList().forEach(student -> System.out.println(student));

//            String jpql = """
//                    select (SELECT COUNT (e) FROM Enrollment e WHERE e.student=s) FROM Student s
//                    """;
//
//            TypedQuery<Long> query = entityManager.createQuery(jpql,Long.class);
//            query.getResultList().forEach(count -> System.out.println(count));

//            String jpql = """
//                    select NEW org.example.dto.CountedEnrollmentForStudent(s.name,(SELECT COUNT (e) FROM Enrollment e WHERE e.student.name=s.name))
//                    FROM Student s
//                    group by s.name
//                    having s.name like '%l%'
//                    order by s.name desc
//                    """;
//
//            TypedQuery<CountedEnrollmentForStudent> query = entityManager.createQuery(jpql, CountedEnrollmentForStudent.class);

            TypedQuery<Student> query = entityManager.createNamedQuery("getAll",Student.class);

            query.getResultList().forEach(student -> System.out.println(student));


            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}