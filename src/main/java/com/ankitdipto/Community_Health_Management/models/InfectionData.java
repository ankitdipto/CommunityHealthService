package com.ankitdipto.Community_Health_Management.models;




import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InfectionData {

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private long day; 

      @Column(name="date")
      private Date date;  
      
      @Column(name="NoOfCases")
      private int counts;

      public Date getDate() {
            return date;
      }

      public void setDate(Date date) {
            this.date = date;
      }

      public int getCounts() {
            return counts;
      }

      public void setCounts(int counts) {
            this.counts = counts;
      }

      public long getDay() {
            return day;
      }

      public void setDay(long day) {
            this.day = day;
      }

      
}
