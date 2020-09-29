package com.jasper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jasper.bo.Chart1BO;
import com.jasper.bo.ReportBO;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class JasperReportFill 
{
   @SuppressWarnings("unchecked")
   public static void main(String[] args) 
   {
      String sourceFileName = "C://Jasper/jasperreports-5.6.0/test/TestReport.jasper";
      ReportBO reportBO = ReportBO.getDefaultBO();
      List<ReportBO> boList = new ArrayList<>();
      boList.add(reportBO);
      
      JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(boList);
      
      Map parameters = new HashMap();
      Chart1BO chart1 = new Chart1BO("Core Java",90);
      Chart1BO chart2 = new Chart1BO("Standard",40);
      List<Chart1BO> chartList = new ArrayList<Chart1BO>();
      chartList.add(chart1);
      chartList.add(chart2);
      parameters.put("CHART_DATASET", new JRBeanCollectionDataSource(chartList));
      
      try 
      {
    	  String printFileName = JasperFillManager.fillReportToFile(sourceFileName, parameters, beanColDataSource);
    	  if(printFileName != null)
    	  {
    		  JasperExportManager.exportReportToPdfFile(printFileName,"C://Jasper/jasperreports-5.6.0/test/TestReport.pdf");
    	  }
      } 
      catch (JRException e) 
      {
         e.printStackTrace();
      }
   
   }
}