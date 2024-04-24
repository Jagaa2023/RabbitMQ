package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Account;

 

public interface AccountRepo extends JpaRepository<Account, Long>  {
	List<Account> findByAccountstatus(String status);
}
