package com.kh.erp.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kh.erp.storage.service.StorageService;

@Controller
public class StorageController {
	
	@Autowired
	StorageService storageService;
}
