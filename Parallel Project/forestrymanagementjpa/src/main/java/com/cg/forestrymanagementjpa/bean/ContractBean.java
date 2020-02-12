package com.cg.forestrymanagementjpa.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contract")
public class ContractBean {
	@Id
	@Column
	private int contractNo;
	@Column
	private int customerId;
	@Column
	private int haulierId;
	@Column
	private int productId;
////	@ManyToOne
////	@JoinColumn(name="customerId")
//	private CustomerBean customer;
//	@ManyToOne
//	@JoinColumn(name="haulierId")
//	private HaulierBean haulier;
//	@OneToOne
//	@JoinColumn(name="productId")
//	private ProductBean product;
	@Column
	private String deliveryDate;
	@Column
	private String deliveryDay;
	@Column
	private int quantity;

	public int getContractNo() {
		return contractNo;
	}

	public void setContractNo(int contractNo) {
		this.contractNo = contractNo;
	}
	
//	public CustomerBean getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(CustomerBean customer) {
//		this.customer = customer;
//	}
//
//	public HaulierBean getHaulier() {
//		return haulier;
//	}
//
//	public void setHaulier(HaulierBean haulier) {
//		this.haulier = haulier;
//	}
//
//	public ProductBean getProduct() {
//		return product;
//	}
//
//	public void setProduct(ProductBean product) {
//		this.product = product;
//	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getHaulierId() {
		return haulierId;
	}

	public void setHaulierId(int haulierId) {
		this.haulierId = haulierId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryDay() {
		return deliveryDay;
	}

	public void setDeliveryDay(String deliveryDay) {
		this.deliveryDay = deliveryDay;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
