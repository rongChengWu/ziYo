package com.wrc.ziyo.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.system.NodeDao;
import com.wrc.ziyo.pojo.Node;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("nodeService")
public class NodeService extends BaseService<Node> {

	private NodeDao nodeDao;

	public NodeDao getNodeDao() {
		return this.nodeDao;
	}

	@Autowired
	public void setNodeDao(NodeDao nodeDao) {
		super.setBaseDao(nodeDao);
		this.nodeDao = nodeDao;
	}
}
