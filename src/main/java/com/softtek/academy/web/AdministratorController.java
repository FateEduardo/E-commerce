package com.softtek.academy.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softtek.academy.domain.Item;
import com.softtek.academy.domain.User;
import com.softtek.academy.domain.UserRole;
import com.softtek.academy.services.ItemService;
import com.softtek.academy.services.UserRoleService;
import com.softtek.academy.services.UserService;

@Controller
@RequestMapping(value="/admin")
public class AdministratorController {
	private static final Logger logger = LoggerFactory.getLogger(AdministratorController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	UserRoleService userRoleService;
	
	@RequestMapping(value="/listItemView", method = RequestMethod.GET)
	public String itemListView(){
		return "listItem";
	}
	@RequestMapping(value="/listUserView", method = RequestMethod.GET)
	public String userListView(){
		return "listUser";
	}
	@RequestMapping(value="/editUserView", method = RequestMethod.GET)
	public String userEditView(){
		return "editUser";
	}
	@RequestMapping(value="/editItemView", method = RequestMethod.GET)
	public String itemEditView(){
		return "editItem";
	}
	
	@RequestMapping(value="/listUser", method = RequestMethod.GET)
	public ResponseEntity<?>  listUser( ) {
		List<User> users = userService.findAll();
		if(users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	@RequestMapping(value="/listItem", method = RequestMethod.GET)
	public ResponseEntity<?>  listItem( ) {
		logger.info("llego");
		List<Item> items = itemService.findAll();
		if(items.isEmpty()){
			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
	
	@RequestMapping(value="/editItem", method = RequestMethod.POST)
	public ResponseEntity<?>  editItem(@RequestBody Long id ) {
		logger.info("llego");
		Item item = itemService.findOne(id);
		if(item==null){
			return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	@RequestMapping(value="/editUser", method = RequestMethod.POST)
	public ResponseEntity<?>  editUser(@RequestBody String username ) {
		
		User user = userService.findOne(username);
		List<UserRole> userRoleList = userRoleService.findAll();
		List<String> listStatus = userService.listStatus();
		Map<String,Object>map=new HashMap<String, Object>();
		map.put("users", user);
		map.put("userRole", userRoleList);
		map.put("listStatus", listStatus);
		if(userRoleList.isEmpty() && listStatus.isEmpty() && user!=null ){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
	}
	
	 @RequestMapping(value="/updateUserView" ,method=RequestMethod.POST)
	 public String updateUser(@RequestBody User user) {
		 if( userService.save(user)){
			 return "redirect:/admin/listUserView";
		 }
		 return "redirect:/admin/editUserView";

	 }
	 @RequestMapping(value="/updateItemrView" ,method=RequestMethod.POST)
	 public String updateItem(@RequestBody Item item) {
		 if( itemService.save(item)){
			 return "redirect:/admin/listItemView";
		 }
		 return "redirect:/admin/editItemView";

	 }
	@RequestMapping(value="/deleteItem", method = RequestMethod.POST)
	public String deleteItem(@RequestBody Long id ) {
		logger.info("llego");
		Item item=itemService.findOne(id);
		if(itemService.delete(item)){
			return "redirect:/admin/listItemView";
		}
		return "redirect:/admin/editItemView";
		
	}
}
