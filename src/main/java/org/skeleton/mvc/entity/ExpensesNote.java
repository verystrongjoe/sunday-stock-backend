package org.skeleton.mvc.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "expenses_note", catalog="skeleton")
public class ExpensesNote {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer expenseNoteId;
	
	private String description;
	private Integer status;
	private Date createdAt;
	private Date updatedAt;
	private Date startDate;
	private Date endDate;
	
    @ManyToOne
    private Users user;
    
    @OneToMany(mappedBy="expensesNote", cascade = {CascadeType.ALL, CascadeType.REMOVE})
    private List<Expenses> expenses;
    
    @ManyToOne
    private Companies companies;
    
    
	public Companies getCompanies() {
		return companies;
	}
	public void setCompanies(Companies companies) {
		this.companies = companies;
	}
	public List<Expenses> getExpenses() {
		return expenses;
	}
	public void setExpenses(List<Expenses> expenses) {
		this.expenses = expenses;
	}
	
	public Integer getExpenseNoteId() {
		return expenseNoteId;
	}
	
	
	public void setExpenseNoteId(Integer expenseNoteId) {
		this.expenseNoteId = expenseNoteId;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
}
