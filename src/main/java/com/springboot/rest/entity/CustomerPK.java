package com.springboot.rest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class CustomerPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CUST_ID")
	private String custId;
	
	@Column(name = "MOBILE")
	private String mobile;
}
