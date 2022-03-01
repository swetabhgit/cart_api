package com.example.cart.model;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Item {
	@Id
	 private String itemid;

	  private String itemname;

	  private Integer quantity;
	  
	  public String getitemid()
	  {
		 return itemid; 
	  }
	  
	  public String getitemname()
	  {
		  return itemname;
	  }
	  
	  public Integer getquantity()
	  {
		  return quantity;
	  }
	  
	  public void setitemid(String itemid)
	  {
		  this.itemid = itemid;
	  }
	  
	  public void setitemname(String itemname)
	  {
		  this.itemname = itemname;
		  
	  }
	  
	  public void setquantity(Integer quantity)
	  {
		  this.quantity = quantity;
		  
	  }
	  @Override
	  public String toString() {
	    return "{"+"\"test\""+":"+"\"test\"}";
	  }
	  
}
