package com.demo;

import com.dao.EmployeeDao;
import com.model.Employee;

public class App 
{
    public static void main( String[] args )
    {
    	
    //to insert a record
  /* 	Employee e=new Employee();
    	e.setEname("Avinash");
    	e.setEcompany("Tudip Softwares");
    	e.setEdesignation("Software Developer");
    	e.setEsalary(50000);
    	if(new EmployeeDao().InsertEmployee(e)>0)
    		System.out.println("Employee Added Successfully..!");
    	else
    		System.out.println("Not Inserted");*/
     
    	
    	//to update a Record
    /*	Employee e1=new Employee();
    	e1.setEid(1);
    	e1.setEname("Atish");
    	e1.setEdesignation("Associate Software Developer");
    	e1.setEcompany("TATA");
    	e1.setEsalary(80000);
    	if(new EmployeeDao().UpdateEmployee(e1)>0)
    		System.out.println("Employee Updated Successfully");
    	else
    		System.out.println("Not Updated");*/
    	
    	//to delete Employee By ID
    	/*if(new EmployeeDao().DeleteEmployeeByID(1)>0)
    		System.out.println("Employee Deleted ..");
    	else
    		System.out.println("Employee Still In Database");*/
    	
    	//to display Record By Employee ID
    	/*Employee e1=new EmployeeDao().DisplayEmployeeByID(2);
    	System.out.println(e1);*/
    	
    	
    	
    	
    }
}
