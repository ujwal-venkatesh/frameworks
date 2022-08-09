package com.techtree.userinterface.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techtree.userinterface.entity.User;
import com.techtree.userinterface.entity.UserProfile;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Integer> {
}
