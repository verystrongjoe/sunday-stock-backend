package org.skeleton.mvc.repository;

import javax.transaction.Transactional;

import org.skeleton.mvc.entity.Companies;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface CompanyDao extends CrudRepository<Companies, Integer> {

}
