package com.ankitdipto.Community_Health_Management.Repositories;

import com.ankitdipto.Community_Health_Management.models.PUBLIC_RECORDS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface publicRepo extends JpaRepository<PUBLIC_RECORDS,Long>
{
    
}
