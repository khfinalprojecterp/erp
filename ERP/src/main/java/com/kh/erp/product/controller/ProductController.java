package com.kh.erp.product.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.erp.m_storage.model.vo.M_storage;
import com.kh.erp.product.model.service.ProductService;
import com.kh.erp.product.model.vo.Product;

/*private int PCODE; // 물품코드
private String PCATE;//분류코드
private String PNAME;//물품명
private String PSIZE;//규격명
private int PBARCODE;//바코드
*/



@Controller
public class ProductController {
@Autowired
ProductService productService;


// 물품을 조회하는 메소드
@RequestMapping(value="/product/insertProduct.do",
method=RequestMethod.GET)
public String insertProductView(Product product) {

System.out.println("insertproduct 화면 메소드 확인");



return "product/Product";
}

//발주요청 기능수행메소드
@RequestMapping(value="/product/insertProduct.do",
method=RequestMethod.POST)
public String insertProduct(
		/*M_storage m_storage*/
		
		@RequestParam int PCODE,
		@RequestParam String PCATE,
		@RequestParam String PNAME,
		@RequestParam String PSIZE,
		@RequestParam int PBARCODE)
		 {

	Product product= new Product(PCODE, PCATE, PNAME, PSIZE,PBARCODE );
	System.out.println(product);
System.out.println("product 화면 메소드 확인");



		  int result = productService.insertProduct(product);
		 
		   System.out.println("insert 결과 : " + result);
		 

return "redirect:/product/ProductList.do";
}




@RequestMapping("/product/ProductList.do")
public String selectProductList(Model model) {
	List<Product> list=productService.selectProductList();
	
	System.out.println("list 확인"+list);
	model.addAttribute("list",list);
	
	return"product/ProductList";
	
	
	}
	
@RequestMapping("/product/updateProduct.do")
public String updateProduct(
		//String PCATE;//분류코드
		/*private String PNAME;//물품명
		private String PSIZE*/
	
		@RequestParam String PNAME ,
	
	
		@RequestParam String PSIZE,
		@RequestParam int PBARCODE,
		 Model model) {
	
	Product product = new Product(PNAME,PSIZE,PBARCODE);
	
	
	int result = productService.updateProduct(product);
	String msg="";
	if( result > 0 ) {
		msg="수정 성공";
	} else {
		msg="수정 실패!";
	}
	String loc="/product/ProductList.do";
	model.addAttribute("loc", loc);
	model.addAttribute("msg", msg);
	
	return "common/msg";		
}




@RequestMapping("/product/deleteProduct.do")
public String deleteProduct(@RequestParam int PCODE, Model model) {
	
	int result = productService.deleteProduct(PCODE);
	String msg="";
	if( result > 0 ) {
		msg="삭제 성공!";
	} else {
		msg="삭제 실패!";
	}
	String loc="/product/ProductList.do";
	model.addAttribute("loc", loc);
	model.addAttribute("msg", msg);
	
	return "common/msg";		
}






}