package com.kh.erp.materials.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kh.erp.materials.model.dao.MaterialsDao;

@Controller
public class MaterialsController {

	@Autowired
	MaterialsDao materialsDao;
}
