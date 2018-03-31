package com.dronebuzzers.rest.part;

public class Part {
  private final String id;
  private final String category;
  private final String type;
  private final String name;
  private final double unitPrice;
  private final String currency;
  
  public Part(){
      super();
      id = "";
      category = "";
      type = "";
      name = "";
      unitPrice = 0.0;
      currency = "";
  }
   
  public Part(String id, String category, String type, String name, double unitPrice, String currency){
      this.id = id;
      this.category = category;
      this.type = type;
      this.name = name;
      this.unitPrice = unitPrice;
      this.currency = currency;
  }
  
  public String getId(){
    return this.id;
  }

  public String getCategory() {
    return this.category;
  }

  public String getType() {
    return this.type;
  }

  public String getName(){
    return this.name;
  }
  
  public double getUnitPrice() {
    return this.unitPrice;
  }

  public String getCurrency() {
    return this.currency;
  } 
  
  @Override
  public String toString(){
    return "ID: " + id 
        + " Category: " + category
        + " Type: " + type
        + " Name: " + name
        + " UnitPrice: " + unitPrice
        + " Currency: " + currency;
  }  
  
}