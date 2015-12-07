package com.wrc.ziyo.dao.suppliers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.wrc.ziyo.dao.BaseDao;
import com.wrc.ziyo.pojo.Suppliers;

@Repository
@Component("suppliersDao")
public class SuppliersDao extends BaseDao<Suppliers> {

}
