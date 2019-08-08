package com.kh.erp.sale.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.kh.erp.employee.model.vo.Employee;
import com.kh.erp.sale.model.service.SaleService;
import com.kh.erp.sale.model.vo.Partner;
import com.kh.erp.sale.model.vo.Sale;
import com.kh.erp.sale.model.vo.SaleItem;
import com.kh.erp.storage.model.vo.Storage;
import com.kh.erp.storage.model.vo.StorageDetail;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.Transform;
import com.sun.org.apache.xpath.internal.operations.Mod;

@Controller
public class SaleController {
	
	@Autowired
	SaleService saleService;
	
	@RequestMapping("/sale/partnerList.do")//모든 거래처 목록 받아오기
	public String partnerList(
			@RequestParam(value="ecode") int eCode,
			Model model){
		ArrayList<Partner> partnerList;
		partnerList = new ArrayList<>(saleService.selectPartner(eCode));
		
		if(partnerList.isEmpty()) {
			System.out.println("partner is empty(controller)");
			model.addAttribute("loc","sale/partnerList").addAttribute("msg","거래처를 등록해주세요.");
			model.addAttribute("partnerList",partnerList).addAttribute("ecode",eCode);
//			#####jsp 경로 확인필
			return "common/msg";
		} else {
			model.addAttribute("partnerList",partnerList).addAttribute("ecode",eCode);
		 }
		
		return "sale/partnerList";
	}//끝
	
	@RequestMapping("/sale/insertPartner.do")
	public String insertPartner(
			@RequestParam(value="partner") String parName,
			@RequestParam(value="ecode") int ecode,
			Model model
			) {
		String msg = "";
		if(saleService.checkPartner(new Partner(0,ecode,parName,"T"))>=1) {
			msg = "이미 존재하는 거래처입니다.";
		} else {
			if(saleService.registPartner(new Partner(0,ecode,parName,"T"))<=0)
				msg = "거래처 등록에 실패했습니다.";
			else
				msg = "거래처 등록에 성공했습니다.";
		}
		model.addAttribute("loc","/sale/partnerList.do")
		.addAttribute("msg",msg).addAttribute("ecode",ecode);
		return "common/msg";
	}//끝
	
	@RequestMapping("/sale/callOffPartner.do")
	public String callOffPartner(
			@RequestParam(value="partner") String parName,
			@RequestParam(value="ecode") int ecode,
		Model model) {
		String msg = "";
		if(saleService.checkPartner(new Partner(0,ecode,parName,"T"))<=0) {
			msg = "존재하지 않는 거래처입니다.";
		} else {
			if(saleService.changeParSts(new Partner(0,ecode,parName,"T"))<=0)
				msg = "거래처 삭제에 실패했습니다.";
			else
				msg = "거래처 삭제에 성공했습니다.";
		}
		
		model.addAttribute("loc","/sale/partnerList.do")
		.addAttribute("msg",msg).addAttribute("ecode",ecode);
		return "common/msg";
	}//끝
	
	@RequestMapping("/sale/changeNamePartner.do")
	public String changeNamePartner(
			@RequestParam(value="partner") String parName,
			@RequestParam(value="partnerC") int partnerC,
			@RequestParam(value="ecode") int ecode,
		Model model) {
		String msg = "";
		
			if(saleService.changeParName(new Partner(partnerC,ecode,parName,"T"))<=0)
				msg = "거래처 수정에 실패했습니다.";
			else
				msg = "거래처 수정에 성공했습니다.";
		
		
		model.addAttribute("loc","/sale/partnerList.do")
		.addAttribute("msg",msg).addAttribute("ecode",ecode);
		return "common/msg";
	}//끝
	
	
	
	
//	-----------------------------------거래처 끝

	
	
	
	
