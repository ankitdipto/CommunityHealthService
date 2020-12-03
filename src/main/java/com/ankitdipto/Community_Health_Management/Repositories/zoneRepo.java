package com.ankitdipto.Community_Health_Management.Repositories;

import java.util.Collection;

import com.ankitdipto.Community_Health_Management.models.ZONE;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface zoneRepo extends JpaRepository<ZONE,Integer>
{
    @Query(
        value = "SELECT * FROM zone ORDER BY no_of_covid19cases DESC;",
        nativeQuery = true
    )
    public Collection<ZONE> findAllSortedByCov19();
}