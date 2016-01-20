package com.wrc.ziyo.service.product;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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

	/**
	 * QBE 分页查询
	 * 
	 * @param product
	 * @param offset
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public List<Product> findByCriteria(Product product, int offset, int size)
			throws Exception {

		return super.findByCriteria(createDc(product), offset, size);
	}

	public int getCountByCriteria(Product product) throws Exception {

		return super.findByCriteria(createDc(product)).size();
	}

	/**
	 * 创建 查询条件
	 * 
	 * @param product
	 * @return
	 */
	private DetachedCriteria createDc(Product product) {
		DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
		if (product.getCpmc() != null && product.getCpmc().trim().length() > 0)
			dc.add(Restrictions.like("cpmc", product.getCpmc(),
					MatchMode.ANYWHERE));
		if (product.getCpgg() != null && product.getCpgg().trim().length() > 0)
			dc.add(Restrictions.eq("cpgg", product.getCpgg()));
		if (product.getTsid() != null)
			dc.add(Restrictions.eq("tsid", product.getTsid()));
		if (product.getCplx() != null)
			dc.add(Restrictions.eq("cplx", product.getCplx()));
		dc.addOrder(Order.desc("id"));
		return dc;
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
