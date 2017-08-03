package com.dao;

import java.util.List;

import com.pojo.Goods;
import com.util.DBUtil;

public class GoodsDao {
	
	public static List<Goods> findAll()
	{
		String sql = "SELECT goodsid, goodsname, goodspic, goodscount, goodsdesc, goodsprice FROM goods";
		return DBUtil.query(Goods.class, sql);
	}
	
	public static Goods findById(int goodsid){
		String sql = "SELECT goodsid, goodsname, goodspic, goodscount, goodsdesc, goodsprice FROM goods WHERE goodsid = ?";
		List<Goods> list = DBUtil.query(Goods.class, sql, goodsid);
		if(!list.isEmpty())
		{
			return list.get(0);
		}
		
		return null;
	}

}
