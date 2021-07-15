package com.assetmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assetmanagement.bean.Assets;

@Repository
public interface AssetRepository extends JpaRepository<Assets,Long>{


}
