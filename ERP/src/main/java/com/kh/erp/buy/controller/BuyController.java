package com.kh.erp.buy.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.erp.buy.model.service.BuyService;
import com.kh.erp.buy.model.vo.Purchase;



@Controller
public class BuyController {
	
	@Autowired
	BuyService buyService;
	

	
	
	
	@RequestMapping("/buy/buy_lookup.do")
	public String buy_lookup(Model model) {
		
		ArrayList<Map<String, String>> list = new ArrayList<>(buyService.purchaseList()); // 구매 목록 조회
		
		model.addAttribute("list", list); 

		
		ArrayList<Map<String, String>> mlist = new ArrayList<>(buyService.mList()); // 자재 리스트
		
		model.addAttribute("mlist", mlist);
		
		
		ArrayList<Map<String, String>> plist = new ArrayList<>(buyService.pList()); // 물품 리스트
		
		model.addAttribute("plist", plist);
		
		ArrayList<Map<String, String>> ptlist = new ArrayList<>(buyService.ptList()); // 거래처 리스트
		
		model.addAttribute("ptlist", ptlist);
		
		
		ArrayList<Map<String, String>> slist = new ArrayList<>(buyService.sList()); // 창고 리스트
		
		model.addAttribute("slist", slist);
		
		ArrayList<Map<String, String>> elist = new ArrayList<>(buyService.eList()); // 창고 리스트
		
		model.addAttribute("elist", elist);	
		
		return "buy/buy_lookup";
	}
	
