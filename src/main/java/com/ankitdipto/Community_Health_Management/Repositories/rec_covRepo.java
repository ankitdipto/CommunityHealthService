package com.ankitdipto.Community_Health_Management.Repositories;

import com.ankitdipto.Community_Health_Management.models.COVID19_RECOVERED;

import org.springframework.data.jpa.repository.JpaRepository;

public interface rec_covRepo extends JpaRepository<COVID19_RECOVERED,Long>
{
    
}
