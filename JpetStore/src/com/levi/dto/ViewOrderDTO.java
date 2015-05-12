package com.levi.dto;

public class ViewOrderDTO {
   private String itemid;
   private String descn;
   private int quantity;
   private Double listprice;
   private Double unitprice;
public String getItemid() {
	return itemid;
}
public void setItemid(String itemid) {
	this.itemid = itemid;
}
public String getDescn() {
	return descn;
}
public void setDescn(String descn) {
	this.descn = descn;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Double getListprice() {
	return listprice;
}
public void setListprice(Double listprice) {
	this.listprice = listprice;
}
public Double getUnitprice() {
	return unitprice;
}
public void setUnitprice(Double unitprice) {
	this.unitprice = unitprice;
}
   
}
