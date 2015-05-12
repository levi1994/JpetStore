package com.levi.dto;

/*
 * 这是用于获取product.jsp页面相关信息写的DTO，Dao 位于com.levi.jpstore.dao.ProductItemDao
 */

public class ProductItemDTO {
	private static final long serialVersionUID = 1L;
	  private String itemid;
	  private String productid;
	  private Double listprice;
	  private String descn;
	public String getDescn() {
		return descn;
	}
	public void setDescn(String descn) {
		this.descn = descn;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public Double getListprice() {
		return listprice;
	}
	public void setListprice(Double listprice) {
		this.listprice = listprice;
	}
	
}
