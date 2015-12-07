package com.wrc.ziyo.dao.system;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.wrc.ziyo.dao.BaseDao;
import com.wrc.ziyo.pojo.Node;

@Repository
@Component("nodeDao")
public class NodeDao extends BaseDao<Node> {

}
