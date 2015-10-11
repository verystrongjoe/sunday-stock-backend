package org.skeleton.mvc.service;

import org.skeleton.mvc.entity.Companies;
import org.skeleton.mvc.repository.CompanyDao;
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
@RequestMapping(value="/company")
public class CompanyService {

	final Logger logger = LoggerFactory.getLogger(CompanyService.class);
	
	@Autowired
	private CompanyDao companyDao;
	
	@RequestMapping(value="/create", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseBody
    public String create(@RequestBody Companies companies) {
		logger.info("companies will be created : {} ", companies.toString());
        return "Created Companies Entity with Id  " + companyDao.save(companies).getCompanyId();
	}

	@RequestMapping(value="/select",  method = RequestMethod.GET, produces="application/json", consumes="application/json")
	@ResponseBody
    public Companies select(@RequestParam(value="companyId") Integer companyId) {
		logger.info("Find  the entitiy with Id : {} ", companyId);
        Companies companies = companyDao.findOne(companyId);
        return companies;
    }
	
	@RequestMapping(value="/selectAll",   method = RequestMethod.GET, produces="application/json" )
	@ResponseBody
    public Iterable<Companies> selectAll() {
        Iterable<Companies> companies = companyDao.findAll();
        return companies;
    }

	@RequestMapping(value="/update",   method = RequestMethod.PUT, produces="application/json", consumes="application/json")
	@ResponseBody
    public String update(@ModelAttribute("companies") Companies  companies) {
		
		if( 	this.select( companies.getCompanyId()) != null ) {
			 return  "Updated Companies Entity with Id  " + companyDao.save(companies).getCompanyId();
		}
		else {
			 return "No entity with Id "  + companies.getCompanyId();
		}
    }
	
	@RequestMapping(value="/delete",  method = RequestMethod.DELETE, produces="application/json", consumes="application/json")
	@ResponseBody
    public String delete(@RequestParam(value="companyId") Integer companyId) {
		logger.info("delete  the entitiy with Id : {} ", companyId);
        companyDao.delete(companyId);
        return "deleted";
    }
	
}
