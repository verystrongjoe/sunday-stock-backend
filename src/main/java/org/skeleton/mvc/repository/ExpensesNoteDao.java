package org.skeleton.mvc.repository;

import javax.transaction.Transactional;

import org.skeleton.mvc.entity.ExpensesNote;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ExpensesNoteDao extends CrudRepository<ExpensesNote, Integer> {

}
