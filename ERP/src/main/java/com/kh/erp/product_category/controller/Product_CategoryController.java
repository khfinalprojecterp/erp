package com.kh.erp.product_category.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.erp.m_storage.model.service.M_storageService;
import com.kh.erp.m_storage.model.vo.M_storage;
import com.kh.erp.product_category.model.service.Product_CategoryService;
import com.kh.erp.product_category.model.service.Product_CategoryServiceImpl;
import com.kh.erp.product_category.model.vo.Product_Category;

@Controller
public class Product_CategoryController {
@Autowired
Product_CategoryService product_categoryService;






	
// 발주요청 화면 전환 매소드 
@RequestMapping(value="/product_category/insertProduct_Category.do",
method=RequestMethod.GET)
public String insertProduct_CategoryView(Product_Category product_category) {

System.out.println("product_category 화면 메소드 확인");

//여기까진 되는데 

		/* int result = m_storageService.insert(m_storage); */
		 
		/* System.out.println("insert 결과 : " + result); */
		 

return "product_category/product_category";
}

//발주요청 기능수행메소드
@RequestMapping(value="/product_category/insertProduct_Category.do",
method=RequestMethod.POST)
public String insertProduct_Category(
		/*M_storage m_storage*/
		
		@RequestParam int PCATE,
		@RequestParam String PCNAME
		) {

	Product_Category product_category = new Product_Category(PCATE, PCNAME);
	System.out.println(product_category);
System.out.println("product_category 화면 메소드 확인");

//여기까진 되는데 

		  int result = product_categoryService.insertProduct_Category(product_category);
		 
		   System.out.println("insert 결과 : " + result);
		 

return "redirect:/product_category/Product_CategoryList.do";
}




@RequestMapping("/product_category/Product_CategoryList.do")
public String selectM_storageList(Model model) {
	List<Product_Category> list=product_categoryService.selectProduct_CategoryList();
	
	System.out.println("list 확인"+list);
	model.addAttribute("list",list);
	
	return"product_category/Product_CategoryList";
	
	
	}
	
	



@RequestMapping("/product_category/updateProduct_Category.do")
public String updateProduct_Category(@RequestParam int PCATE ,
		//
	
		@RequestParam String PCNAME,
	
		
		 Model model) {
	
	
	Product_Category product_category = new Product_Category(PCATE,PCNAME);
	
	int result = product_categoryService.updateProduct_Category(product_category);
	String msg="";
	if( result > 0 ) {
		msg="수정 성공";
	} else {
		msg="수정 실패!";
	}
	String loc="/product_category/Product-CategoryList.do";
	model.addAttribute("loc", loc);
	model.addAttribute("msg", msg);
	
	return "common/msg";		
}




@RequestMapping("/product_category/deleteProduct_Category.do")
public String deleteM_storage(@RequestParam int PCATE, Model model) {
	
	int result = product_categoryService.deleteProduct_Category(PCATE);
	String msg="";
	if( result > 0 ) {
		msg="삭제 성공!";
	} else {
		msg="삭제 실패!";
	}
	String loc="/product_category/Product_CategoryList.do";
	model.addAttribute("loc", loc);
	model.addAttribute("msg", msg);
	
	return "common/msg";		
}





}

