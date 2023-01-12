package kr.or.ddit.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class CalculatorController {
	@RequestMapping(method=RequestMethod.GET, value ="/caluate")
	public String calForm(HttpServletRequest req) {
		return "cal/form";
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/caluate")
	public String calProcessCase4(
		@RequestParam int left, 
		@RequestParam int right, 
		HttpSession session,
		Model model
	) throws StreamWriteException, DatabindException, IOException {
		int result = left + right;
		model.addAttribute("result",result);
		return "jsonView";
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/caluate")
//	@ResponseBody
	public Map<String, Object> calProcessCase3(
		@RequestParam int left, 
		@RequestParam int right, 
		HttpSession session
	) throws StreamWriteException, DatabindException, IOException {
		int result = left + right;
		Map<String, Object> target = Collections.singletonMap("result", result);
		return target;
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/caluate")
	public void calProcessCase2(
		@RequestParam int left, 
		@RequestParam int right, 
		HttpSession session,
		OutputStream os //아웃풋스트림을 어뎁터에서 바로 받아냄
	) throws StreamWriteException, DatabindException, IOException {
		int result = left + right;
		Map<String, Object> target = Collections.singletonMap("result", result);
//		1. marshalling
//		2. serialization
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, target);
		
//		session.setAttribute("result", result);
//		return "redirect:/caluate";
	}
	
//  스프링 통해서 마샬링하는 대표적인 케이스 1번
//	@RequestMapping(method=RequestMethod.POST, value="/caluate")
	public void calProcessCase1(
		@RequestParam int left, 
		@RequestParam int right, 
		HttpSession session,
		HttpServletResponse resp
			
	) throws StreamWriteException, DatabindException, IOException {
		int result = left + right;
		Map<String, Object> target = Collections.singletonMap("result", result);
//		1. marshalling
//		2. serialization
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), target);
		
//		session.setAttribute("result", result);
//		return "redirect:/caluate";
	}
}
