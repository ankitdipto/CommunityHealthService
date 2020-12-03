package com.ankitdipto.Community_Health_Management.Repositories;

import com.ankitdipto.Community_Health_Management.models.ISOLATION_CENTRE_DETAILS;

import org.springframework.data.jpa.repository.JpaRepository;

public interface isolationRepo extends JpaRepository<ISOLATION_CENTRE_DETAILS,Integer> 
{
    
}
