package com.kh.erp.production.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kh.erp.production.model.service.ProductionService;


@Controller
public class ProductionController {
	@Autowired
	ProductionService productionService;
	

}
