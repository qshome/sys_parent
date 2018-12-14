package com.sys.api.base;

import java.util.List;

import com.sys.entity.page.PageInfo;

public interface BaseInterface<T> {

	public T get(Object key);
	
	public List<T> simpleFindList(T entity);
	
	public List<T> findList(T entity);
	
	public PageInfo<T> simpleFindPage(PageInfo<T> pageInfo,T entity);
	
	public PageInfo<T> findPage(PageInfo<T> pageInfo,T entity);
	
	public T save(T entity);
	
	public T saveSelective(T entity);
	
	public T update(T entity);
	
	public T updateSelective(T entity);
	
	public void delete(T entity);
}
