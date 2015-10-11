package org.skeleton.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANIES_USERS", catalog="skeleton")
public class CompaniesUsers {
	
	@Id 
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer companiesUserMappingId;
	
	@ManyToOne
	private Users user;
	
	@ManyToOne
	private Companies company;
	
	public Integer getCompaniesUserMappingId() {
		return companiesUserMappingId;
	}

	public void setCompaniesUserMappingId(Integer companiesUserMappingId) {
		this.companiesUserMappingId = companiesUserMappingId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Companies getCompany() {
		return company;
	}

	public void setCompany(Companies company) {
		this.company = company;
	}


}
