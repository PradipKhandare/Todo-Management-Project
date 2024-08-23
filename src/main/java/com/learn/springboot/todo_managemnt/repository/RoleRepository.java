package com.learn.springboot.todo_managemnt.repository;

import com.learn.springboot.todo_managemnt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    
}
