package com.example.assignment.Model;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Contracts")
public class contractModel {
		        @Id
				@Column(name="ResourceId")
				private String resourceId;	
				@Column(name="ContractName")
				private String contractName;
				@Column(name="StartDate")
				private LocalDate startDate;
				@Column(name="EndDate")
				private LocalDate endDate;
				
				//Constructor
				public contractModel() {
					super();
				}
				
				public String getResourceId() {
					return resourceId;
				}
				public void setResourceId(String resourceId) {
					this.resourceId = resourceId;
				}
				public String getContractName() {
					return contractName;
				}
				public void setContractName(String contractName) {
					this.contractName = contractName;
				}
				public LocalDate getStartDate() {
					return startDate;
				}
				public void setStartDate(LocalDate startDate) {
					this.startDate = startDate;
				}
				public LocalDate getEndDate() {
					return endDate;
				}
				public void setEndDate(LocalDate endDate) {
					this.endDate = endDate;
				}		
		}






