package com.mystore.My_Store.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class SaleDetail {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotNull
	    private LocalDate shopDate;

	    @NotNull
	    @Pattern(regexp="(^$|[0-9]{10})")
	    private String mobileNo;

	    @NotNull
	    private String custName;

	    @NotNull
	    @ManyToOne
	    @JoinColumn(name = "Itemid")
	    private Item item;

	    private String address;

	    private String state;

	    @NotNull
	    private LocalDate dateOfBirth;

	    private Boolean minor;

	    @NotNull
	    private Integer quantity;

	    @NotNull
	    private BigDecimal price;

	    @NotNull
	    private BigDecimal payAmount;

	    @Email
	    private String emailId;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDate getShopDate() {
			return shopDate;
		}

		public void setShopDate(LocalDate shopDate) {
			this.shopDate = shopDate;
		}

		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getCustName() {
			return custName;
		}

		public void setCustName(String custName) {
			this.custName = custName;
		}

		public Item getItem() {
			return item;
		}

		public void setItem(Item item) {
			this.item = item;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public Boolean getMinor() {
			return minor;
		}

		public void setMinor(Boolean minor) {
			this.minor = minor;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public BigDecimal getPayAmount() {
			return payAmount;
		}

		public void setPayAmount(BigDecimal payAmount) {
			this.payAmount = payAmount;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
	    

}
