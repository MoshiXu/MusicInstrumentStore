package com.DAO;

import com.model.RegisterBean;


public interface DAO{

	void addProduct(RegisterBean u);
	void validateProduct(RegisterBean u);
	void deleteProduct(RegisterBean u);
	void fetchProdcut();
	void updateProduct(RegisterBean u);
}


