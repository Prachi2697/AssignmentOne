package com.example.assignment.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.assignment.Model.contractModel;
import com.example.assignment.Service.contractService;

@RestController
public class contractController {
	
		@Autowired
		private contractService service;	
		
		@GetMapping("/contract")     
	    public List<contractModel> GetContract(@RequestParam("name") String Contractname)
	    { 
	   	    return service.getContract(Contractname);
	    }
		
		@PostMapping("/add")     
	    public String AddContract(@RequestBody contractModel model)
	    { 
	   	    return service.addContract(model);
	    }
		
		@PutMapping("/update")     
	    public String UpdateContract(@RequestParam("id")  String ResourceId,@RequestParam("startdate") String startdate,@RequestParam("startdate") String enddate)
	    { 
			try
			{
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy"); 
			LocalDate startDate = LocalDate.parse(startdate, formatter);
			LocalDate endDate = LocalDate.parse(enddate, formatter);
			return service.updateContract(ResourceId,startDate,endDate);
			}
			catch(Exception e)
			{
				return "Date format in invalid!";
			}
	    }
		
		@DeleteMapping("/delete")     
	    public String DeleteContract(@RequestParam("id") String id)
	    { 
	   	    return service.deleteContract(id);
	    }
	}
