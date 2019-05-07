package com.meiguan.controller;

import com.meiguan.pojo.Role;
import com.meiguan.service.RoleService;
import com.meiguan.utils.PageResult;
import com.meiguan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 控制器层
 * @author User
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value="/",method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,1000,"查询成功",roleService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findOne(@PathVariable String id){
		return new Result(true,1000,"查询成功",roleService.findOne(id));
	}
	
	/**
	 * 分页查询全部数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/{page}/{size}",method= RequestMethod.GET)
	public Result findPage(@PathVariable int page, @PathVariable int size){
		Page<Role> pageList = roleService.findPage(page, size);
		return new Result(true,1000,"查询成功",new PageResult<Role>(pageList.getTotalElements(), pageList.getContent() ) );
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
		Page<Role> pageList = roleService.findSearch(searchMap, page, size);
		return  new Result(true,1000,"查询成功",  new PageResult<Role>(pageList.getTotalElements(), pageList.getContent()) );		
	}
	
	/**
	 * 增加
	 * @param role
	 */
	@RequestMapping(value="/",method= RequestMethod.POST)
	public Result add(@RequestBody Role role  ){
		roleService.add(role);			
		return new Result(true,1000,"增加成功");
	}
	
	/**
	 * 修改
	 * @param role
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Role role, @PathVariable String id ){
		role.setId(id);
		roleService.update(role);		
		return new Result(true,1000,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		roleService.delete(id);
		return new Result(true,1000,"删除成功");
	}
	
}
