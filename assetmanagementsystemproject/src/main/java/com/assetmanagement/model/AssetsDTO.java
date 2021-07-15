package com.assetmanagement.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;


public class AssetsDTO implements Serializable {
         /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@NotBlank(message="assetname should not be blank")
		private String assetName;
         
		@NotBlank(message="category should not be blank")
		private String category;

		
		public String getAssetName() {
			return assetName;
		}


		public void setAssetName(String assetName) {
			this.assetName = assetName;
		}


		public String getCategory() {
			return category;
		}


		public void setCategory(String category) {
			this.category = category;
		}
		
		
		@Override
		public String toString() {
			return "AssetsDTO [Assetname=" + assetName + ", Category=" + category + "]";
		}
		
		

}
