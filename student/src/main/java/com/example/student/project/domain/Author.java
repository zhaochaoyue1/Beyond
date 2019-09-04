package com.example.student.project.domain;


import java.io.Serializable;

/**
 * sys_author 
 * 
 * @author ruoyi
 * @date 2018-08-08
 */
public class Author implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 作者名 */
	private String name;
	/** 性别（0.男 1.女 2.保密） */
	private Integer sex;
	/** 出生日期 */
	private String birthday;
	/** 国籍 */
	private String nationality;
	/** 作者头像 */
	private String picture;
	/** 作者简介 */
	private String introduction;
	/** 手机号 */
	private String mobile;
	/** 电话 */
	private String phone;
	/** 邮箱 */
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
