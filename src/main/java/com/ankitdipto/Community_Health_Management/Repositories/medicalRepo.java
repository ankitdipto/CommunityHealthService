package com.ankitdipto.Community_Health_Management.Repositories;

import com.ankitdipto.Community_Health_Management.models.MEDICAL_HELP_RECORDS;

import org.springframework.data.jpa.repository.JpaRepository;

public interface medicalRepo extends JpaRepository<MEDICAL_HELP_RECORDS,Integer>
{
    
}
