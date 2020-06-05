package com.example.assignment.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Assignment")
public class assignmentModel {

		@Id
		@Column(name="ResourceId")
		private String resourceId;	
		@Column(name="ContractName")
		private String contractName;
		@Column(name="StartDate")
		private LocalDate startDate;
		@Column(name="EndDate")
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
		public assignmentModel() {
			super();
		}
		
		
	
}
