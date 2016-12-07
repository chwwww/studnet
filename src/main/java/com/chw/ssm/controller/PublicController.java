package com.chw.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicController {

	@RequestMapping("/jumpAindex")
	public String aindex(){
		return "main/aindex";
	}
	
}
