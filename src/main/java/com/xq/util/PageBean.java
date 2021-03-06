package com.xq.util;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public class PageBean<T> {
	private Integer currentPage;		// 当前页
	private Integer pageSize;			// 每页显示记录数
	private Long totalCount;			// 总记录数
	private Integer totalPage;			// 总页数
	
	private List<T> list = null;

	@Override
	public String toString() {
		return "PageBean{" +
				"currentPage=" + currentPage +
				", pageSize=" + pageSize +
				", totalCount=" + totalCount +
				", totalPage=" + totalPage +
				", list=" + list +
				'}';
	}


	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
