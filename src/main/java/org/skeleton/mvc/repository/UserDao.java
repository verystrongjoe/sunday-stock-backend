package org.skeleton.mvc.repository;

import org.skeleton.mvc.entity.Users;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;

public interface UserDao extends CrudRepository<Users, Long> {

    Users findByEmail(@Param("email") String email);
    
    Users findByUserId(@Param("userId") String userId);
}
