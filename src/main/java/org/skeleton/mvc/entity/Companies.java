package org.skeleton.mvc.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


@Entity
@Table(name = "COMPANIES", catalog="skeleton")
@JsonAutoDetect
public class Companies {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer companyId;
	
	private Integer domainId;
	private String name;
	private String description;
	private Date createdAt;
	private Date updatedAt;
	private Integer enabled;
	
	@OneToMany(mappedBy="companies", cascade={CascadeType.ALL, CascadeType.REMOVE})
	private List<ExpensesFamilies> expensesFamily;
	
	@OneToMany(mappedBy="companies", cascade={CascadeType.ALL, CascadeType.REMOVE})
	private List<ExpensesNote> expensesNote;
	
	public List<ExpensesFamilies> getExpensesFamily() {
		return expensesFamily;
	}
	public void setExpensesFamily(List<ExpensesFamilies> expensesFamily) {
		this.expensesFamily = expensesFamily;
	}
	public List<ExpensesNote> getExpensesNote() {
		return expensesNote;
	}
	public void setExpensesNote(List<ExpensesNote> expensesNote) {
		this.expensesNote = expensesNote;
	}
	
	
//	@Id
//	@Column(name = "companyId", unique = true, 
//		nullable = false, length = 45)
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getDomainId() {
		return domainId;
	}
	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	
	
}
