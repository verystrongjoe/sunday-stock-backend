package org.skeleton.mvc.service;

import org.skeleton.mvc.entity.ExpensesFamilies;
import org.skeleton.mvc.repository.ExpensesFamilyDao;
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
@RequestMapping(value="/expensefamily")
public class ExpensesFamiliesService {

	final Logger logger = LoggerFactory.getLogger(ExpensesFamiliesService.class);
	
	@Autowired
	private ExpensesFamilyDao expensesFamilyDao;
	
	@RequestMapping(value="/create", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseBody
    public String create(@ModelAttribute("expensesFamilies") ExpensesFamilies expensesFamilies) {
		logger.info("expensesFamilies will be created : {} ", expensesFamilies.toString());
        return "Created ExpensesFamilies Entity with Id  " + expensesFamilyDao.save(expensesFamilies).getExpensesFamilyId();
	}

	@RequestMapping(value="/select",  method = RequestMethod.GET, produces="application/json", consumes="application/json")
	@ResponseBody
    public ExpensesFamilies select(@RequestParam(value="expensesFamilyId") Integer expensesFamilyId) {
		logger.info("Find  the entitiy with Id : {} ", expensesFamilyId);
        ExpensesFamilies expensesFamilies = expensesFamilyDao.findOne(expensesFamilyId);
        return expensesFamilies;
    }
	
	@RequestMapping(value="/selectAll",   method = RequestMethod.GET, produces="application/json" )
	@ResponseBody
    public Iterable<ExpensesFamilies> selectAll() {
        Iterable<ExpensesFamilies> expensesFamilies = expensesFamilyDao.findAll();
        return expensesFamilies;
    }

	@RequestMapping(value="/update",   method = RequestMethod.PUT, produces="application/json", consumes="application/json")
	@ResponseBody
    public String update(@ModelAttribute("expensesFamilies") ExpensesFamilies  expensesFamilies) {
		
		if( 	this.select( expensesFamilies.getExpensesFamilyId()) != null ) {
			 return  "Updated ExpensesFamilies Entity with Id  " + expensesFamilyDao.save(expensesFamilies).getExpensesFamilyId();
		}
		else {
			 return "No entity with Id "  + expensesFamilies.getExpensesFamilyId();
		}
    }
	
	@RequestMapping(value="/delete",  method = RequestMethod.DELETE, produces="application/json", consumes="application/json")
	@ResponseBody
    public String delete(@RequestParam(value="expensesFamilyId") Integer expensesFamilyId) {
		logger.info("delete  the entitiy with Id : {} ", expensesFamilyId);
		expensesFamilyDao.delete(expensesFamilyId);
        return "deleted";
    }
	
	
	
}
