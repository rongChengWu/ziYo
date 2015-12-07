package com.wrc.ziyo.dao.product;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.wrc.ziyo.dao.BaseDao;
import com.wrc.ziyo.pojo.Product;

@Repository
@Component("productDao")
public class ProductDao extends BaseDao<Product> {

}
