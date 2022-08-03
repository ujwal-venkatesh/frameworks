package com.example.relations.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "add_id")
    private Long addressId;
    @Column(name = "city")
    private String city;
    @Column(name = "addresstype")
    private String addressType;


    @OneToOne(mappedBy = "address")
    private Employee employee;

//    @ManyToOne
////    @JoinColumn(name = "fk_emp_id")
//    private Employee employee;
}


