package com.springboot.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.dto.INTRESVT001Tranrq;
import com.springboot.rest.dto.INTRESVT001Tranrs;
import com.springboot.rest.exception.ErrorInputException;
import com.springboot.rest.service.INTRESVT001Svc;

import io.swagger.annotations.ApiOperation;

@RestController
public class TestController {
	
	@Autowired
	private INTRESVT001Svc theINTRESVT001Svc;
	
	@ApiOperation("測試一對多、多對一新增")
	@PostMapping(value = "")
	private INTRESVT001Tranrs testOneToMany(@Valid @RequestBody INTRESVT001Tranrq req, Errors err) throws ErrorInputException {
		
		if(err.hasErrors()) {
			throw new ErrorInputException();
		}
		
		return theINTRESVT001Svc.insert(req);
	}
}
