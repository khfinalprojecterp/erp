package com.kh.erp.materials.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kh.erp.materials.model.service.MaterialsCategoryService;

@Controller
public class MaterialsCategoryController {

	@Autowired
	MaterialsCategoryService materialsCategoryService;
}
