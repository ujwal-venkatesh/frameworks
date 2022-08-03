package com.example.relations.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;


@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long empId;
    @Column(name="name")
    private String name;
    @Column(name="age")
    private Integer age;
     
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

//    @OneToMany(cascade = CascadeType.ALL,)
//    @JoinColumn(name = "fk_emp_id",referencedColumnName = "emp_id")
//    private List<Address> address;
}
