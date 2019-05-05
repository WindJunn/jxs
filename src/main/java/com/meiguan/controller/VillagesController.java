package com.meiguan.controller;

import com.meiguan.pojo.Villages;
import com.meiguan.service.VillagesService;
import com.meiguan.utils.PageResult;
import com.meiguan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/villages")
public class VillagesController {

	@Autowired
	private VillagesService villagesService;
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value="/",method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,1000,"查询成功",villagesService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findOne(@PathVariable String id){
		return new Result(true,1000,"查询成功",villagesService.findOne(id));
	}
	
	/**
	 * 分页查询全部数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/{page}/{size}",method= RequestMethod.GET)
	public Result findPage(@PathVariable int page, @PathVariable int size){
		Page<Villages> pageList = villagesService.findPage(page, size);
		return new Result(true,1000,"查询成功",new PageResult<Villages>(pageList.getTotalElements(), pageList.getContent() ) );
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
		Page<Villages> pageList = villagesService.findSearch(searchMap, page, size);
		return  new Result(true,1000,"查询成功",  new PageResult<Villages>(pageList.getTotalElements(), pageList.getContent()) );		
	}
	
	/**
	 * 增加
	 * @param villages
	 */
	@RequestMapping(value="/",method= RequestMethod.POST)
	public Result add(@RequestBody Villages villages  ){
		villagesService.add(villages);			
		return new Result(true,1000,"增加成功");
	}
	
	/**
	 * 修改
	 * @param villages
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Villages villages, @PathVariable Long id ){
		villages.setId(id);
		villagesService.update(villages);		
		return new Result(true,1000,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		villagesService.delete(id);
		return new Result(true,1000,"删除成功");
	}
	
}
