package com.meiguan.service;

import com.meiguan.dao.UserDao;
import com.meiguan.pojo.User;
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
                // 用户名
                if (searchMap.get("username")!=null && !"".equals(searchMap.get("username"))) {
                	predicateList.add(cb.like(root.get("username").as(String.class), "%"+ searchMap.get("username") +"%"));
                }
                // 真实姓名
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+ searchMap.get("name") +"%"));
                }
                // 密码，加密存储
                if (searchMap.get("password")!=null && !"".equals(searchMap.get("password"))) {
                	predicateList.add(cb.like(root.get("password").as(String.class), "%"+ searchMap.get("password") +"%"));
                }
                // 身份证号
                if (searchMap.get("pid")!=null && !"".equals(searchMap.get("pid"))) {
                	predicateList.add(cb.like(root.get("pid").as(String.class), "%"+ searchMap.get("pid") +"%"));
                }
                // 注册手机号
                if (searchMap.get("phone")!=null && !"".equals(searchMap.get("phone"))) {
                	predicateList.add(cb.like(root.get("phone").as(String.class), "%"+ searchMap.get("phone") +"%"));
                }
                // 健康状态（0死亡 1健康 2一般 3病重 4残疾）
                if (searchMap.get("health")!=null && !"".equals(searchMap.get("health"))) {
                	predicateList.add(cb.like(root.get("health").as(String.class), "%"+ searchMap.get("health") +"%"));
                }
                // 昵称
                if (searchMap.get("nick_name")!=null && !"".equals(searchMap.get("nick_name"))) {
                	predicateList.add(cb.like(root.get("nick_name").as(String.class), "%"+ searchMap.get("nick_name") +"%"));
                }
                // 使用状态（Y正常 N非正常）
                if (searchMap.get("status")!=null && !"".equals(searchMap.get("status"))) {
                	predicateList.add(cb.like(root.get("status").as(String.class), "%"+ searchMap.get("status") +"%"));
                }
                // 头像地址
                if (searchMap.get("head_pic")!=null && !"".equals(searchMap.get("head_pic"))) {
                	predicateList.add(cb.like(root.get("head_pic").as(String.class), "%"+ searchMap.get("head_pic") +"%"));
                }
                // 手机是否验证 （0否  1是）
                if (searchMap.get("is_mobile_check")!=null && !"".equals(searchMap.get("is_mobile_check"))) {
                	predicateList.add(cb.like(root.get("is_mobile_check").as(String.class), "%"+ searchMap.get("is_mobile_check") +"%"));
                }
                // 性别，1男，2女
                if (searchMap.get("sex")!=null && !"".equals(searchMap.get("sex"))) {
                	predicateList.add(cb.like(root.get("sex").as(String.class), "%"+ searchMap.get("sex") +"%"));
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
		return userDao.findOne(id);
	}

	public void add(User user) {
		user.setId(idWorker.nextId()+""); //主键值
		userDao.save(user);
	}
	
	public void update(User user) {
		userDao.save(user);
	}

	public void delete(String id) {
		userDao.delete(id);
	}

	public void deleteList(String[] ids) {
		for (String id : ids) {
			userDao.delete(id);
		}
	}

}
