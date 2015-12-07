//获取浏览器类型
function getBrowserName(){
var user_agent = navigator.userAgent.toLowerCase();
if(user_agent.indexOf("firefox") != -1)
return "FF";
else if(user_agent.indexOf("msie") != -1)
return "IE";
else if(user_agent.indexOf("opera") != -1)
return "Opera";
return "Other";
}

function ShowTree(fanodeid, obj){
	var objname=obj.name;
	var tree = document.getElementsByName(objname);
	for(var i=0;i<tree.length;i++){
		tree[i].className="";
	}
	obj.className="current";
	parent.leftFrame.location.href="/ziYo/jsp/system/treeNode.jsp?fanodeid="+fanodeid;
}


function Node(id, pid, name, url, title, target, icon, iconOpen, open,level,nameOpen) {

 this.id = id;

 this.pid = pid;

 this.name = name;

 this.url = url;

 this.title = title;

 this.target = target;

 this.icon = icon;

 this.iconOpen = iconOpen;

 this._io = open || false;
 
 this.level = level;
 
 this.nameOpen = nameOpen || false;

 this._is = false;

 this._ls = false;

 this._hc = false;

 this._ai = 0;

 this._p;

};


// Tree object

function dTree(objName) {

 this.config = {

  target     : "rightFrame",//所有节点的target  

  folderLinks   : false,//true    文件夹可链接 

  useSelection  : true,//true    节点可被选择(高亮)  

  useCookies   : false,//true    树可以使用cookies记住状态  

  useLines    : true,//true    创建带线的树 

  useIcons    : true,//true    创建带有图标的树  

  useStatusText  : false,// false    用节点名替代显示在状态栏的节点url  

  closeSameLevel : false,//false    只有一个有父级的节点可以被展开,当这个函数可用时openAll() 和 closeAll() 函数将不可用 

  inOrder     : false//  false    如果父级节点总是添加在子级节点之前,使用这个参数可以加速菜单显示.

 }

 this.icon = {

  root    : '/ziYo/images/treeImg/base.gif',//根节点默认图

  folder   : '/ziYo/images/treeImg/folder.gif',//关闭时默认图

  folderOpen : '/ziYo/images/treeImg/folderopen.gif',//打开时默认图

  node    : '/ziYo/images/treeImg/page.gif',//

  empty    : '/ziYo/images/treeImg/empty.gif',

  line    : '/ziYo/images/treeImg/line.gif',

  join    : '/ziYo/images/treeImg/join.gif',

  joinBottom : '/ziYo/images/treeImg/joinbottom.gif',

  plus    : '/ziYo/images/treeImg/plus.gif',

  plusBottom : '/ziYo/images/treeImg/plusbottom.gif',

  minus    : '/ziYo/images/treeImg/minus.gif',

  minusBottom : '/ziYo/images/treeImg/minusbottom.gif',

  nlPlus   : '/ziYo/images/treeImg/nolines_plus.gif',

  nlMinus   : '/ziYo/images/treeImg/nolines_minus.gif'

 };

 this.obj = objName;

 this.aNodes = [];

 this.aIndent = [];

 this.root = new Node(-1);

 this.selectedNode = null;

 this.selectedFound = false;

 this.completed = false;

};

 //第一个参数，表示当前节点的ID      
//第二个参数，表示当前节点的父节点的ID,根节点的值为 -1     
//第三个参数，节点要显示的文字      
//第四个参数，节点的Url      
//第五个参数，鼠标移至该节点时节点的Title      
//第六个参数，节点的target 
//第七个参数，用做节点的图标,节点没有指定图标时使用默认值 
//第八个参数，用做节点打开的图标,节点没有指定图标时使用默认值 
//第九个参数，判断节点是否打开 
//第十个参数，当前节点层数
//第十一个参数，判断节点最低层是否连接
// Adds a new node to the node array
//id:自身ID pid:父ID name:显示名 url:URL
dTree.prototype.add = function(id, pid, name, url, title, target, icon, iconOpen, open,level,nameOpen) {
 this.aNodes[this.aNodes.length] = new Node(id, pid, name, url, title, target, icon, iconOpen, open,level,nameOpen);

};


 

