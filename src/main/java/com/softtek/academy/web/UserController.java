package com.softtek.academy.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softtek.academy.domain.CartEntity;
import com.softtek.academy.domain.ItemEntity;
import com.softtek.academy.domain.ItemOrderEntity;
import com.softtek.academy.domain.UserEntity;
import com.softtek.academy.services.CartService;
import com.softtek.academy.services.CategoryItemService;
import com.softtek.academy.services.CategoryService;
import com.softtek.academy.services.ItemOrderService;
import com.softtek.academy.services.ItemService;
import com.softtek.academy.services.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	ItemService itemService;
	
	@Autowired 
	CategoryService categoryService;
	
	@Autowired
	CategoryItemService categoryItemService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	ItemOrderService itemOrderService;
	
	@RequestMapping(value="/listItemView", method = RequestMethod.GET)
	public String itemListView(){
		return "listItemUser";
	}
	@RequestMapping(value="/shoesView", method = RequestMethod.GET)
	public String shoesView(){
		return "shoesView";
	}
	@RequestMapping(value="/sweaterView", method = RequestMethod.GET)
	public String sweaterView(){
		return "sweaterView";
	}
	@RequestMapping(value="/cartView", method = RequestMethod.GET)
	public String cartView(){
		return "cartView";
	}
	@RequestMapping(value="/listItem", method = RequestMethod.GET)
	public ResponseEntity<?>  listItem( ) {
		List<ItemEntity> items = itemService.findAll();
		System.out.println(items);
		if(items==null){
			return new ResponseEntity<List<ItemEntity>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<ItemEntity>>(items, HttpStatus.OK);
	}
	@RequestMapping(value="/sweater", method = RequestMethod.GET)
	public ResponseEntity<?>  sweater( ) {
		List<ItemEntity>  items=itemService.findItemByCategory("SWEATER");
		if(items==null){
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<ItemEntity>>(items, HttpStatus.OK);
	}
	@RequestMapping(value="/shoes", method = RequestMethod.GET)
	public ResponseEntity<?>  shoes( ) {
		List<ItemEntity>  items=itemService.findItemByCategory("SHOES");
	
		if(items==null){
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<ItemEntity>>(items, HttpStatus.OK);
	}
	@RequestMapping(value="/listCart", method = RequestMethod.GET)
	public ResponseEntity<?>  listCart( ) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CartEntity cart=cartService.findCartByUser(auth.getName());
		List<ItemOrderEntity>orders=itemOrderService.findItemOrderByUser(auth.getName());
		final Map<String,Object>map=new HashMap<String, Object>();
		map.put("cart", cart);
		map.put("orders", orders);
		if(orders==null){
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	@RequestMapping(value="/addOrder", method = RequestMethod.POST)
	public ResponseEntity<?>  orderAdd(@RequestBody ItemOrderEntity itemOrder) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		final  UserEntity  user=userService.findOne(auth.getName());
		final CartEntity cart=cartService.findCartByUser(user.getName());
		System.out.println(cart);
		final ItemOrderEntity itemOrderExist=itemOrderService.findOneItemOrderByItem(itemOrder.getItem().getId());
		if(itemOrderExist!=null){
			itemOrderExist.setQuantity(itemOrderExist.getQuantity()+itemOrder.getQuantity());
			cart.setCartAmount(cart.getCartAmount()+(itemOrder.getItem().getPrice()*itemOrderExist.getQuantity()));
		}else{
			cart.setCartAmount(cart.getCartAmount()+(itemOrder.getItem().getPrice()*itemOrder.getQuantity()));
		}
		cart.setShippingAmount(0.0);
		cart.setStaus(true);
		itemOrder.setCart(cart);
		Long countOrder=itemOrderService.count();
		System.out.println(countOrder);
		if(countOrder==null){
			return new ResponseEntity<Long>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Long>(countOrder, HttpStatus.OK);
	}
	

}
