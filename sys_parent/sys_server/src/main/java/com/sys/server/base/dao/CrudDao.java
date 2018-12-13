package com.sys.server.base.dao;

import java.util.List;

import tk.mybatis.mapper.common.BaseMapper;

public interface CrudDao<T> extends BaseMapper<T>{

	public List<T> findList(T entity);
}
