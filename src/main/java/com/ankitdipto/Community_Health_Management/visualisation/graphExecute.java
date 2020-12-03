package com.ankitdipto.Community_Health_Management.visualisation;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ankitdipto.Community_Health_Management.Repositories.covid_active_Repo;
import com.ankitdipto.Community_Health_Management.Repositories.infectionRepo;
import com.ankitdipto.Community_Health_Management.Repositories.zoneRepo;
import com.ankitdipto.Community_Health_Management.models.COVID19_ACTIVE;
import com.ankitdipto.Community_Health_Management.models.InfectionData;
import com.ankitdipto.Community_Health_Management.models.ZONE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class graphExecute implements graphService{
    
    @Autowired
    zoneRepo zonerepo;

    @Autowired
    covid_active_Repo covid;

    @Autowired
    infectionRepo infectionrepo;

    @Override
    public Map<String,Integer> loadDataColumn()
    {
        int key,value;
        ZONE zone;
        Map<String,Integer> graphData = new TreeMap<>();
        Collection<ZONE> regions=zonerepo.findAllSortedByCov19();
        Iterator<ZONE> itr=regions.iterator();
        while(itr.hasNext())
        {
            zone=itr.next();
            key=zone.getWardNo();
            value=zone.getNoOfCovid19Cases();
            graphData.put(Integer.toString(key),value);
        }
        return graphData;
    }
    @Override
    public Map<String,Integer> loadDataPie()
    {
        int teen=0,youth=0,middleAged=0,age;
        Map<String,Integer> graphData = new TreeMap<>();
        COVID19_ACTIVE patient;
        Collection<COVID19_ACTIVE> victims=covid.findAll();
        Iterator<COVID19_ACTIVE> itr=victims.iterator();
        while(itr.hasNext())
        {
            patient=itr.next();
            age=patient.getAge();
            if(age<20)
                teen++;
            else if(age>=20 && age<=35)
                youth++;
            else
                middleAged++;
        }
        graphData.put("teens",teen);
        graphData.put("youths",youth);
        graphData.put("middle-aged",middleAged);
        return graphData;
    }

    @Override
    public Map<String,Integer> loadDataLine()
    {
          List<InfectionData> series = infectionrepo.findAll();
          Map<String,Integer> chartData = new TreeMap<>();
          for(InfectionData victim : series)
          {
                  chartData.put(String.valueOf(victim.getDay()),victim.getCounts());
          }
          return chartData;
    }
}
