package com.ankitdipto.Community_Health_Management.Repositories;



import com.ankitdipto.Community_Health_Management.models.InfectionData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface infectionRepo extends JpaRepository<InfectionData,Long>
{
      @Procedure(procedureName = "RegisterInfectionData")
      public void addNewInfections();
}
