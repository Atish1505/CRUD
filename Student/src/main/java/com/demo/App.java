package com.demo;

import com.Dao.StudentDao;
import com.model.Student;

public class App 
{
    public static void main( String[] args )
    {
    	//To insert a Record
   /* 	Student s=new Student();
    	s.setSname("Salman");
    	s.setScity("Jalna");
    	s.setSper(88);
    	if(new StudentDao().InsertStudent(s)>0)
    		System.out.println("Record Inserted");
    	else
    		System.out.println("Record Still not Inserted"); */
    	
    	
    	//TO update a Record
    /*	Student s=new Student();
    	s.setSid(9);
    	s.setSname("Salman Mamu");
    	s.setScity("Pune");
    	s.setSper(101);
    	if(new StudentDao().UpdateStudent(s)>0)
    		System.out.println("Student Updated Successfully");
    	else
    		System.out.println("Student Still Not Updated"); */
    	
    	//To delete a Student
    	/*
        if(new StudentDao().DeleteStudentByID(1)>0)
    		System.out.println("Student Deleted Successfully..!");
    	else
    		System.out.println("Student Still Not Deleted");  */
    	
    	//To delete a Record
    	Student s=new StudentDao().DisplayStudentBYID(2);
    	System.out.println(s);
    	
    	
    	
    	
    	
    	
    }
}
