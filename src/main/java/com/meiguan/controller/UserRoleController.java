package com.meiguan.controller;

import com.meiguan.pojo.UserRole;
import com.meiguan.service.UserRoleService;
import com.meiguan.utils.PageResult;
import com.meiguan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 控制器层
 * @author Users
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/userRole")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value="/",method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,1000,"查询成功",userRoleService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findOne(@PathVariable String id){
		return new Result(true,1000,"查询成功",userRoleService.findOne(id));
	}
	
	/**
	 * 分页查询全部数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/{page}/{size}",method= RequestMethod.GET)
	public Result findPage(@PathVariable int page, @PathVariable int size){
		Page<UserRole> pageList = userRoleService.findPage(page, size);
		return new Result(true,1000,"查询成功",new PageResult<UserRole>(pageList.getTotalElements(), pageList.getContent() ) );
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
		Page<UserRole> pageList = userRoleService.findSearch(searchMap, page, size);
		return  new Result(true,1000,"查询成功",  new PageResult<UserRole>(pageList.getTotalElements(), pageList.getContent()) );		
	}
	
	/**
	 * 增加
	 * @param userRole
	 */
	@RequestMapping(value="/",method= RequestMethod.POST)
	public Result add(@RequestBody UserRole userRole  ){
		userRoleService.add(userRole);			
		return new Result(true,1000,"增加成功");
	}
	
	/**
	 * 修改
	 * @param userRole
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody UserRole userRole, @PathVariable String id ){
		userRole.setId(id);
		userRoleService.update(userRole);		
		return new Result(true,1000,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		userRoleService.delete(id);
		return new Result(true,1000,"删除成功");
	}
	
}
