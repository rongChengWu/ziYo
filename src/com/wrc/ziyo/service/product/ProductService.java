package com.wrc.ziyo.service.product;

import java.io.Serializable;
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
	@Autowired
	private ProductDao productDao;

	@Override
	public void save(Product t) throws Exception {
		this.productDao.save(t);
	}

	@Override
	public List<Product> findByExample(Product t, int offset, int size)
			throws Exception {
		return this.productDao.findByExample(t, offset, size);
	}

	@Override
	public Product get(Serializable id) throws Exception {
		return this.productDao.get(id);
	}

	@Override
	public void update(Product t) throws Exception {
		this.productDao.update(t);
	}

	@Override
	public List<Product> findAll() throws Exception {
		return this.productDao.findAll();
	}

	public List<Product> getProList(String whereStr) throws Exception {
		String sql = " select t from Product t " + whereStr;
		return this.productDao.find(sql);
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
