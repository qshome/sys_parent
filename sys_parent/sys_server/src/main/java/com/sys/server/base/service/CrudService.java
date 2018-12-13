package com.sys.server.base.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.sys.entity.page.BaseEntity;
import com.sys.entity.page.PageInfo;
import com.sys.server.base.dao.CrudDao;

@Transactional(readOnly = true)
public class CrudService <D extends CrudDao<T>,T extends BaseEntity> {
	
	public static final Logger  logger   =  LoggerFactory.getLogger(CrudService.class);
	
	@Autowired
	private D dao;
	
	public T get(T entity) {
		return dao.selectOne(entity);
	}
	
	public T get(Object key) {
		return dao.selectByPrimaryKey(key);
	}
	
	public List<T> simpleFindList(T entity){
		return dao.select(entity);
	}

	public List<T> findList(T entity){
		return dao.findList(entity);
	}
	
	
	public PageInfo<T> simpleFindPage(PageInfo<T> pageInfo,T entity){
		//.setOrderBy("key_id desc")
		com.github.pagehelper.PageInfo<T> githubPageInfo = PageHelper.startPage(pageInfo.getStartNo(), pageInfo.getEndNo()).doSelectPageInfo(() -> dao.select(entity));
		pageInfo.setList(githubPageInfo.getList());
		pageInfo.setCount(githubPageInfo.getTotal());
		return pageInfo;
	}
	
	public PageInfo<T> findPage(PageInfo<T> pageInfo,T entity){
		com.github.pagehelper.PageInfo<T> githubPageInfo = PageHelper.startPage(pageInfo.getStartNo(), pageInfo.getEndNo()).doSelectPageInfo(() -> dao.findList(entity));
		pageInfo.setList(githubPageInfo.getList());
		pageInfo.setCount(githubPageInfo.getTotal());
		return pageInfo;
	}
	
	@Transactional(readOnly = false)
	public void save(T entity) {
		dao.insert(entity);
	}
	
	@Transactional(readOnly = false)
	public void saveSelective(T entity) {
		dao.insertSelective(entity);
	}
	
	@Transactional(readOnly = false)
	public void update(T entity) {
		dao.updateByPrimaryKey(entity);
	}
	
	@Transactional(readOnly = false)
	public void updateSelective(T entity) {
		dao.updateByPrimaryKeySelective(entity);
	}
	
	@Transactional(readOnly = false)
	public void delete(T entity) {
		dao.delete(entity);
	}
}
