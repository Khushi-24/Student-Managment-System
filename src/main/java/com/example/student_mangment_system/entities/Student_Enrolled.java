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
public class Student_Enrolled  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long join_table_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="courseid", referencedColumnName = "id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentid", referencedColumnName = "id")
    private  Student student;
}
