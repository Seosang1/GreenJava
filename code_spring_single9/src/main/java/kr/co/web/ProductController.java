package kr.co.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.web.model.Product.productBiz;

@Controller
public class ProductController {
	
	@Autowired
	private productBiz biz;

	@RequestMapping(value = "/productList.do")
	public String product(Model model) {
		
	model.addAttribute("list",biz.selectList());
		return "jsp/member/productList";
	}
	
	@RequestMapping(value = "/productDetail",method = RequestMethod.GET)
	public String productDetail(Model model,int seq) {
	
	model.addAttribute("dto",biz.productDetail(seq));
	return "/productDetail";
	 
}
	@RequestMapping(value="/productReg.do",method = RequestMethod.GET)
	public String insertForm(Model model) {
		
		return "jsp/main/product_reg";
	}


	
}
