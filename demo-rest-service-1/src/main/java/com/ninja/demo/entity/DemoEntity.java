package com.ninja.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

//import org.hibernate.annotations.DynamicUpdate;
//import org.hibernate.annotations.SelectBeforeUpdate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_Customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode


public class DemoEntity {
	@Id
	 @GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="cId")
	 Long customerID;
 

 @NotBlank (message = "Customer Name is mandatory")
 @Column(name="cName")
 String customerName;
 @Column(name="cEmail")
 String customerEmail;
 @Column(name="cCity")
 String customerCity;
 @Column(name="cState")
 String customerState;
/**
 * @return the customerName
 */
public String getCustomerName() {
	return customerName;
}
/**
 * @param customerName the customerName to set
 */
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
/**
 * @return the customerEmail
 */
public String getCustomerEmail() {
	return customerEmail;
}
/**
 * @param customerEmail the customerEmail to set
 */
public void setCustomerEmail(String customerEmail) {
	this.customerEmail = customerEmail;
}
/**
 * @return the customerCity
 */
public String getCustomerCity() {
	return customerCity;
}
/**
 * @param customerCity the customerCity to set
 */
public void setCustomerCity(String customerCity) {
	this.customerCity = customerCity;
}
/**
 * @return the customerState
 */
public String getCustomerState() {
	return customerState;
}
/**
 * @param customerState the customerState to set
 */
public void setCustomerState(String customerState) {
	this.customerState = customerState;
}

}