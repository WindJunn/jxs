package com.meiguan.service;

import com.meiguan.dao.UserRoleDao;
import com.meiguan.pojo.UserRole;
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
 * @author User
 *
 */
@Service
public class UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private IdWorker idWorker;

	public List<UserRole> findAll() {

		return userRoleDao.findAll();
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<UserRole> findPage(int page, int size) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		return userRoleDao.findAll(pageRequest);
	}

	private Specification<UserRole> where(Map searchMap) {
		
		return new Specification<UserRole>() {
          
			@Override
			public Predicate toPredicate(Root<UserRole> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+ searchMap.get("id") +"%"));
                }
                // 
                if (searchMap.get("user_id")!=null && !"".equals(searchMap.get("user_id"))) {
                	predicateList.add(cb.like(root.get("user_id").as(String.class), "%"+ searchMap.get("user_id") +"%"));
                }
                // 
                if (searchMap.get("role_id")!=null && !"".equals(searchMap.get("role_id"))) {
                	predicateList.add(cb.like(root.get("role_id").as(String.class), "%"+ searchMap.get("role_id") +"%"));
                }

                return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
                
            }
        };		
		
	}

	public Page<UserRole> findSearch(Map whereMap, int page, int size) {
		Specification<UserRole> specification = where(whereMap);
		PageRequest pageRequest = new PageRequest(page-1, size);
		return userRoleDao.findAll(specification, pageRequest);
	}

	public UserRole findOne(String id) {
		return userRoleDao.findById(id).get();
	}

	public void add(UserRole userRole) {
		userRole.setId(idWorker.nextId()+""); //主键值
		userRoleDao.save(userRole);
	}
	
	public void update(UserRole userRole) {
		userRoleDao.save(userRole);
	}

	public void delete(String id) {
		userRoleDao.deleteById(id);
	}

	public void deleteList(String[] ids) {
		for (String id : ids) {
			userRoleDao.deleteById(id);
		}
	}

}
