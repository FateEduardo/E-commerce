package com.softtek.academy.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softtek.academy.domain.Category;
import com.softtek.academy.domain.Item;
import com.softtek.academy.services.CategoryService;
import com.softtek.academy.services.ItemService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	ItemService itemService;
	
	@Autowired 
	CategoryService categoryService;
	
	@RequestMapping(value="/listItemView", method = RequestMethod.GET)
	public String itemListView(){
		return "listItemUser";
	}
	@RequestMapping(value="/listItem", method = RequestMethod.GET)
	public ResponseEntity<?>  listItem( ) {
		List<Item> items = itemService.findAll();
		List<Category>category=categoryService.findAll();
		Map<String,Object>map=new HashMap<String, Object>();
		
		map.put("items", items);
		map.put("categories", category);
		if(items==null){
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}

}
