package com.assetmanagement.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assetmanagement.bean.Assets;
import com.assetmanagement.excpection.AssetNotFoundException;
import com.assetmanagement.model.AssetsDTO;
import com.assetmanagement.service.AssetService;
import com.assetmanagement.service.AssetServiceImpl;

@RestController
@RequestMapping("assets")
public class AssetsController {
	
	
  @Autowired
  private AssetService assetService;


@Autowired
private AssetServiceImpl assetServiceImpl;

@GetMapping
public List<Assets> getAllAssets(){
	return assetService.list();
}

@PostMapping("/create")
public Assets createAsset (@Valid @RequestBody AssetsDTO assetsDTO){
	return assetService.createAsset(assetsDTO);
}

@GetMapping("{assetsId}")
public Assets getAssets (@PathVariable("assetsId") Long AssetsId) throws AssetNotFoundException{
	return assetService.getAssets(AssetsId);
}

@PostMapping("updateAssertStatus/{assetsId}")
public Assets updateAssertStatus (@PathVariable("assetsId") Long assetId, @RequestParam("status") String status) throws AssetNotFoundException{
	return assetService.updateAssertStatus(assetId, status);
}

@DeleteMapping(value="/{assetsId}")
public String deleteAssetsDetailsById(@PathVariable("assetsId") Long id)
{
	assetServiceImpl.deleteAssetsById(id);
	return "asset deleted";
}

}
