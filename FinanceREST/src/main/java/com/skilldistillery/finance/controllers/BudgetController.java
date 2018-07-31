package com.skilldistillery.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.finance.entities.Budget;
import com.skilldistillery.finance.entities.Expense;
import com.skilldistillery.finance.services.BudgetService;

@CrossOrigin({"*", "http://localhost:4200"})
@RequestMapping("api/")
@RestController
public class BudgetController {

	@Autowired
	BudgetService budServ;
	
	String username = "user";
	
	@RequestMapping(path="budget", method= RequestMethod.GET)
	public List<Budget> index() {
		return budServ.indexBudget(username);
	}
	
	@RequestMapping(path="budget/{id}", method = RequestMethod.GET) 
	public Budget getOneExpense(@PathVariable int id) {
		return budServ.show(username, id);
	}
	
	@RequestMapping(path="budget", method = RequestMethod.POST) 
	public Budget createExpense(@RequestBody Budget budget) {
		return budServ.create(username, budget);
	}
	
	@RequestMapping(path="budget/{id}", method = RequestMethod.PATCH) 
	public Budget updateExpense(@RequestBody Budget budget, @PathVariable int id) {
		return budServ.update(username, id, budget);
	}
	
	@RequestMapping(path="budget/{id}", method = RequestMethod.DELETE)
	public boolean deleteExpense(@PathVariable int id) {
		return budServ.destroy(username, id);
	}
	
}
