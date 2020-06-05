package com.example.assignment.Controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.Model.assignmentModel;
import com.example.assignment.Service.assignmentService;

@RestController
public class assignmentController {
	@Autowired
	private assignmentService service;	
	
	@GetMapping("/contract")     
    public Optional<assignmentModel> GetContract(@RequestParam("name") String name)
    { 
   	 return service.getContract(name);
    }
	
	@PostMapping("/add")     
    public String AddContract(@RequestBody assignmentModel model)
    { 
   	 return service.addContract(model);
    }
	
	@PutMapping("/update")     
    public String UpdateContract(@RequestParam("id")  String ResourceId,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startdate,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate enddate)
    { 
   	 return service.updateContract(ResourceId,startdate,enddate);
    }
	
	@DeleteMapping("/delete")     
    public String DeleteContract(@RequestParam("id") String id)
    { 
   	 return service.deleteContract(id);
    }
	

}
