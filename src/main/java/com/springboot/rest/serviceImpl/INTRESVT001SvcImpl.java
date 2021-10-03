package com.springboot.rest.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.rest.dto.INTRESVT001Tranrq;
import com.springboot.rest.dto.INTRESVT001Tranrs;
import com.springboot.rest.entity.Customer;
import com.springboot.rest.entity.ResvBiz;
import com.springboot.rest.entity.ResvMaster;
import com.springboot.rest.repository.ResvMasterRepo;
import com.springboot.rest.service.INTRESVT001Svc;

@Service
@Transactional(rollbackFor = Exception.class)
public class INTRESVT001SvcImpl implements INTRESVT001Svc {

	/** OneToMany Repo */
	@Autowired
	private ResvMasterRepo resvMasterRepo;

	@Override
	public INTRESVT001Tranrs insert(INTRESVT001Tranrq tranrq) {
		
		ResvMaster resvMaster = new ResvMaster();
		
		ResvBiz resvBiz = new ResvBiz();
		resvBiz.setResvMaster(resvMaster);
		
		Customer customer = new Customer();
		customer.setCustId(tranrq.getCustId());
		customer.setMobile(tranrq.getMobile());
		
		resvMaster.setCustomer(customer); 
		
		resvMasterRepo.save(resvMaster);
		resvMasterRepo.flush();
		
		INTRESVT001Tranrs tranrs = new INTRESVT001Tranrs();
		tranrs.setResvId(resvMaster.getResvId());
		
		return tranrs;
	}

}
