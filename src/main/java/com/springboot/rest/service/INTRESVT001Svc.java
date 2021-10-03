package com.springboot.rest.service;

import com.springboot.rest.dto.INTRESVT001Tranrq;
import com.springboot.rest.dto.INTRESVT001Tranrs;

public interface INTRESVT001Svc {

	/**
	 * 測試 OneToMany
	 * @param req
	 * @return
	 */
	INTRESVT001Tranrs insert(INTRESVT001Tranrq req);
}
