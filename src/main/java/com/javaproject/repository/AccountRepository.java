
package com.javaproject.repository;

import com.javaproject.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    
    // Method to find an account by its unique identifier
    Account findById(long id);
    
    // Method to find an account by its username
    Account findByUsername(String username);
    
    // Method to delete an account by its unique identifier
    void deleteById(long id);
    
    // Method to delete an account by its username
    void deleteByUsername(String username);
    
}
