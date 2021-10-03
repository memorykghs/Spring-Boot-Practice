package com.springboot.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class INTRESVT001Tranrs {

	@JsonProperty("ResvId")
	private String resvId;
}