	@RequestMapping("/sale/ItemList.do")
	public String ItemList(
			@RequestParam(value="ecode") int eCode,
			Model model) {
		ArrayList<Partner> partnerList;//거래처 목록
		ArrayList<Storage> storageList;//창고 목록
		ArrayList<StorageDetail> storageDetailList;//판매품 목록
		ArrayList<Employee> employeeList;//직원 목록
		
		partnerList = new ArrayList<>(saleService.selectPartner(eCode));
		employeeList = new ArrayList<>(saleService.selectEmployeeList(eCode));
//		거래처 목록 받아옴
		storageList = new ArrayList<>(saleService.selectStorage(eCode));
//		창고 목록 받아옴
		storageDetailList = new ArrayList<>(saleService.selectDetailList(eCode));
		for(int i =0; i<storageDetailList.size();i++) {
			StorageDetail sdt=storageDetailList.get(i);
			sdt.setpName(
					saleService.selectItemName(
							(sdt.getmCode()!=null)?sdt.getmCode()
									:sdt.getpCode(),
							(sdt.getmCode()!=null)?"M":"P")
					);
			storageDetailList.set(i, sdt);
		}
//		창고별 물품 목록 받아옴+물품이름 지정
		
//		계정내 직원 리스트 받아옴
		
		model.addAttribute("partnerList",partnerList)
		.addAttribute("storageList",storageList)
		.addAttribute("storageDetailList",storageDetailList)
		.addAttribute("employeeList",employeeList)
		.addAttribute("ecode",eCode);
		return "sale/ItemList";
	}//끝
	
	
	@RequestMapping("/sale/saleItem.do")
	public String saleItem(
			@RequestParam(value="ecode") int eCode,
			@RequestParam(value="statusIdx") String[] statusIdx,//판매품목 번호
			@RequestParam(value="EAS") String[] EAS,//판매수량
			@RequestParam(value="PartnerSelect") String PartnerSelect,//거래처
			@RequestParam(value="salePriceS") String[] salePriceS, //개당 판매가
			//@RequestParam(value="discount") String[] discount, //개당 할인가
			@RequestParam(value="EmployeeSelect") String EmployeeSelect, //직원번호
			Model model
) {
		int result = 0;
		String msg = "";
		
		Sale sale = new Sale();
		ArrayList<SaleItem> saleList = new ArrayList<SaleItem>();
		
		ArrayList<StorageDetail> storageDetailList;//물품 목록
		ArrayList<StorageDetail> saleDetailList = new ArrayList<>();//물품 목록
		
		
		storageDetailList = new ArrayList<>(saleService.selectDetailList(eCode));
		for(int i=0; i<statusIdx.length; i++) {
			StorageDetail afch = storageDetailList.get(Integer.parseInt(statusIdx[i]));
			afch.setSdStock(Integer.parseInt(EAS[i]));
			saleDetailList.add(afch);
		}
		
		result = saleService.saleItem(saleDetailList);
		
		if(result <= 0) {
			System.out.println("판매 오류");
			msg = "판매 등록 중 오류가 발생했습니다.";
		} else {
			/*
			 * 여기서 sale saleitem 준비
			 * */
			sale.seteCode(eCode);
			sale.setIdCode(Integer.parseInt(EmployeeSelect));
			sale.setPartnerC(Integer.parseInt(PartnerSelect));//sale 끝
			for(int i=0;i<statusIdx.length;i++) {
				SaleItem exItem = new SaleItem();
				exItem.setsCode(saleDetailList.get(i).getsCode());
				exItem.setmCode(saleDetailList.get(i).getmCode());
				exItem.setpCode(saleDetailList.get(i).getpCode());
				exItem.setSal_Name(saleService.selectItemName(
						(exItem.getmCode()!=null)?exItem.getmCode()
								:exItem.getpCode(),
						(exItem.getmCode()!=null)?"M":"P")
				);
				exItem.setSal_Amount(Integer.parseInt(EAS[i]));
				exItem.setSal_Price(Integer.parseInt(salePriceS[i]));
				exItem.setSal_Profit(
						exItem.getSal_Price()
						-storageDetailList.get(
							Integer.parseInt(statusIdx[i])).getSdCost());
				exItem.setSal_Status("D");
				
				float revenue= 
						((float)exItem.getSal_Profit()/(float)(storageDetailList.get(
								Integer.parseInt(statusIdx[i])).getSdCost())
						)*100;
						//수익율
				
				exItem.setSal_Discount((int)revenue);//수익율
				
				saleList.add(exItem);
			}
			
			
		result = saleService.saleRegist(sale, saleList);
		}
		
		if(result <= 0){
			System.out.println("판매 물품 등록오류");
			msg = "판매 물품 등록중 오류가 발생했습니다.";
		} else {
			msg = "판매 완료";
		}
		
		model.addAttribute("loc","/sale/ItemList.do")
		.addAttribute("msg",msg).addAttribute("ecode",eCode);
		return "common/msg";
	}
	
	
	