// Open/close all nodes

dTree.prototype.openAll = function() {

 this.oAll(true);

};

dTree.prototype.closeAll = function() {

 this.oAll(false);

};

 

// Outputs the tree to the page

dTree.prototype.toString = function() {

 var str = '<div class="dtree">\n';

 if (document.getElementById) {

  if (this.config.useCookies) this.selectedNode = this.getSelected();

  str += this.addNode(this.root);

 } else str += 'Browser not supported.';

 str += '</div>';

 if (!this.selectedFound) this.selectedNode = null;

 this.completed = true;

 return str;

};

 

// Creates the tree structure

dTree.prototype.addNode = function(pNode) {

 var str = '';

 var n=0;

 if (this.config.inOrder) n = pNode._ai;

 for (n; n<this.aNodes.length; n++) {

  if (this.aNodes[n].pid == pNode.id) {

   var cn = this.aNodes[n];

   cn._p = pNode;

   cn._ai = n;

   this.setCS(cn);

   if (!cn.target && this.config.target) cn.target = this.config.target;

   if (cn._hc && !cn._io && this.config.useCookies) cn._io = this.isOpen(cn.id);

   if (!this.config.folderLinks && cn._hc) cn.url = null;

   if (this.config.useSelection && cn.id == this.selectedNode && !this.selectedFound) {

     cn._is = true;

     this.selectedNode = n;

     this.selectedFound = true;

   }

   str += this.node(cn, n);

   if (cn._ls) break;

  }

 }

 return str;

};

 

// Creates the node icon, url and text

dTree.prototype.node = function(node, nodeId) {

 var str = '<div class="dTreeNode">' + this.indent(node, nodeId);

 if (this.config.useIcons) {

  if (!node.icon) node.icon = (this.root.id == node.pid) ? this.icon.root : ((node._hc) ? this.icon.folder : this.icon.node);

  if (!node.iconOpen) node.iconOpen = (node._hc) ? this.icon.folderOpen : this.icon.node;

  if (this.root.id == node.pid) {

   node.icon = this.icon.root;

   node.iconOpen = this.icon.root;

  }

  str += '<img id="i' + this.obj + nodeId + '" src="' + ((node._io) ? node.iconOpen : node.icon) + '" alt="" />';

 }

 if (node.url) {

  str += '<a id="s' + this.obj + nodeId + '" class="' + ((this.config.useSelection) ? ((node._is ? 'nodeSel' : 'node')) : 'node') + '"' ;
  //最低层不连接
  if(node.nameOpen){
	  str += 'href="#" onclick = "selectNode(\'' + node.id + '\',\''+node.name+'\','+node.level+'); return false;"';
  }else{
	  str+='href="' + node.url + '"';
  }

  if (node.title) str += ' title="' + node.title + '"';

  if (node.target) str += ' target="' + node.target + '"';

  if (this.config.useStatusText) str += ' onmouseover="window.status=\'' + node.name + '\';return true;" onmouseout="window.status=\'\';return true;" ';

  if (this.config.useSelection && ((node._hc && this.config.folderLinks) || !node._hc))
   //修改是否标题打开子菜单
  if(node.nameOpen){
	  str += ' onclick="javascript:selectNode(\'' + node.id  + '\',\''+node.name+'\','+node.level+');"';
  }else{
	  str += ' onclick="javascript: ' + this.obj + '.s(' + nodeId + ');"';
  }
  str += '>';

 }

 else if ((!this.config.folderLinks || !node.url) && node._hc && node.pid != this.root.id)
     //修改是否标题打开子菜单
	 if(node.nameOpen){
		 str += '<a href="javascript: selectNode(\'' + node.id +  '\',\''+node.name+'\','+node.level+');" class="node">';
	  }else{
		  str += '<a href="javascript: ' + this.obj + '.o(' + nodeId + ');" class="node">';
	  }
 str += node.name;

 if (node.url || ((!this.config.folderLinks || !node.url) && node._hc)) str += '</a>';

 str += '</div>';

 if (node._hc) {

  str += '<div id="d' + this.obj + nodeId + '" class="clip" style="display:' + ((this.root.id == node.pid || node._io) ? 'block' : 'none') + ';">';

  str += this.addNode(node);

  str += '</div>';

 }

 this.aIndent.pop();

 return str;

};


