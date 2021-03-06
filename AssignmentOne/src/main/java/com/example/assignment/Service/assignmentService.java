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
	    autoGeneratedString st=()->	
	    {
	    	String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";   
	    	StringBuilder builder = new StringBuilder();
	    	int count=16;
	    	while (count-- != 0) {
	    	int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
	    	builder.append(ALPHA_NUMERIC_STRING.charAt(character));
	    	}
	    	return builder.toString();	    	
	    };
	    String ResourceId=st.generate();
	    newContract.setResourceId(ResourceId);
		
				
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
