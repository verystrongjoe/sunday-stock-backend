package org.skeleton.mvc.service;

import org.skeleton.mvc.entity.ExpensesNote;
import org.skeleton.mvc.repository.ExpensesNoteDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/expensenote")
public class ExpensesNoteService {

	final Logger logger = LoggerFactory.getLogger(ExpensesNoteService.class);
	
	@Autowired
	private ExpensesNoteDao expensesNoteDao;
	
	
	@RequestMapping(value="/create", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseBody
    public String create(@RequestBody ExpensesNote expensesNote) {
		logger.info("expensesNote will be created : {} ", expensesNote.toString());
        return "Created ExpensesNote Entity with Id  " + expensesNoteDao.save(expensesNote).getExpenseNoteId();
	}

	@RequestMapping(value="/select",  method = RequestMethod.GET, produces="application/json", consumes="application/json")
	@ResponseBody
    public ExpensesNote select(@RequestParam(value="expenseNoteId") Integer expenseNoteId) {
		logger.info("Find  the entitiy with Id : {} ", expenseNoteId);
        ExpensesNote expensesNote = expensesNoteDao.findOne(expenseNoteId);
        return expensesNote;
    }
	
	@RequestMapping(value="/selectAll",   method = RequestMethod.GET, produces="application/json" )
	@ResponseBody
    public Iterable<ExpensesNote> selectAll() {
        Iterable<ExpensesNote> expensesNote = expensesNoteDao.findAll();
        return expensesNote;
    }

	@RequestMapping(value="/update",   method = RequestMethod.PUT, produces="application/json", consumes="application/json")
	@ResponseBody
    public String update(@ModelAttribute("expensesNote") ExpensesNote  expensesNote) {
		
		if( 	this.select( expensesNote.getExpenseNoteId()) != null ) {
			 return  "Updated ExpensesNote Entity with Id  " + expensesNoteDao.save(expensesNote).getExpenseNoteId();
		}
		else {
			 return "No entity with Id "  + expensesNote.getExpenseNoteId();
		}
    }
	
	@RequestMapping(value="/delete",  method = RequestMethod.DELETE, produces="application/json", consumes="application/json")
	@ResponseBody
    public String delete(@RequestParam(value="expenseNoteId") Integer expenseNoteId) {
		logger.info("delete  the entitiy with Id : {} ", expenseNoteId);
		expensesNoteDao.delete(expenseNoteId);
        return "deleted";
    }
	
	
	
}
