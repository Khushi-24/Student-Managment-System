package com.example.student_mangment_system.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(name= "join_table")
public class StudentEnrolled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long join_table_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="courseId", referencedColumnName = "courseId")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    private  Student student;

    public StudentEnrolled(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

//    public StudentEnrolled(Student student){
//        this.student = student;
//    }
}
