package com.sample.financialgoaltracker.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.financialgoaltracker.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {


	Optional<User> getUserByAuth0Id(String authOId);



}
