package com.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetmanagement.bean.RequestAssets;

public interface RequestAssetsRepository extends JpaRepository<RequestAssets, Long> {
	
	

}
