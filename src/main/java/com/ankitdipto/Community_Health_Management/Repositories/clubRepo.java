package com.ankitdipto.Community_Health_Management.Repositories;

import com.ankitdipto.Community_Health_Management.models.CLUB_MEMBER_RECORDS;

import org.springframework.data.jpa.repository.JpaRepository;

public interface clubRepo extends JpaRepository<CLUB_MEMBER_RECORDS,Integer>
{
    
}
