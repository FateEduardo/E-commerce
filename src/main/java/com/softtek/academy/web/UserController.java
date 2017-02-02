package com.softtek.academy.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softtek.academy.domain.Item;
import com.softtek.academy.services.CategoryItemService;
import com.softtek.academy.services.CategoryService;
import com.softtek.academy.services.ItemService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	ItemService itemService;
	
	@Autowired 
	CategoryService categoryService;
	
	@Autowired
	CategoryItemService categoryItemService;
	
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
	@RequestMapping(value="/listItem", method = RequestMethod.GET)
	public ResponseEntity<?>  listItem( ) {
		List<Item> items = itemService.findAll();
		if(items==null){
			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
	@RequestMapping(value="/sweater", method = RequestMethod.GET)
	public ResponseEntity<?>  sweater( ) {
		List<Item>  items=itemService.findItemByCategory("SWEATER");
		if(items==null){
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
	@RequestMapping(value="/shoes", method = RequestMethod.GET)
	public ResponseEntity<?>  shoes( ) {
		List<Item>  items=itemService.findItemByCategory("SHOES");
		if(items==null){
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}

}
