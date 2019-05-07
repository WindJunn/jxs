package com.meiguan.service;

import com.meiguan.dao.VillagesDao;
import com.meiguan.pojo.Villages;
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
public class VillagesService {

	@Autowired
	private VillagesDao villagesDao;
	
	@Autowired
	private IdWorker idWorker;

	public List<Villages> findAll() {

		return villagesDao.findAll();
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Villages> findPage(int page, int size) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		return villagesDao.findAll(pageRequest);
	}

	private Specification<Villages> where(Map searchMap) {
		
		return new Specification<Villages>() {
          
			@Override
			public Predicate toPredicate(Root<Villages> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+ searchMap.get("name") +"%"));
                }

                return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
                
            }
        };		
		
	}

	public Page<Villages> findSearch(Map whereMap, int page, int size) {
		Specification<Villages> specification = where(whereMap);
		PageRequest pageRequest = new PageRequest(page-1, size);
		return villagesDao.findAll(specification, pageRequest);
	}

	public Villages findOne(String id) {
		return villagesDao.findById(id).get();
	}

	public void add(Villages villages) {
		villages.setId(idWorker.nextId()+"");
		villagesDao.save(villages);
	}
	
	public void update(Villages villages) {
		villagesDao.save(villages);
	}

	public void delete(String id) {
		villagesDao.deleteById(id);
	}

	public void deleteList(String[] ids) {
		for (String id : ids) {
			villagesDao.deleteById(id);
		}
	}

}
