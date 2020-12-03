package com.ankitdipto.Community_Health_Management.visualisation;

import java.util.Map;

public interface graphService 
{
    public Map<String,Integer> loadDataColumn(); 
    public Map<String,Integer> loadDataPie();
    public Map<String,Integer> loadDataLine();
}
