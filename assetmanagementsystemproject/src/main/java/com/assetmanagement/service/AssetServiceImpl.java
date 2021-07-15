package com.assetmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assetmanagement.bean.Assets;

import com.assetmanagement.excpection.AssetNotFoundException;

import com.assetmanagement.model.AssetsDTO;
import com.assetmanagement.repository.AssetRepository;

@Service
public class AssetServiceImpl implements AssetService {
	@Autowired
	AssetRepository assetRepository;

	@Override
	public Assets createAsset(AssetsDTO assetdto) {
		Assets assets = new Assets();
		BeanUtils.copyProperties(assetdto, assets);
		assets.setStatus("New");
		return assetRepository.save(assets);
	}

	@Override
	public Assets getAssets(Long assetsId) throws AssetNotFoundException {

		Optional<Assets> asset = assetRepository.findById(assetsId);
		if (!asset.isPresent()) {
			throw new AssetNotFoundException("asset not found");
		} else {
			return asset.get();
		}
	}
	
	

	public void deleteAssetsById(Long id) {
		assetRepository.deleteById(id);
	}

	@Override
	public List<Assets> list() {

		return (List<Assets>) assetRepository.findAll();
	}

	@Override
	public Assets updateAssertStatus(long assertId, String status) throws AssetNotFoundException {
		// TODO Auto-generated method stub
		Optional<Assets> asset = assetRepository.findById(assertId);
		if (!asset.isPresent()) {
			throw new AssetNotFoundException("asset not found");
		} else {
			Assets assets = asset.get();
			assets.setStatus(status);
			return assetRepository.save(assets);
		}
	}
}
