package com.assetmanagement.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assetmanagement.bean.Assets;
import com.assetmanagement.bean.Employee;
import com.assetmanagement.bean.RequestAssets;
import com.assetmanagement.excpection.RequestAssetsNotFoundException;
import com.assetmanagement.model.RequestAssetsDTO;
import com.assetmanagement.repository.AssetRepository;
import com.assetmanagement.repository.EmployeeRepository;
import com.assetmanagement.repository.RequestAssetsRepository;

@Service
public class RequestAssetsServiceImpl implements RequestAssetsService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AssetRepository assetRepository;
	
	@Autowired
	private RequestAssetsRepository requestAssetsRepository;

	@Override
	public RequestAssets createRequestAssets(RequestAssetsDTO requestassetsdto) {
		RequestAssets requestassets = new RequestAssets();
		BeanUtils.copyProperties(requestassetsdto,requestassets);
		Optional<Employee> optional = employeeRepository.findById(1L);
		Employee employee = optional.get();
		requestassets.setEmployee(employee);
		Optional<Assets> assertsOp = assetRepository.findById(1L);
		Assets assets = assertsOp.get();
		requestassets.setAssets(assets);
		return requestAssetsRepository.save(requestassets) ;
	}
	
	

	@Override
	public RequestAssets getRequestAsset(Long Id) throws  RequestAssetsNotFoundException{
		
		Optional<RequestAssets> requestassets = requestAssetsRepository.findById(Id);
		if (!requestassets.isPresent()) {
			throw new RequestAssetsNotFoundException("requestAssets Deatils Not Found for Id " + Id);
		} else {
			return requestassets.get();
		}
	}
	

}
