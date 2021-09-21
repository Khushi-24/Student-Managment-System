package com.example.student_mangment_system.serviceImpl;

import com.example.student_mangment_system.entities.Course;
import com.example.student_mangment_system.entities.Student;
import com.example.student_mangment_system.entities.StudentEnrolled;
import com.example.student_mangment_system.repository.CourseRepository;
import com.example.student_mangment_system.repository.StudentEnrollmentRepository;
import com.example.student_mangment_system.repository.StudentRepository;
import com.example.student_mangment_system.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final StudentEnrollmentRepository studentEnrollmentRepository;

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourses(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getOneCourse(Long courseId) {
        Course entity = courseRepository.findById(courseId).get();
        return entity;
    }

    @Override
    public Course deleteCourse(Long courseId) {
        Course entity = courseRepository.getOne(courseId);
        courseRepository.delete(entity);
        return null;
    }

    @Override
    public Course updateCourse(Course course) {
        courseRepository.save(course);
        return course;
    }

    @Override
    public void addStudentIntoCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student does not exist."));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course does not exist"));

        StudentEnrolled studentEnrolled = new StudentEnrolled(student, course);
        if (!studentEnrollmentRepository.existsByCourseAndStudent(course, student)) {
            studentEnrollmentRepository.save(studentEnrolled);
        }

    }

    @Override
    public void deleteStudentFromCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student does not exist."));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course does not exist"));
//        List<StudentEnrolled> studentEnrolledList = studentEnrollmentRepository.findAll();
        StudentEnrolled studentEnrolled = new StudentEnrolled(student, course);
//        if (studentEnrollmentRepository.existsByCourseAndStudent(course, student)) {
//            StudentEnrolled entity = studentEnrollmentRepository.findById(studentEnrolled.getJoin_table_id()).get();
//            studentEnrollmentRepository.delete(entity);
//        }
//        if (studentEnrollmentRepository.existsByCourseAndStudent(course, student)) {
//            Long id = studentEnrolled.getJoin_table_id();
//            System.out.println(id);
//        }

        if (studentEnrollmentRepository.existsByCourseAndStudent(course, student)) {
            studentEnrollmentRepository.deleteByCourseIdAndStudentId(studentId, courseId);
        } else {
            throw new EntityNotFoundException("No such entry exists.");
        }


    }

    @Override
    public void deleteStudentByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student does not exist."));
        //       StudentEnrolled studentEnrolled = new StudentEnrolled(student);
        if (studentEnrollmentRepository.existsByStudentStudentId(studentId)) {
            studentEnrollmentRepository.deleteStudentById(studentId);
        } else {
            throw new EntityNotFoundException("Student with" + studentId + "Doesn't Exists");
        }
        //System.out.println(studentId);
    }

    @Override
    public void deleteCourseByCourseId(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course does not exist"));
        studentEnrollmentRepository.deleteByCourseId(courseId);
        courseRepository.deleteById(courseId);
    }

}
