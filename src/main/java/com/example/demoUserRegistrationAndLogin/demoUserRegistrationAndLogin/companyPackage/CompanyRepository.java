package com.example.demoUserRegistrationAndLogin.demoUserRegistrationAndLogin.companyPackage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company,Long> {

    @Query("SELECT c FROM Company c WHERE c.companyName = ?1")
    public Company findByCompanyName(String company_name);

    Company getCompanyById(long id);
    public void deleteCompanyById(long id);
}
