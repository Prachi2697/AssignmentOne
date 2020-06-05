package com.example.assignment.Model;

import java.time.LocalDate;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assignment")
public class assignmentModel {

		@Id
		private String resourceId;	
		private String contractName;
		private LocalDate startDate;
		private LocalDate endDate;
		
		
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
		public assignmentModel(String resourceId, String contractName, LocalDate startDate, LocalDate endDate) {
			super();
			this.resourceId = resourceId;
			this.contractName = contractName;
			this.startDate =startDate;
			this.endDate = endDate;
		}
		public assignmentModel() {
			super();
		}
				
}
