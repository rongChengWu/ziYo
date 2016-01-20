package com.wrc.ziyo.util;

public class PageBean {

	private int pageCount;// 总页数 自动计算
	private int pageStart = 1;// 当前页
	private int pageDisplay;// 显示几页
	private int contentSize = 20; // 每页展示内容
	private int contentCount; // 内容总数
	private int startContent;

	public int getPageCount() {
		this.pageCount = contentCount / contentSize;
		if (contentCount % contentSize > 0) {
			this.pageCount += 1;
		}
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageDisplay() {
		if (this.getPageCount() > 10) {
			pageDisplay = 10;
		} else {
			pageDisplay = pageCount;
		}
		return pageDisplay;
	}

	public void setPageDisplay(int pageDisplay) {
		this.pageDisplay = pageDisplay;
	}

	public int getContentSize() {
		return contentSize;
	}

	public void setContentSize(int contentSize) {
		this.contentSize = contentSize;
	}

	public int getContentCount() {
		return contentCount;
	}

	public void setContentCount(int contentCount) {
		this.contentCount = contentCount;
	}

	public int getStartContent() {
		this.startContent = ((this.getPageStart() - 1) * this.getContentSize());
		return startContent;
	}

	public void setStartContent(int startContent) {
		this.startContent = startContent;
	}

}
