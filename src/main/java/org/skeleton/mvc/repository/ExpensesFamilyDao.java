package org.skeleton.mvc.repository;

import javax.transaction.Transactional;

import org.skeleton.mvc.entity.ExpensesFamilies;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ExpensesFamilyDao extends CrudRepository<ExpensesFamilies, Integer> {
	
	
}
