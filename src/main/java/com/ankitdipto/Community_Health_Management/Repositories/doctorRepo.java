package com.ankitdipto.Community_Health_Management.Repositories;

import com.ankitdipto.Community_Health_Management.models.DOCTORS;

import org.springframework.data.jpa.repository.JpaRepository;

public interface doctorRepo extends JpaRepository<DOCTORS,Integer> 
{
    
}
