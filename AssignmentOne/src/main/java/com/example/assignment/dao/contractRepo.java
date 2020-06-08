package com.example.assignment.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.assignment.Model.contractModel;

@Repository
public interface contractRepo extends JpaRepository<contractModel,String> {

	boolean existsBycontractName(String name);

	List<contractModel> findBycontractName(String name);

	contractModel findByresourceId(String id);
}
