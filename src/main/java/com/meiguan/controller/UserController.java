package com.meiguan.controller;

import com.meiguan.pojo.Users;
import com.meiguan.service.UserService;
import com.meiguan.utils.PageResult;
import com.meiguan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * 控制器层
 * @author Users
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value="/",method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,1000,"查询成功", userService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findOne(@PathVariable String id){
		return new Result(true,1000,"查询成功", userService.findOne(id));
	}
	
	/**
	 * 分页查询全部数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/{page}/{size}",method= RequestMethod.GET)
	public Result findPage(@PathVariable int page, @PathVariable int size){
		Page<Users> pageList = userService.findPage(page, size);
		return new Result(true,1000,"查询成功",new PageResult<Users>(pageList.getTotalElements(), pageList.getContent() ) );
	}
	
	/**
	 * 分页+多条件查询 
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/{page}/{size}",method= RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<Users> pageList = userService.findSearch(searchMap, page, size);
		return  new Result(true,1000,"查询成功",  new PageResult<Users>(pageList.getTotalElements(), pageList.getContent()) );
	}
	
	/**
	 * 增加
	 * @param users
	 */
	@RequestMapping(value="/",method= RequestMethod.POST)
	public Result add(@RequestBody Users users){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		users.setPassword(passwordEncoder.encode(users.getPassword()));

		userService.add(users);
		return new Result(true,1000,"增加成功");
	}

	@RequestMapping(value="/add",method= RequestMethod.GET)
	public Result add1(){
		Users users = new Users();
		users.setUsername("wuu");
		users.setCreateTime(new Date());
		users.setUpdateTime(new Date());

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		users.setPassword(passwordEncoder.encode("123"));

		userService.add(users);
		return new Result(true,1000,"增加成功");
	}
	
	/**
	 * 修改
	 * @param users
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Users users, @PathVariable String id ){
		users.setId(id);
		userService.update(users);
		return new Result(true,1000,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		userService.delete(id);
		return new Result(true,1000,"删除成功");
	}


	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public Users lonin(@PathVariable String username,@PathVariable String password) {
		Users user = userService.findByUserNameAndPassword(username, password);
		return  user;
	}
	
}
