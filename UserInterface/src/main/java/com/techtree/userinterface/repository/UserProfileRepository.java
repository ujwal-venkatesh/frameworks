package com.techtree.userinterface.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtree.userinterface.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{

}
