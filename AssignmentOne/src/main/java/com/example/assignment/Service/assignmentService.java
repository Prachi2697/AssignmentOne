package com.example.assignment.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.Model.assignmentModel;
import com.example.assignment.dao.assignmentRepo;

@Service
public class assignmentService {
	
	@Autowired
	private assignmentRepo repo;
	
	public Optional<assignmentModel> getContract(String name)
	{
		return repo.findBycontractName(name);		
	}
	
	
	public String addContract(assignmentModel newContract)
	{
		if(repo.existsById(newContract.getResourceId()))
		{
			return "Contract is Already Registered!";
		}
		else
		{
			if(Pattern.compile("^[a-zA-Z0-9]*$").matcher(newContract.getContractName()).matches())
			{
				if(newContract.getResourceId().length()==16)
				{
					if(Pattern.compile("^[a-zA-Z]*$").matcher(newContract.getContractName()).matches())
					{
						int check=newContract.getEndDate().compareTo(newContract.getStartDate());
						if(check>=0)
						{
							repo.save(newContract);
							return "Registered!";
						}
						else
						{
							return "Invalid Date!";
						}
					 	
					}
					else
					{
						return "Invalid Contract Name!";
					}		
				}
				else
				{
					return "Id must be 16 charecter";
				}
			
				}
			else
			{
				return "Id must contain alphanumeric charector";
			}
				
		}
	}
	public String updateContract(String Id,LocalDate startdate,LocalDate enddate)
	{
		if(repo.existsById(Id))
		{
			assignmentModel m=repo.findByresourceId(Id);
			m.setStartDate(startdate);
			m.setEndDate(enddate);
			repo.save(m);
			return "updated!";
		}
		else
		{
			return "Contract not exist with this id! ";
		}
		
		
	}
	
	public String deleteContract(String resourceId)
	{
		if(repo.existsById(resourceId))
		{
		repo.deleteById(resourceId);
		return "Deleted!";
		}
		else
		{
			return "wrongId!";
		 	
		}
	}

}
