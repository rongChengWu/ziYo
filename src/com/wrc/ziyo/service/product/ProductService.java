package com.wrc.ziyo.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.product.ProductDao;
import com.wrc.ziyo.pojo.Product;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("productService")
public class ProductService extends BaseService<Product> {

	private ProductDao productDao;

	public List<Product> getProList(String whereStr) throws Exception {
		String sql = " select t from Product t " + whereStr;
		return this.productDao.find(sql);
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	@Autowired
	public void setProductDao(ProductDao productDao) {
		super.setBaseDao(productDao);
		this.productDao = productDao;
	}

}
