package com.meiguan.controller;

import com.meiguan.pojo.Towns;
import com.meiguan.service.TownsService;
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
@RequestMapping("/towns")
public class TownsController {

	@Autowired
	private TownsService townsService;
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value="/",method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,1000,"查询成功",townsService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findOne(@PathVariable String id){
		return new Result(true,1000,"查询成功",townsService.findOne(id));
	}
	
	/**
	 * 分页查询全部数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/{page}/{size}",method= RequestMethod.GET)
	public Result findPage(@PathVariable int page, @PathVariable int size){
		Page<Towns> pageList = townsService.findPage(page, size);
		return new Result(true,1000,"查询成功",new PageResult<Towns>(pageList.getTotalElements(), pageList.getContent() ) );
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
		Page<Towns> pageList = townsService.findSearch(searchMap, page, size);
		return  new Result(true,1000,"查询成功",  new PageResult<Towns>(pageList.getTotalElements(), pageList.getContent()) );		
	}
	
	/**
	 * 增加
	 * @param towns
	 */
	@RequestMapping(value="/",method= RequestMethod.POST)
	public Result add(@RequestBody Towns towns  ){
		townsService.add(towns);			
		return new Result(true,1000,"增加成功");
	}
	
	/**
	 * 修改
	 * @param towns
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Towns towns, @PathVariable String id ){
		towns.setId(id);
		townsService.update(towns);		
		return new Result(true,1000,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		townsService.delete(id);
		return new Result(true,1000,"删除成功");
	}
	
}
