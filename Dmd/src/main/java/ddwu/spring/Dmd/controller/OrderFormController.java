package ddwu.spring.Dmd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import ddwu.spring.Dmd.domain.Cart;
import ddwu.spring.Dmd.domain.Product;
import ddwu.spring.Dmd.domain.Profile;
import ddwu.spring.Dmd.service.OrderFacade;
import ddwu.spring.Dmd.service.OrderFormValidator;
import ddwu.spring.Dmd.service.ProductFacade;
import ddwu.spring.Dmd.service.ProfileFacade;
import ddwu.spring.Dmd.service.SecondHandFacade;

@Controller
@RequestMapping("/shop/order")
@SessionAttributes("userSession")
//@SessionAttributes({"sessionCart", "orderForm"})
public class OrderFormController {
	
	private ProductFacade pFacade;
	private OrderFacade orderFacade;
	
	@Autowired
	public void setPFacade(ProductFacade pFacade) {
		this.pFacade = pFacade;
	}

	@Autowired
	public void setOrderFacade(OrderFacade orderFacade) {
		this.orderFacade = orderFacade;
	}
	
	@ModelAttribute("orderForm")
	public OrderForm createOrderForm(HttpServletRequest request) {
		return new OrderForm();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("prodId") int id,
			ModelMap model) throws Exception {
		System.out.println(id);
		Product product = pFacade.getProduct(id);
		model.put("product", product);

		return "/order/AddOrder";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String form(
			@ModelAttribute("orderForm") OrderForm orderForm,
			@ModelAttribute("userSession") UserSession userSession,
			ModelMap model) throws Exception {
		
		
		Product product = pFacade.getProduct(orderForm.getOrder().getProdID());
		
		orderForm.getOrder().setUserID(userSession.getProfile().getId());
		orderForm.getOrder().setTotalPrice(product.getPrice());
		orderForm.getOrder().setSelectItemNum(1);
		System.out.println(orderForm.getOrder().toString());
		orderFacade.addOrder(orderForm.getOrder());
		
		model.put("order", orderForm.getOrder());

		return "/order/CompleteOrder";
	}
	
	@ModelAttribute("creditCardTypes")
	public List<String> referenceData() {
		ArrayList<String> creditCardTypes = new ArrayList<String>();
		
		creditCardTypes.add("Visa");
		creditCardTypes.add("MasterCard");
		creditCardTypes.add("American Express");
		return creditCardTypes;			
}
	
	@RequestMapping("/shop/addOrder")
	public String initNewOrder(HttpServletRequest request,
			@ModelAttribute("sessionCart") Cart cart,
			@ModelAttribute("orderForm") OrderForm orderForm
			) throws ModelAndViewDefiningException {
//		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
//		if (cart != null) {
//			// Re-read account from DB at team's request.
//			Account account = usStore.getAccountByUserId(userSession.getAccount().getUserId());
			
//			orderForm.getOrder().initOrder(account, cart, "OK");
			return "order/OrderForm";	
//		}
//		else {
//			ModelAndView modelAndView = new ModelAndView("Error");
//			modelAndView.addObject("message", "An order could not be created because a cart could not be found.");
//			throw new ModelAndViewDefiningException(modelAndView);
//		}
	}
	
}