// Adds the empty and line icons

dTree.prototype.indent = function(node, nodeId) {

 var str = '';

 if (this.root.id != node.pid) {

  for (var n=0; n<this.aIndent.length; n++)

   str += '<img src="' + ( (this.aIndent[n] == 1 && this.config.useLines) ? this.icon.line : this.icon.empty ) + '" alt="" />';

  (node._ls) ? this.aIndent.push(0) : this.aIndent.push(1);

  if (node._hc) {

   str += '<a href="javascript: ' + this.obj + '.o(' + nodeId + ');"><img id="j' + this.obj + nodeId + '" src="';

   if (!this.config.useLines) str += (node._io) ? this.icon.nlMinus : this.icon.nlPlus;

   else str += ( (node._io) ? ((node._ls && this.config.useLines) ? this.icon.minusBottom : this.icon.minus) : ((node._ls && this.config.useLines) ? this.icon.plusBottom : this.icon.plus ) );

   str += '" alt="" /></a>';

  } else str += '<img src="' + ( (this.config.useLines) ? ((node._ls) ? this.icon.joinBottom : this.icon.join ) : this.icon.empty) + '" alt="" />';

 }

 return str;

};

 

// Checks if a node has any children and if it is the last sibling

dTree.prototype.setCS = function(node) {

 var lastId;

 for (var n=0; n<this.aNodes.length; n++) {

  if (this.aNodes[n].pid == node.id) node._hc = true;

  if (this.aNodes[n].pid == node.pid) lastId = this.aNodes[n].id;

 }

 if (lastId==node.id) node._ls = true;

};

 

// Returns the selected node

dTree.prototype.getSelected = function() {

 var sn = this.getCookie('cs' + this.obj);

 return (sn) ? sn : null;

};

 

// Highlights the selected node

dTree.prototype.s = function(id) {

 if (!this.config.useSelection) return;

 var cn = this.aNodes[id];

 if (cn._hc && !this.config.folderLinks) return;

 if (this.selectedNode != id) {

  if (this.selectedNode || this.selectedNode==0) {

   eOld = document.getElementById("s" + this.obj + this.selectedNode);

   eOld.className = "node";

  }

  eNew = document.getElementById("s" + this.obj + id);

  eNew.className = "nodeSel";

  this.selectedNode = id;

  if (this.config.useCookies) this.setCookie('cs' + this.obj, cn.id);

 }

};

 

// Toggle Open or close

dTree.prototype.o = function(id) {

 var cn = this.aNodes[id];

 this.nodeStatus(!cn._io, id, cn._ls);

 cn._io = !cn._io;

 if (this.config.closeSameLevel) this.closeLevel(cn);

 if (this.config.useCookies) this.updateCookie();

};

 

// Open or close all nodes

dTree.prototype.oAll = function(status) {

 for (var n=0; n<this.aNodes.length; n++) {

  if (this.aNodes[n]._hc && this.aNodes[n].pid != this.root.id) {

   this.nodeStatus(status, n, this.aNodes[n]._ls)

   this.aNodes[n]._io = status;

  }

 }

 if (this.config.useCookies) this.updateCookie();

};

 

// Opens the tree to a specific node

dTree.prototype.openTo = function(nId, bSelect, bFirst) {

 if (!bFirst) {

  for (var n=0; n<this.aNodes.length; n++) {

   if (this.aNodes[n].id == nId) {

    nId=n;

    break;

   }

  }

 }

 var cn=this.aNodes[nId];

 if (cn.pid==this.root.id || !cn._p) return;

 cn._io = true;

 cn._is = bSelect;

 if (this.completed && cn._hc) this.nodeStatus(true, cn._ai, cn._ls);

 if (this.completed && bSelect) this.s(cn._ai);

 else if (bSelect) this._sn=cn._ai;

 this.openTo(cn._p._ai, false, true);

};

 

// Closes all nodes on the same level as certain node

