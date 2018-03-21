package com.dronebuzzers.parts.business;

import com.dronebuzzers.parts.repositories.part.Part;

public class OrderSummaryLine {

  private Part part;
  private int count;
  
  public OrderSummaryLine(){
      super();
      part = null;
      count = 0;
  }
   
  public OrderSummaryLine(Part part, int count){
      this.part = part;
      this.count = count;
  }
  
  public Part getPart(){
    return this.part;
  }

  public int getCount() {
    return this.count;
  }

  @Override
  public String toString(){
    return "Part: " + part 
        + " Count: " + count;
  }  
  
}
