package com.meiguan.service;

import com.meiguan.dao.AdministratorDao;
import com.meiguan.pojo.Administrator;
import com.meiguan.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class AdministratorService {

	@Autowired
	private AdministratorDao administratorDao;
	
	@Autowired
	private IdWorker idWorker;

	public List<Administrator> findAll() {

		return administratorDao.findAll();
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Administrator> findPage(int page, int size) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		return administratorDao.findAll(pageRequest);
	}

	private Specification<Administrator> where(Map searchMap) {
		
		return new Specification<Administrator>() {
          
			@Override
			public Predicate toPredicate(Root<Administrator> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("pid")!=null && !"".equals(searchMap.get("pid"))) {
                	predicateList.add(cb.like(root.get("pid").as(String.class), "%"+ searchMap.get("pid") +"%"));
                }
                // 
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+ searchMap.get("name") +"%"));
                }
                // 
                if (searchMap.get("username")!=null && !"".equals(searchMap.get("username"))) {
                	predicateList.add(cb.like(root.get("username").as(String.class), "%"+ searchMap.get("username") +"%"));
                }
                // 
                if (searchMap.get("password")!=null && !"".equals(searchMap.get("password"))) {
                	predicateList.add(cb.like(root.get("password").as(String.class), "%"+ searchMap.get("password") +"%"));
                }
                // 
                if (searchMap.get("phone")!=null && !"".equals(searchMap.get("phone"))) {
                	predicateList.add(cb.like(root.get("phone").as(String.class), "%"+ searchMap.get("phone") +"%"));
                }
                // 
                if (searchMap.get("status")!=null && !"".equals(searchMap.get("status"))) {
                	predicateList.add(cb.like(root.get("status").as(String.class), "%"+ searchMap.get("status") +"%"));
                }
                // 地址
                if (searchMap.get("address")!=null && !"".equals(searchMap.get("address"))) {
                	predicateList.add(cb.like(root.get("address").as(String.class), "%"+ searchMap.get("address") +"%"));
                }

                return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
                
            }
        };		
		
	}

	public Page<Administrator> findSearch(Map whereMap, int page, int size) {
		Specification<Administrator> specification = where(whereMap);
		PageRequest pageRequest = new PageRequest(page-1, size);
		return administratorDao.findAll(specification, pageRequest);
	}

	public Administrator findOne(String id) {
		return administratorDao.findById(id).get();
	}

	public void add(Administrator administrator) {
        //主键值
        administrator.setId(idWorker.nextId()+"");
		administratorDao.save(administrator);
	}
	
	public void update(Administrator administrator) {
		administratorDao.save(administrator);
	}

	public void delete(String id) {
		administratorDao.deleteById(id);
	}

	public void deleteList(String[] ids) {
		for (String id : ids) {
			administratorDao.deleteById(id);
		}
	}

}
