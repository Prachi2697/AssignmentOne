package com.example.assignment.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment.Model.assignmentModel;

@Repository
public interface assignmentRepo extends JpaRepository<assignmentModel,String> {

	boolean existsBycontractName(String name);

	Optional<assignmentModel> findBycontractName(String name);

	assignmentModel findByresourceId(String id);

}
