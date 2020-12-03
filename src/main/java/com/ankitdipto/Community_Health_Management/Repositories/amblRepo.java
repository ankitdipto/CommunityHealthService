package com.ankitdipto.Community_Health_Management.Repositories;

import com.ankitdipto.Community_Health_Management.models.AMBULANCE_DETAILS;

import org.springframework.data.jpa.repository.JpaRepository;

public interface amblRepo extends JpaRepository<AMBULANCE_DETAILS,Integer>
{
    
}
