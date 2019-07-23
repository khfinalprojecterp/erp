package com.kh.erp.m_storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kh.erp.m_storage.model.service.M_storageService;
@Controller
public class M_storageController {
@Autowired
M_storageService m_storageService; 
}
