package com.kh.erp.product_category.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.m_storage.model.vo.M_storage;
import com.kh.erp.product_category.model.vo.Product_Category;
@Repository
public class Product_CategoryDaoImpl implements Product_CategoryDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	@Override
	public List<Product_Category> selectProduct_CategoryList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product_category.selectProduct_CategoryList");
	}

	@Override
	public int insertProduct_Category(Product_Category product_category) {
		// TODO Auto-generated method stub
		return sqlSession.insert("product_category.insertProduct_Category",product_category);
	}

	@Override
	public int selectOneProduct_Category(int PCATE) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("product_category.selectProduct_Category",PCATE);
	}

	@Override
	public int updateProduct_Category(Product_Category product_category) {
		// TODO Auto-generated method stub
		return sqlSession.update("product_category.selectProduct_Category",product_category);
	}

	@Override
	public int deleteProduct_Category(int PCATE) {
		// TODO Auto-generated method stub
		return sqlSession.delete("product_category.deleteProduct_Category",PCATE);
	}

}
