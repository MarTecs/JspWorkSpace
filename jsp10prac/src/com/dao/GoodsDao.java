package com.dao;

import java.util.List;

import com.pojo.Goods;
import com.util.DBUtil;

public class GoodsDao {
	
	public static List<Goods> findAll()
	{
		String sql = "SELECT goodsid, goodsname, goodspic, goodscount, goodsdesc, goodsprice FROM goods";
		List<Goods> list = DBUtil.query(Goods.class, sql);
		return list;
	}
	
	public static Goods findById(String goodsid)
	{
		String sql = "SELECT goodsid, goodsname, goodspic, goodscount, goodsdesc, goodsprice FROM goods WHERE goodsid = ?";
		List<Goods> list = DBUtil.query(Goods.class, sql, goodsid);
		if(!list.isEmpty())
		{
			System.out.println("s");
			return list.get(0);
		}
		return null;
		
	}

}
