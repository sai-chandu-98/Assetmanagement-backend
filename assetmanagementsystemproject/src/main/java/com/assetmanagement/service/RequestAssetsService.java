package com.assetmanagement.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.assetmanagement.bean.RequestAssets;
import com.assetmanagement.excpection.RequestAssetsNotFoundException;
import com.assetmanagement.model.RequestAssetsDTO;


@Repository
@Transactional
public interface RequestAssetsService {
	
	public RequestAssets createRequestAssets(RequestAssetsDTO requestassetsdto);
	
	public RequestAssets getRequestAsset(Long Id) throws  RequestAssetsNotFoundException;


}
