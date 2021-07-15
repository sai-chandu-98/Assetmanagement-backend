package com.assetmanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assetmanagement.bean.RequestAssets;
import com.assetmanagement.excpection.RequestAssetsNotFoundException;
import com.assetmanagement.model.RequestAssetsDTO;
import com.assetmanagement.service.RequestAssetsService;

@RestController
public class RequestAssetsController {
	
	
	@Autowired
	private RequestAssetsService requestAssetsService;
	
	@PostMapping(value="/createRequestAssets")
	public RequestAssets createRequestAssets(@Valid @RequestBody RequestAssetsDTO requestassetsdto)
	{
		return requestAssetsService.createRequestAssets(requestassetsdto);
	}
	
	
	@GetMapping(value="/getrequestasset/{Id}")
	public RequestAssets getRequestAsset(@RequestBody Long Id) throws  RequestAssetsNotFoundException
	{
		return requestAssetsService.getRequestAsset(Id);
	}

}