	@RequestMapping("/buy/buy_insert.do")
	public String buy_insert(Purchase purchase, Model model) {
		
		int result = buyService.insertPurchase(purchase);
		
		String msg = "";
		if( result > 0) {
			msg="등록 성공!";
			
		} else {
			msg="등록 실패!";
		}
		
		String loc="/buy/buy_lookup.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
	@RequestMapping("/buy/buy_insertS.do")
	public String buy_insertS(Purchase purchase, Model model) {
		
		int result = buyService.insertPurchaseS(purchase);
		
		String msg = "";
		if( result > 0) {
			msg="이동 성공!";
			
		} else {
			msg="이동 실패!";
		}
		
		String loc="/buy/buy_lookup.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
	@RequestMapping("/buy/buy_update.do")
	public String buy_update(Purchase purchase,Model model) {
		
		
		int result = buyService.updatePurchase(purchase);
		// 2. 처리 결과에 따른 화면 설정

		String msg = "";
		
		if(result > 0) {
			msg="수정 성공!!";
		} else {
			msg = "수정 실패!";
		}
		
		String loc="/buy/buy_lookup.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		
		return "common/msg";		
	}
	
	@RequestMapping("/buy/buy_updateS.do")
	public String buy_updateS(Purchase purchase,Model model) {
		
		
		int result = buyService.updatePurchaseS(purchase);
		// 2. 처리 결과에 따른 화면 설정

		String msg = "";
		
		if(result > 0) {
			msg="구매 완료";
		} else {
			msg = "구매 실패!";
		}
		
		String loc="/buy/buy_lookup.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		
		return "common/msg";		
	}
	
	@RequestMapping("/buy/buy_delete.do")
	public String buy_delete(@RequestParam int buy_code, Model model) {
		
		int result = buyService.deletePurchase(buy_code);
		String msg="";
		if( result > 0 ) {
			msg="삭제 성공!";
		} else {
			msg="삭제 실패!";
		}
		String loc="/buy/buy_lookup.do";
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
	
	/*
	  @RequestMapping("/buy/buyExcelOutput.do") public void saleExcelOutput(
	  
	  @RequestParam(value="statusIdx") int statusIdx,
	  
	  @RequestParam(value="ecode") int eCode, HttpServletResponse response, Model
	  model )throws Exception { ArrayList<Purchase> saleList = new ArrayList<>
	  (buyService.buyHistory(eCode)); ArrayList<Purchase> saleItemList = new
	  ArrayList<> (saleService.itemHistory(eCode)); SimpleDateFormat day = new
	  SimpleDateFormat("yyyy_MM_dd"); SimpleDateFormat time = new
	  SimpleDateFormat("hh_mm_ss");
	  
	  ArrayList<SaleItem> afterItemList = new ArrayList<>();
	  
	  for(int i=0; i<saleItemList.size();i++) { if(statusIdx ==
	  (saleItemList.get(i)).getSal_Code()) afterItemList.add(saleItemList.get(i));
	  } String salDay = ""; for(int i = 0; i<saleList.size();i++) {
	  if(saleList.get(i).getSal_Code()==statusIdx) { salDay =
	  day.format(saleList.get(i).getSalDay()); break; } } Workbook wb = new
	  HSSFWorkbook(); Sheet sheet = wb.createSheet(salDay+"_판매물품"); //ex
	  2019-07-23_판매물품 Row row = null; Cell cell = null; int rowNo = 0;
	  
	  // 테이블 헤더's 스타일 CellStyle headStyle = wb.createCellStyle();
	  headStyle.setBorderTop(BorderStyle.THIN);
	  headStyle.setBorderBottom(BorderStyle.THIN);
	  headStyle.setBorderLeft(BorderStyle.THIN);
	  headStyle.setBorderRight(BorderStyle.THIN);
	  
	  // 배경 : 노랑
	  headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
	  headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	  
	  // 데이터 가운데 정렬 headStyle.setAlignment(HorizontalAlignment.CENTER);
	  
	  // 데이터 경계 테두리의 스타일을 지정 CellStyle bodyStyle = wb.createCellStyle();
	  bodyStyle.setBorderTop(BorderStyle.THIN);
	  bodyStyle.setBorderBottom(BorderStyle.THIN);
	  bodyStyle.setBorderLeft(BorderStyle.THIN);
	  bodyStyle.setBorderRight(BorderStyle.THIN);
	  
	  // create header row = sheet.createRow(rowNo++); cell=row.createCell(0);
	  cell.setCellStyle(headStyle); cell.setCellValue("판매코드");
	  cell=row.createCell(1); cell.setCellStyle(headStyle);
	  cell.setCellValue("물품명"); cell=row.createCell(2);
	  cell.setCellStyle(headStyle); cell.setCellValue("판매수량");
	  cell=row.createCell(3); cell.setCellStyle(headStyle);
	  cell.setCellValue("제조원가"); cell=row.createCell(4);
	  cell.setCellStyle(headStyle); cell.setCellValue("판매가");
	  cell=row.createCell(5); cell.setCellStyle(headStyle);
	  cell.setCellValue("창고코드"); cell=row.createCell(6);
	  cell.setCellStyle(headStyle); cell.setCellValue("수익율");
	  cell=row.createCell(7); cell.setCellStyle(headStyle);
	  cell.setCellValue("처리상태");//D|E
	  
	  for(SaleItem i : afterItemList) { row = sheet.createRow(rowNo++); cell =
	  row.createCell(0); cell.setCellStyle(bodyStyle);
	  cell.setCellValue(i.getSal_Code()); cell = row.createCell(1);
	  cell.setCellStyle(bodyStyle); cell.setCellValue(i.getSal_Name()); cell =
	  row.createCell(2); cell.setCellStyle(bodyStyle);
	  cell.setCellValue(i.getSal_Amount()); cell = row.createCell(3);
	  cell.setCellStyle(bodyStyle);
	  cell.setCellValue(i.getSal_Price()-i.getSal_Profit()); cell =
	  row.createCell(4); cell.setCellStyle(bodyStyle);
	  cell.setCellValue(i.getSal_Price()); cell = row.createCell(5);
	  cell.setCellStyle(bodyStyle); cell.setCellValue(i.getsCode()); cell =
	  row.createCell(6); cell.setCellStyle(bodyStyle);
	  cell.setCellValue(i.getSal_Discount()); cell = row.createCell(7);
	  cell.setCellStyle(bodyStyle); cell.setCellValue(i.getSal_Status()); } Date
	  today = new Date(); int rdn = (int)(Math.random()*100); String filename =
	  day.format(today)+"_"+time.format(today)+"_"+Integer.toString(rdn);
	  response.setContentType("ms-vnd/excel");
	  response.setHeader("Content-Disposition","attachment;filename="+filename+
	  ".xls");
	  
	  wb.write(response.getOutputStream()); wb.close();
	  
	  
	  }
	 */

}
