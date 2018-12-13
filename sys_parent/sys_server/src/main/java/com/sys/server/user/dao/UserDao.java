package com.sys.server.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sys.server.base.dao.CrudDao;
import com.sys.entity.user.User;

@Mapper
public interface UserDao extends CrudDao<User>{

	@Select("SELECT * FROM t_user")
	public List<User> findList(User user);
}
