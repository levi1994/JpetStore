package com.levi.jpstore.bean;

public class LineItemBean {
  private int orderid;
  private int linenum;
  private int quantity;
  private String itemid;
  private double unitprice;
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getLinenum() {
	return linenum;
}
public void setLinenum(int linenum) {
	this.linenum = linenum;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getItemid() {
	return itemid;
}
public void setItemid(String itemid) {
	this.itemid = itemid;
}
public double getUnitprice() {
	return unitprice;
}
public void setUnitprice(double unitprice) {
	this.unitprice = unitprice;
}

}
