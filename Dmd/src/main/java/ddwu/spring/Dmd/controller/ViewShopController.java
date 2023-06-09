package ddwu.spring.Dmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ddwu.spring.Dmd.domain.Category;
import ddwu.spring.Dmd.domain.Product;
import ddwu.spring.Dmd.service.ProductFacade;

@Controller
@RequestMapping("/shop/shopMain")
public class ViewShopController {
	
	private ProductFacade productFacade;
	
	@Autowired
	public void setProductFacade(ProductFacade productFacade) {
		this.productFacade = productFacade;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String handleRequest(ModelMap model) throws Exception {
		System.out.println("shop main controller start");
		PagedListHolder<Product> prodList = new PagedListHolder<Product>(this.productFacade.findAll());
		prodList.setPageSize(16);
		
		model.put("productList", prodList);
		return "/shop/shopMain";
	}
	
	
	
	
	
//	@RequestMapping()
//	public ModelAndView viewShop() {
//		return new ModelAndView("shoMain", "productList", productFacade.findAll());
//	}

	
}
