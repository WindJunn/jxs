package com.meiguan.service;

import com.meiguan.dao.RoleDao;
import com.meiguan.pojo.Role;
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
public class RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private IdWorker idWorker;

	public List<Role> findAll() {

		return roleDao.findAll();
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Role> findPage(int page, int size) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		return roleDao.findAll(pageRequest);
	}

	private Specification<Role> where(Map searchMap) {
		
		return new Specification<Role>() {
          
			@Override
			public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 主键ID
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+ searchMap.get("id") +"%"));
                }
                // 角色名称
                if (searchMap.get("role_name")!=null && !"".equals(searchMap.get("role_name"))) {
                	predicateList.add(cb.like(root.get("role_name").as(String.class), "%"+ searchMap.get("role_name") +"%"));
                }
                // 角色编号
                if (searchMap.get("role_code")!=null && !"".equals(searchMap.get("role_code"))) {
                	predicateList.add(cb.like(root.get("role_code").as(String.class), "%"+ searchMap.get("role_code") +"%"));
                }
                // 角色描述
                if (searchMap.get("role_desc")!=null && !"".equals(searchMap.get("role_desc"))) {
                	predicateList.add(cb.like(root.get("role_desc").as(String.class), "%"+ searchMap.get("role_desc") +"%"));
                }
                // 是否默认
                if (searchMap.get("is_default")!=null && !"".equals(searchMap.get("is_default"))) {
                	predicateList.add(cb.like(root.get("is_default").as(String.class), "%"+ searchMap.get("is_default") +"%"));
                }
                // 创建人
                if (searchMap.get("creator")!=null && !"".equals(searchMap.get("creator"))) {
                	predicateList.add(cb.like(root.get("creator").as(String.class), "%"+ searchMap.get("creator") +"%"));
                }
                // 创建时间
                if (searchMap.get("create_date")!=null && !"".equals(searchMap.get("create_date"))) {
                	predicateList.add(cb.like(root.get("create_date").as(String.class), "%"+ searchMap.get("create_date") +"%"));
                }
                // 修改人
                if (searchMap.get("modifier")!=null && !"".equals(searchMap.get("modifier"))) {
                	predicateList.add(cb.like(root.get("modifier").as(String.class), "%"+ searchMap.get("modifier") +"%"));
                }
                // 修改时间
                if (searchMap.get("modify_date")!=null && !"".equals(searchMap.get("modify_date"))) {
                	predicateList.add(cb.like(root.get("modify_date").as(String.class), "%"+ searchMap.get("modify_date") +"%"));
                }
                // 删除标记
                if (searchMap.get("del_flag")!=null && !"".equals(searchMap.get("del_flag"))) {
                	predicateList.add(cb.like(root.get("del_flag").as(String.class), "%"+ searchMap.get("del_flag") +"%"));
                }
                // 系统编号
                if (searchMap.get("application_code")!=null && !"".equals(searchMap.get("application_code"))) {
                	predicateList.add(cb.like(root.get("application_code").as(String.class), "%"+ searchMap.get("application_code") +"%"));
                }
                // 状态 0-启用，1-禁用
                if (searchMap.get("status")!=null && !"".equals(searchMap.get("status"))) {
                	predicateList.add(cb.like(root.get("status").as(String.class), "%"+ searchMap.get("status") +"%"));
                }

                return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
                
            }
        };		
		
	}

	public Page<Role> findSearch(Map whereMap, int page, int size) {
		Specification<Role> specification = where(whereMap);
		PageRequest pageRequest = new PageRequest(page-1, size);
		return roleDao.findAll(specification, pageRequest);
	}

	public Role findOne(String id) {
		return roleDao.findOne(id);
	}

	public void add(Role role) {
		role.setId(idWorker.nextId()+""); //主键值
		roleDao.save(role);
	}
	
	public void update(Role role) {
		roleDao.save(role);
	}

	public void delete(String id) {
		roleDao.delete(id);
	}

	public void deleteList(String[] ids) {
		for (String id : ids) {
			roleDao.delete(id);
		}
	}

}
