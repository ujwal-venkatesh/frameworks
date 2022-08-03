package com.example.relations.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.relations.entity.Address;



public interface AddressRepository extends JpaRepository<Address, Long> {
}