dTree.prototype.closeLevel = function(node) {

 for (var n=0; n<this.aNodes.length; n++) {

  if (this.aNodes[n].pid == node.pid && this.aNodes[n].id != node.id && this.aNodes[n]._hc) {

   this.nodeStatus(false, n, this.aNodes[n]._ls);

   this.aNodes[n]._io = false;

   this.closeAllChildren(this.aNodes[n]);

  }

 }

}

 

// Closes all children of a node

dTree.prototype.closeAllChildren = function(node) {

 for (var n=0; n<this.aNodes.length; n++) {

  if (this.aNodes[n].pid == node.id && this.aNodes[n]._hc) {

   if (this.aNodes[n]._io) this.nodeStatus(false, n, this.aNodes[n]._ls);

   this.aNodes[n]._io = false;

   this.closeAllChildren(this.aNodes[n]);  

  }

 }

}

 

// Change the status of a node(open or closed)

dTree.prototype.nodeStatus = function(status, id, bottom) {

 eDiv = document.getElementById('d' + this.obj + id);

 eJoin = document.getElementById('j' + this.obj + id);

 if (this.config.useIcons) {

  eIcon = document.getElementById('i' + this.obj + id);

  eIcon.src = (status) ? this.aNodes[id].iconOpen : this.aNodes[id].icon;

 }

 eJoin.src = (this.config.useLines)?

 ((status)?((bottom)?this.icon.minusBottom:this.icon.minus):((bottom)?this.icon.plusBottom:this.icon.plus)):

 ((status)?this.icon.nlMinus:this.icon.nlPlus);

 eDiv.style.display = (status) ? 'block': 'none';

};

 

 

// [Cookie] Clears a cookie

dTree.prototype.clearCookie = function() {

 var now = new Date();

 var yesterday = new Date(now.getTime() - 1000 * 60 * 60 * 24);

 this.setCookie('co'+this.obj, 'cookieValue', yesterday);

 this.setCookie('cs'+this.obj, 'cookieValue', yesterday);

};

 

// [Cookie] Sets value in a cookie

dTree.prototype.setCookie = function(cookieName, cookieValue, expires, path, domain, secure) {

 document.cookie =

  escape(cookieName) + '=' + escape(cookieValue)

  + (expires ? '; expires=' + expires.toGMTString() : '')

  + (path ? '; path=' + path : '')

  + (domain ? '; domain=' + domain : '')

  + (secure ? '; secure' : '');

};

 

// [Cookie] Gets a value from a cookie

dTree.prototype.getCookie = function(cookieName) {

 var cookieValue = '';

 var posName = document.cookie.indexOf(escape(cookieName) + '=');

 if (posName != -1) {

  var posValue = posName + (escape(cookieName) + '=').length;

  var endPos = document.cookie.indexOf(';', posValue);

  if (endPos != -1) cookieValue = unescape(document.cookie.substring(posValue, endPos));

  else cookieValue = unescape(document.cookie.substring(posValue));

 }

 return (cookieValue);

};

 

// [Cookie] Returns ids of open nodes as a string

dTree.prototype.updateCookie = function() {

 var str = '';

 for (var n=0; n<this.aNodes.length; n++) {

  if (this.aNodes[n]._io && this.aNodes[n].pid != this.root.id) {

   if (str) str += '.';

   str += this.aNodes[n].id;

  }

 }

 this.setCookie('co' + this.obj, str);

};

 

// [Cookie] Checks if a node id is in a cookie

dTree.prototype.isOpen = function(id) {

 var aOpen = this.getCookie('co' + this.obj).split('.');

 for (var n=0; n<aOpen.length; n++)

  if (aOpen[n] == id) return true;

 return false;

};

 

// If Push and pop is not implemented by the browser

if (!Array.prototype.push) {

 Array.prototype.push = function array_push() {

  for(var i=0;i<arguments.length;i++)

   this[this.length]=arguments[i];

  return this.length;

 }

};

if (!Array.prototype.pop) {

 Array.prototype.pop = function array_pop() {

  lastElement = this[this.length-1];

  this.length = Math.max(this.length-1,0);

  return lastElement;

 }

};