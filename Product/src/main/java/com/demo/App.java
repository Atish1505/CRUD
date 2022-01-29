package com.demo;

import com.dao.ProductDao;
import com.model.Product;

public class App 
{
    public static void main( String[] args )
    {
    	
    	// To Insert a Record
		 
		/*
		 * Product p=new Product(); p.setPname("Fair & Lovely");
		 * p.setPcategory("Grocery"); p.setQty(40); p.setPrice(70); if(new
		 * ProductDao().InsertProduct(p)>0)
		 * System.out.println("Product Added Successfully"); else
		 * System.out.println("Product Still Not Added..");
		 */
		 
    	
    	//To Update a Record
		/*
		 * Product p=new Product(); p.setPid(1); p.setPname("Fair & Lovely");
		 * p.setPcategory("Grocery"); p.setQty(40); p.setPrice(70); if(new
		 * ProductDao().UpdateProduct(p)>0)
		 * System.out.println("Product Updated Successfully"); else
		 * System.out.println("Product Still Not Updated..");
		 *
		 */
    	//To delete a Record
		/*
		 * if(new ProductDao().DeleteProduct(2)>0)
		 * System.out.println("Product Deleted Successfully"); else
		 * System.out.println("Product Still in Database.");
		 */
    	
    	//To display a Record by ID
    	Product p=new ProductDao().DisplayProductByID(1);
    	System.out.println(p);
    }
}
