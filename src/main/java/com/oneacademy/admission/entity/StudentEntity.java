package com.oneacademy.admission.entity;

import lombok.*;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicLong;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(insertable = false, nullable = false, unique = true, columnDefinition = "serial")// done this way because GeneratedValue only works with @Id
    private long studentId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String fieldOfStudy;//department

    private final static AtomicLong studentIdCounter = new AtomicLong(System.nanoTime());// used for auto generating values

    @PrePersist
    void jobId() {
        this.studentId = studentIdCounter.incrementAndGet();
    }
}
