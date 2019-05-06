package com.meiguan.controller;

import com.meiguan.pojo.Vedio;
import com.meiguan.service.VedioService;
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
@RequestMapping("/vedio")
public class VedioController {

	@Autowired
	private VedioService vedioService;
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value="/",method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,1000,"查询成功",vedioService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findOne(@PathVariable String id){
		return new Result(true,1000,"查询成功",vedioService.findOne(id));
	}
	
	/**
	 * 分页查询全部数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/{page}/{size}",method= RequestMethod.GET)
	public Result findPage(@PathVariable int page, @PathVariable int size){
		Page<Vedio> pageList = vedioService.findPage(page, size);
		return new Result(true,1000,"查询成功",new PageResult<Vedio>(pageList.getTotalElements(), pageList.getContent() ) );
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
		Page<Vedio> pageList = vedioService.findSearch(searchMap, page, size);
		return  new Result(true,1000,"查询成功",  new PageResult<Vedio>(pageList.getTotalElements(), pageList.getContent()) );		
	}
	
	/**
	 * 增加
	 * @param vedio
	 */
	@RequestMapping(value="/",method= RequestMethod.POST)
	public Result add(@RequestBody Vedio vedio  ){
		vedioService.add(vedio);			
		return new Result(true,1000,"增加成功");
	}
	
	/**
	 * 修改
	 * @param vedio
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Vedio vedio, @PathVariable String id ){
		vedio.setId(id);
		vedioService.update(vedio);		
		return new Result(true,1000,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		vedioService.delete(id);
		return new Result(true,1000,"删除成功");
	}
	
}
