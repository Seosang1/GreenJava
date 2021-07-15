package kr.co.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
