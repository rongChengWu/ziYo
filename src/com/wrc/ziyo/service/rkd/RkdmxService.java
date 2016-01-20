package com.wrc.ziyo.service.rkd;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.rkd.RkdmxDao;
import com.wrc.ziyo.pojo.Rkdmx;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("rkdmxService")
public class RkdmxService extends BaseService<Rkdmx> {

	private RkdmxDao rkdmxDao;

	public RkdmxDao getRkdmxDao() {
		return rkdmxDao;
	}

	public List findByTp_id(int tp_id) throws Exception {
		String where = " where tp_id=? and sysl>0 order by id";
		return rkdmxDao.findByHqlWher(where, tp_id);
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
	public List<Rkdmx> findByCriteria(Rkdmx rkdmx, int offset, int size)
			throws Exception {

		return super.findByCriteria(createDc(rkdmx), offset, size);
	}

	public int getCountByCriteria(Rkdmx rkdmx) throws Exception {

		return super.findByCriteria(createDc(rkdmx)).size();
	}

	/**
	 * 创建 查询条件
	 * 
	 * @param product
	 * @return
	 */
	private DetachedCriteria createDc(Rkdmx rkdmx) {
		DetachedCriteria dc = DetachedCriteria.forClass(Rkdmx.class);
		dc.createAlias("product", "product");
		if (rkdmx.getProduct() != null && rkdmx.getProduct().getCpmc() != null
				&& rkdmx.getProduct().getCpmc().trim().length() > 0)
			dc.add(Restrictions.like("product.cpmc", rkdmx.getProduct()
					.getCpmc(), MatchMode.ANYWHERE));
		if (rkdmx.getProduct() != null && rkdmx.getProduct().getCpgg() != null
				&& rkdmx.getProduct().getCpgg().trim().length() > 0)
			dc.add(Restrictions
					.eq("product.cpgg", rkdmx.getProduct().getCpgg()));
		if (rkdmx.getProduct() != null && rkdmx.getProduct().getTsid() != null)
			dc.add(Restrictions
					.eq("product.tsid", rkdmx.getProduct().getTsid()));
		if (rkdmx.getProduct() != null && rkdmx.getProduct().getCplx() != null)
			dc.add(Restrictions
					.eq("product.cplx", rkdmx.getProduct().getCplx()));
		dc.addOrder(Order.desc("id"));
		return dc;
	}

	@Autowired
	public void setRkdmxDao(RkdmxDao rkdmxDao) {
		super.setBaseDao(rkdmxDao);
		this.rkdmxDao = rkdmxDao;
	}

}
