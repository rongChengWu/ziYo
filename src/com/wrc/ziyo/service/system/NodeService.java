package com.wrc.ziyo.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.system.NodeDao;
import com.wrc.ziyo.pojo.Node;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("nodeService")
public class NodeService extends BaseService<Node> {

	@Autowired
	private NodeDao nodeDao;

	public List<Node> findAll() throws Exception {
		return this.nodeDao.findAll();
	}

	public NodeDao getNodeDao() {
		return this.nodeDao;
	}

	public void setNodeDao(NodeDao nodeDao) {
		this.nodeDao = nodeDao;
	}
}
