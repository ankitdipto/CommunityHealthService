package com.ankitdipto.Community_Health_Management.Repositories;

import java.util.List;

import com.ankitdipto.Community_Health_Management.models.HOSPITAL_INFORMATION;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface hospitalRepo extends JpaRepository<HOSPITAL_INFORMATION,Integer>
{
    @Query(
        value = "SELECT * FROM hospital_information ORDER BY no_of_covid_beds_free DESC",
        nativeQuery = true
    )
    public List<HOSPITAL_INFORMATION> findByOrderByNoOfCovidBedsFreeDesc();

    @Query(
        value = "SELECT * FROM hospital_information ORDER BY no_of_dengue_beds_free DESC",
        nativeQuery = true
    )
    public List<HOSPITAL_INFORMATION> sortedByDengueBeds();

    @Query(
        value = "SELECT * FROM hospital_information ORDER BY no_of_general_beds DESC",
        nativeQuery = true
    )
    public List<HOSPITAL_INFORMATION> sortedByGeneralBeds();

    @Query(
        value = "SELECT * FROM hospital_information ORDER BY no_of_full_time_doctors DESC",
        nativeQuery = true
    )
    public List<HOSPITAL_INFORMATION> sortedByDoctors();
}
