package com.skilldistillery.finance.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "future_expense")
@Entity
public class FutureExpense {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double amount;
	@Column(name="date_expected")
	private Date expectedDate;
	private Boolean recurring;
	private String description;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="category_id")
	private ExpenseCategory expenseCategory;
	@Column(name = "number_of_recurrences")
	private int numberOfRecurrences;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}
	public Boolean getRecurring() {
		return recurring;
	}
	public void setRecurring(Boolean recurring) {
		this.recurring = recurring;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ExpenseCategory getExpenseCategory() {
		return expenseCategory;
	}
	public void setExpenseCategory(ExpenseCategory expenseCategory) {
		this.expenseCategory = expenseCategory;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((expectedDate == null) ? 0 : expectedDate.hashCode());
		result = prime * result + ((expenseCategory == null) ? 0 : expenseCategory.hashCode());
		result = prime * result + id;
		result = prime * result + numberOfRecurrences;
		result = prime * result + ((recurring == null) ? 0 : recurring.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FutureExpense other = (FutureExpense) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (expectedDate == null) {
			if (other.expectedDate != null)
				return false;
		} else if (!expectedDate.equals(other.expectedDate))
			return false;
		if (expenseCategory == null) {
			if (other.expenseCategory != null)
				return false;
		} else if (!expenseCategory.equals(other.expenseCategory))
			return false;
		if (id != other.id)
			return false;
		if (numberOfRecurrences != other.numberOfRecurrences)
			return false;
		if (recurring == null) {
			if (other.recurring != null)
				return false;
		} else if (!recurring.equals(other.recurring))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FutureExpens [id=" + id + ", amount=" + amount + ", expectedDate=" + expectedDate + ", recurring="
				+ recurring + ", description=" + description + ", user=" + user + ", expenseCategory=" + expenseCategory
				+ "]";
	}
	public int getNumberOfRecurrences() {
		return numberOfRecurrences;
	}
	public void setNumberOfRecurrences(int numberOfRecurrences) {
		this.numberOfRecurrences = numberOfRecurrences;
	}
	
	

}