	@RequestMapping("/sale/saleRegist.do")//판매 목록 가져오기
	public String saleRegist(
			@RequestParam(value="ecode") int eCode,
			Model model){
		ArrayList<Partner> partnerList = new ArrayList<>
		(saleService.selectPartner(eCode));
		ArrayList<Employee> employeeList = new ArrayList<>
		(saleService.selectEmployeeList(eCode));
		ArrayList<Sale> saleList = new ArrayList<>
		(saleService.saleHistory(eCode));
		ArrayList<SaleItem> saleItemList = new ArrayList<>
		(saleService.itemHistory(eCode));
		ArrayList<Storage> storageList = new ArrayList<>
		(saleService.selectStorage(eCode));
		
		model.addAttribute("saleList",saleList)
		.addAttribute("saleItemList",saleItemList)
		.addAttribute("ecode",eCode)
		.addAttribute("partnerList",partnerList)
		.addAttribute("storageList",storageList)
		.addAttribute("employeeList",employeeList);
		
		return "sale/saleRegist";
	}
	
	@RequestMapping("/sale/itemDelivery.do")
	public String itemDelivery(
			@RequestParam(value="ecode") int eCode,
			@RequestParam(value="statusIdx") int statusIdx,
			Model model) {
		
		int result=0;
		String msg = "";
		
		result = saleService.itemDelivery(statusIdx);
		
		if(result <= 0){
			System.out.println("판매 물품 등록오류");
			msg = "물품 인계처리 중 오류가 발생했습니다.";
		} else {
			msg = "물품 인계 완료";
		}
		
		model.addAttribute("loc","/sale/saleRegist.do")
		.addAttribute("msg",msg).addAttribute("ecode",eCode);
		
		return "common/msg";
	}
	
	@RequestMapping("/sale/saleExcelOutput.do")
	public void saleExcelOutput(
			@RequestParam(value="statusIdx") int statusIdx,
			@RequestParam(value="ecode") int eCode,
			HttpServletResponse response,
			Model model
			)throws Exception {
		ArrayList<Sale> saleList = new ArrayList<>
		(saleService.saleHistory(eCode));
		ArrayList<SaleItem> saleItemList = new ArrayList<>
		(saleService.itemHistory(eCode));
		SimpleDateFormat day = new SimpleDateFormat("yyyy_MM_dd");
		SimpleDateFormat time = new SimpleDateFormat("hh_mm_ss");
		
		ArrayList<SaleItem> afterItemList = new ArrayList<>();
		
		for(int i=0; i<saleItemList.size();i++) {
			if(statusIdx == (saleItemList.get(i)).getSal_Code())
			afterItemList.add(saleItemList.get(i));
		}
		String salDay = "";
		for(int i = 0; i<saleList.size();i++) {
			if(saleList.get(i).getSal_Code()==statusIdx) {
				salDay = day.format(saleList.get(i).getSalDay());
				break;
			}
		}
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet(salDay+"_판매물품"); //ex 2019-07-23_판매물품
		Row row = null;
		Cell cell = null;
		int rowNo = 0;
		
//		테이블 헤더's 스타일
		CellStyle headStyle = wb.createCellStyle();
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);
		
//		배경 : 노랑
		headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
//		데이터 가운데 정렬
		headStyle.setAlignment(HorizontalAlignment.CENTER);
		
//		데이터 경계 테두리의 스타일을 지정
		CellStyle bodyStyle = wb.createCellStyle();
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);
		
//		create header
		row = sheet.createRow(rowNo++);
		cell=row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("판매코드");
		cell=row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("물품명");
		cell=row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("판매수량");
		cell=row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("제조원가");
		cell=row.createCell(4);
		cell.setCellStyle(headStyle);
		cell.setCellValue("판매가");
		cell=row.createCell(5);
		cell.setCellStyle(headStyle);
		cell.setCellValue("창고코드");
		cell=row.createCell(6);
		cell.setCellStyle(headStyle);
		cell.setCellValue("수익율");
		cell=row.createCell(7);
		cell.setCellStyle(headStyle);
		cell.setCellValue("처리상태");//D|E
		
		for(SaleItem i : afterItemList) {
			row = sheet.createRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(i.getSal_Code());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(i.getSal_Name());
			cell = row.createCell(2);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(i.getSal_Amount());
			cell = row.createCell(3);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(i.getSal_Price()-i.getSal_Profit());
			cell = row.createCell(4);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(i.getSal_Price());
			cell = row.createCell(5);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(i.getsCode());
			cell = row.createCell(6);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(i.getSal_Discount());
			cell = row.createCell(7);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(i.getSal_Status());
		}
		Date today = new Date();
		int rdn = (int)(Math.random()*100);
		String filename = day.format(today)+"_"+time.format(today)+"_"+Integer.toString(rdn);
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition","attachment;filename="+filename+".xls");
		
		wb.write(response.getOutputStream());
		wb.close();
		
		
	}
}









