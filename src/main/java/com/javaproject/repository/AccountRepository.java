
package com.javaproject.repository;

import com.javaproject.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Method to find an account by user ID
    Account findByUserId(Long userId);

    // Method to find an active account by user ID
    Account findByUserIdAndActiveTrue(Long userId);

    // Method to deactivate an account
    @Modifying
    @Query("UPDATE Account a SET a.active = false WHERE a.userId = :userId")
    void deactivateAccount(Long userId);
}
