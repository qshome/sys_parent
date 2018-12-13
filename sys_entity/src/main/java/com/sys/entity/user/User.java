package com.sys.entity.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sys.entity.page.BaseEntity;

@Table(name = "t_user")
public class User extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6941892511299562912L;

	@Id
	@Column(name="key_id")
	private String id;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="createDate")
	private Date createDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "MyTest [id=" + id + ", age=" + age + ", createDate=" + createDate + "]";
	}
	
}
