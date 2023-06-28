package com.devstack.pos.entity;

import com.devstack.pos.entity.process.ResourseFiles;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private long publicId;
    private String name;
    private String address;
    private double salary;

    @Column(columnDefinition = "TINYINT")
    private boolean activeState;

    @Embedded
    private ResourseFiles fileResourse;
}
