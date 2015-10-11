package org.skeleton.mvc.entity;

import java.io.Serializable;
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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USERS", schema="skeleton")
public class Users implements Serializable {

    @Id 
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Column
//    @NotEmpty(message = "Name is required.")
    private String name;

    @Column
    @NotEmpty(message = "First surname is required.")
    private String firstSurname;
    
    @Column
    @NotEmpty(message = "Second surname is required.")
    private String secondSurname;
    
    @Column
    private String telephone;
    
    @Email(message = "Please provide a valid email address.")
    @NotEmpty(message = "Email is required.")
    @Column(unique=true, nullable = false)
    private String email;

    @Column
    @NotEmpty(message = "Password is required.")
    private String password;
    
    @Column
    private Integer validator;
    
    @Column
    private Date entryDate;
    
    @Column
    private Date lastEntry;
    
    @Column
    private Integer connections;
    
    @Column
    private Integer languageId;
    
    @OneToMany(mappedBy="user", cascade= {CascadeType.ALL, CascadeType.REMOVE})
    private List<ExpensesNote> expenseNotes;
    
    @OneToMany(mappedBy="user", cascade= {CascadeType.ALL, CascadeType.REMOVE})
    private List<CompaniesUsers> companiesUsers;
    
    
    public Users() {
		super();
	}
	public Users(String email) {
		super();
		this.email = email;
	}
	public Users(Users users) {
		this.userId = users.userId;
		this.email = users.email;
		this.password = users.password;
	}
	public Integer getConnections() {
		return connections;
	}
	public void setConnections(Integer connections) {
		this.connections = connections;
	}
	public List<CompaniesUsers> getCompaniesUsers() {
		return companiesUsers;
	}
	public void setCompaniesUsers(List<CompaniesUsers> companiesUsers) {
		this.companiesUsers = companiesUsers;
	}
	public List<ExpensesNote> getExpenseNotes() {
		return expenseNotes;
	}
	public void setExpenseNotes(List<ExpensesNote> expenseNotes) {
		this.expenseNotes = expenseNotes;
	}

	@JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getValidator() {
		return validator;
	}

	public void setValidator(Integer validator) {
		this.validator = validator;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getLastEntry() {
		return lastEntry;
	}

	public void setLastEntry(Date lastEntry) {
		this.lastEntry = lastEntry;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	private static final long serialVersionUID = 2738859149330833739L;
}