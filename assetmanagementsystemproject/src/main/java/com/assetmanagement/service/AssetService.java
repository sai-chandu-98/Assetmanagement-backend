package com.assetmanagement.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.assetmanagement.bean.Assets;
import com.assetmanagement.excpection.AssetNotFoundException;
import com.assetmanagement.model.AssetsDTO;
@Repository
@Transactional
public interface AssetService {
	public Assets createAsset(AssetsDTO assetsdto);

	public Assets getAssets(Long AssetsId) throws AssetNotFoundException;

	public List<Assets> list();
	
	public Assets updateAssertStatus(long assertId, String status) throws AssetNotFoundException;;

}
