package com.meiguan.service;

import com.meiguan.dao.UserDao;
import com.meiguan.pojo.User;
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
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private IdWorker idWorker;

	public List<User> findAll() {

		return userDao.findAll();
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<User> findPage(int page, int size) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		return userDao.findAll(pageRequest);
	}

	private Specification<User> where(Map searchMap) {
		
		return new Specification<User>() {
          
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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

	public Page<User> findSearch(Map whereMap, int page, int size) {
		Specification<User> specification = where(whereMap);
		PageRequest pageRequest = new PageRequest(page-1, size);
		return userDao.findAll(specification, pageRequest);
	}

	public User findOne(String id) {
		return userDao.findById(id).get();
	}
	public User findOne1(String username) {
		return userDao.findByName(username);
	}
	public void add(User user) {
        //主键值
        user.setId(idWorker.nextId()+"");
		userDao.save(user);
	}
	
	public void update(User user) {
		userDao.save(user);
	}

	public void delete(String id) {
		userDao.deleteById(id);
	}

	public void deleteList(String[] ids) {
		for (String id : ids) {
			userDao.deleteById(id);
		}
	}



}
