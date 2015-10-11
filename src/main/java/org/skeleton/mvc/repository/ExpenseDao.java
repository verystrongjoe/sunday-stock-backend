package org.skeleton.mvc.repository;

import javax.transaction.Transactional;

import org.skeleton.mvc.entity.Expenses;
import org.springframework.data.repository.CrudRepository;


@Transactional
public interface ExpenseDao extends CrudRepository<Expenses, Integer> {

}
