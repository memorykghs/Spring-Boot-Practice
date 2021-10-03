package com.springboot.rest.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class INTRESVT001Tranrq {

	@Length(max = 10, message = "ResvId長度不可超過10")
	@JsonProperty("ResvId")
	private String resvId;
	
	@NotBlank(message = "CustId不得為空")
	@Length(max = 10, message = "CustId長度不可超過10")
	@JsonProperty("CustId")
	private String custId;
	
	@NotBlank(message = "Mobile不得為空")
	@Length(max = 10, message = "Mobile長度不可超過10")
	@JsonProperty("Mobile")
	private String mobile;

}
