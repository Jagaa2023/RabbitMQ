package com.example.demo.service;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repo.AccountRepo;

 
 

@Service 
public class AccountService {
	
	@Autowired
	AccountRepo accountrepo;

	  
	public List<Account> GetAll(){
	 	
		// return accountrepo.findByAccountstatus("N");
		
		return accountrepo.findAll();
		
	} 
	
	 
	boolean UpdateAccountInfo(Account  account) {
		
		try {
			account.setAccountstatus("D");
			
			accountrepo.save(account);
			
			return true;
			
		}catch(Exception exp) {
			return false;
		}
		
		
		
		 
	}
	
	
	

}
