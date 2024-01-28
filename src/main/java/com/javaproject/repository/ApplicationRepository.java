
package com.javaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.javaproject.model.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Query("SELECT a FROM Application a WHERE a.id = ?1")
    Application findById(long id);

    @Query("SELECT a FROM Application a WHERE a.identityVerificationStatus = ?1 AND a.addressVerificationStatus = ?2")
    Application findByVerificationStatus(String identityVerificationStatus, String addressVerificationStatus);

    @Query("SELECT a FROM Application a WHERE a.annualIncome >= 30000 AND a.creditScore >= 700")
    Application findEligibleForHighLimitCredit();

    @Query("SELECT a FROM Application a WHERE a.annualIncome >= 20000 AND a.creditScore >= 600")
    Application findEligibleForModerateLimitCredit();
}
