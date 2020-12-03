package com.ankitdipto.Community_Health_Management.controllers;


import java.util.Map;

import com.ankitdipto.Community_Health_Management.visualisation.graphExecute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HighChartController {

	@Autowired
	graphExecute graphplotter;

	@GetMapping("/get-data-column")
	public ResponseEntity<Map<String, Integer>> getBarChart() {
		
		Map<String,Integer> graphData=graphplotter.loadDataColumn();
		return new ResponseEntity<>(graphData, HttpStatus.OK);
	}
	@GetMapping("/get-data-pie")
	public ResponseEntity<Map<String, Integer>> getPieChart() {
		
		Map<String,Integer> graphData=graphplotter.loadDataPie();
		return new ResponseEntity<>(graphData, HttpStatus.OK);
      }
      
      @GetMapping("/get-data-line")
	public ResponseEntity<Map<String, Integer>> getLineChart() {
		
		Map<String,Integer> graphData=graphplotter.loadDataLine();
		return new ResponseEntity<>(graphData, HttpStatus.OK);
	}
}