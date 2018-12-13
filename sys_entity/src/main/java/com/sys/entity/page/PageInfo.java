package com.sys.entity.page;

import java.util.List;

import com.github.pagehelper.Page;

public class PageInfo<T> {

	private int pageNo;
	
	private int pageSize;
	
	private long count;
	
	private int startNo;
	
	private int endNo;
	
	private List<T> list;
	
	private Page<T> page;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo==0?1:pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public int getStartNo() {
		return startNo==0?(this.pageNo-1)*this.pageSize+1:startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getEndNo() {
		return endNo==0?(this.pageNo-1)*this.pageSize+this.pageSize:endNo;
	}

	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}


}
