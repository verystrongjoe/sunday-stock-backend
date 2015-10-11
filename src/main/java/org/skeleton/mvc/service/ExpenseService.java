package org.skeleton.mvc.service;

import org.skeleton.mvc.entity.Expenses;
import org.skeleton.mvc.repository.ExpenseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/expense")
public class ExpenseService {

	final Logger logger = LoggerFactory.getLogger(ExpenseService.class);
	
	@Autowired
	private ExpenseDao expenseDao;
	
	
	@RequestMapping(value="/create", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseBody
    public String create(@ModelAttribute("expense") Expenses expenses) {
		logger.info("expenses will be created : {} ", expenses.toString());
        return "Created Companies Entity with Id  " + expenseDao.save(expenses).getExpenseId();
	}

	@RequestMapping(value="/select",  method = RequestMethod.GET, produces="application/json", consumes="application/json")
	@ResponseBody
    public Expenses select(@RequestParam(value="expensesId") Integer expensesId) {
		logger.info("Find  the entitiy with Id : {} ", expensesId);
        Expenses expenses = expenseDao.findOne(expensesId);
        return expenses;
    }
	
	@RequestMapping(value="/selectAll",   method = RequestMethod.GET, produces="application/json" )
	@ResponseBody
    public Iterable<Expenses> selectAll() {
        Iterable<Expenses> expenses = expenseDao.findAll();
        return expenses;
    }

	@RequestMapping(value="/update",   method = RequestMethod.PUT, produces="application/json", consumes="application/json")
	@ResponseBody
    public String update(@ModelAttribute("expenses") Expenses  expenses) {
		
		if( 	this.select( expenses.getExpenseId()) != null ) {
			 return  "Updated Companies Entity with Id  " + expenseDao.save(expenses).getExpenseId();
		}
		else {
			 return "No entity with Id "  + expenses.getExpenseId();
		}
    }
	
	@RequestMapping(value="/delete",  method = RequestMethod.DELETE, produces="application/json", consumes="application/json")
	@ResponseBody
    public String delete(@RequestParam(value="expenseId") Integer expenseId) {
		logger.info("delete  the entitiy with Id : {} ", expenseId);
		expenseDao.delete(expenseId);
        return "deleted";
    }
	
	
	
	
	
}
