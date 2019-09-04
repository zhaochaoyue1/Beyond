package com.example.student.project.dao;


import com.example.student.project.domain.AgentShop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 探店 数据层
 * 
 * @author ruoyi
 * @date 2019-07-17
 */
public interface IAgentShopDao 
{
	List<AgentShop>  getAgentShopList();
	
}