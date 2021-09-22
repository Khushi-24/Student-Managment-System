package com.example.student_mangment_system.serviceImpl;

import com.example.student_mangment_system.customException.BadRequestException;
import com.example.student_mangment_system.customException.NoRecordFoundException;
import com.example.student_mangment_system.entities.Course;
import com.example.student_mangment_system.entities.Student;
import com.example.student_mangment_system.entities.StudentEnrolled;
import com.example.student_mangment_system.entities.Teacher;
import com.example.student_mangment_system.repository.CourseRepository;
import com.example.student_mangment_system.repository.StudentEnrollmentRepository;
import com.example.student_mangment_system.repository.StudentRepository;
import com.example.student_mangment_system.repository.TeacherRepository;
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
    private final TeacherRepository teacherRepository;
    private final StudentEnrollmentRepository studentEnrollmentRepository;

    @Override
    public List<Course> getCourses() {
        List<Course> courseList = courseRepository.findAll();
        if(courseList.isEmpty()){
            throw  new NoRecordFoundException("List is empty.");
        }
        else {
            return courseList;
        }
    }

    @Override
    public Course addCourses(Course course) {
        if(course.getCoursename().isEmpty() || course.getCoursename().isBlank()){
            throw new BadRequestException("Please enter course name.");
        }
        if(course.getDescription().isEmpty() || course.getDescription().isBlank()){
            throw new BadRequestException("Please enter course description");
        }
        else{
            return courseRepository.save(course);
        }
    }

    @Override
    public Course updateCourse(Course course) {
        if(course.getCoursename().isEmpty() || course.getCoursename().isBlank()){
            throw new BadRequestException("Please enter course name.");
        }
        if(course.getDescription().isEmpty() || course.getDescription().isBlank()){
            throw new BadRequestException("Please enter course description");
        }
        else{
            return courseRepository.save(course);
        }
    }

    @Override
    public void addStudentAndTeacherIntoCourse(Long teacherId, Long studentId, Long courseId) {
        if(teacherId != null && studentId != null && courseId != null){
            Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new EntityNotFoundException("Teacher does not exist."));
            Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student does not exist."));
            Course course = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course does not exist"));

            StudentEnrolled studentEnrolled = new StudentEnrolled(teacher, student, course);
            if(!studentEnrollmentRepository.existsByCourseAndStudentAndTeacher(course, student, teacher)){
                studentEnrollmentRepository.save(studentEnrolled);
            }
        }else{
            throw  new BadRequestException("Id can't be null");
        }

    }

    @Override
    public void deleteStudentAndTeacherFromCourse(Long teacherId, Long studentId, Long courseId) {
        if(teacherId != null && studentId != null && courseId != null){
            Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new EntityNotFoundException("Teacher does not exist."));
            Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student does not exist."));
            Course course = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course does not exist"));

            if(studentEnrollmentRepository.existsByCourseAndStudentAndTeacher(course, student, teacher)){
//            studentEnrollmentRepository.deleteByCourseCourseIdAndStudentStudentIdAndTeacherTeacherId(teacherId, studentId, courseId);
                studentEnrollmentRepository.deleteByCourseIdAndStudentIdAndTeacherId(teacherId, studentId, courseId);
            }else{
                throw new EntityNotFoundException("No such entry exists.");
            }
        }else{
            throw new BadRequestException("Id can't be null");
        }

    }

    @Override
    public void deleteStudentFromCourse(Long studentId, Long courseId) {
        if(studentId != null && courseId != null){
            Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student does not exist."));
            Course course = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course does not exist"));
//        List<StudentEnrolled> studentEnrolledList = studentEnrollmentRepository.findAll();
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
        }else{
            throw new BadRequestException("Id can't be null");
        }

    }

    @Override
    public void deleteCourse(Long courseId) {
        if(courseId != null){
            deleteCourseByCourseId(courseId);
            Course entity = courseRepository.getOne(courseId);
            courseRepository.delete(entity);
        }else{
            throw new BadRequestException("Id can't be null");
        }

    }

    @Override
    public void deleteCourseByCourseId(Long courseId) {
        if(courseId != null){
            Course course = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course does not exist"));
            studentEnrollmentRepository.deleteByCourseId(courseId);
            //courseRepository.deleteById(courseId);
        }else{
            throw new BadRequestException("Id can't be null");
        }

    }

}


//    @Override
//    public void addStudentIntoCourse(Long studentId, Long courseId) {
//        Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student does not exist."));
//        Course course = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course does not exist"));
//
//        StudentEnrolled studentEnrolled = new StudentEnrolled(student, course);
//        if (!studentEnrollmentRepository.existsByCourseAndStudent(course, student)) {
//            studentEnrollmentRepository.save(studentEnrolled);
//        }
//    }