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
@Table(name = "EXPENSES_FAMILIES", catalog="skeleton")
public class ExpensesFamilies {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer expensesFamilyId;
	
	private Integer companyId;
	private String icon;
	private String color;
	private Integer needQuantity;
	private Long price;
	private Long changePrice;
	private Date disableDate;
	
	@OneToMany(targetEntity=Expenses.class, mappedBy="expensesFamilies", cascade={CascadeType.ALL, CascadeType.REMOVE})
	private List<Expenses> expenses;
	
	@ManyToOne
	private Companies companies;
	
	
	public Companies getCompanies() {
		return companies;
	}
	public void setCompanies(Companies companies) {
		this.companies = companies;
	}
	public void setExpenses(List<Expenses> expenses) {
		this.expenses = expenses;
	}
	public List<Expenses> getExpenses() {
		return expenses;
	}
	public void setExpense(List<Expenses> expense) {
		this.expenses = expense;
	}
	
	
//	@Id
//	@Column(name = "expensesFamailyId", unique = true, 
//	nullable = false, length = 45)
	public Integer getExpensesFamilyId() {
		return expensesFamilyId;
	}
	public void setExpensesFamilyId(Integer expensesFamailyId) {
		this.expensesFamilyId = expensesFamailyId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getNeedQuantity() {
		return needQuantity;
	}
	public void setNeedQuantity(Integer needQuantity) {
		this.needQuantity = needQuantity;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getChangePrice() {
		return changePrice;
	}
	public void setChangePrice(Long changePrice) {
		this.changePrice = changePrice;
	}
	public Date getDisableDate() {
		return disableDate;
	}
	public void setDisableDate(Date disableDate) {
		this.disableDate = disableDate;
	}
	
}
