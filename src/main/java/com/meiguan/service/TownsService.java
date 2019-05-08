package com.meiguan.service;

import com.meiguan.dao.TownsDao;
import com.meiguan.pojo.Towns;
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
 * @author Users
 *
 */
@Service
public class TownsService {

	@Autowired
	private TownsDao townsDao;
	
	@Autowired
	private IdWorker idWorker;

	public List<Towns> findAll() {

		return townsDao.findAll();
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Towns> findPage(int page, int size) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		return townsDao.findAll(pageRequest);
	}

	private Specification<Towns> where(Map searchMap) {
		
		return new Specification<Towns>() {
          
			@Override
			public Predicate toPredicate(Root<Towns> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+ searchMap.get("name") +"%"));
                }
                // 
                if (searchMap.get("county")!=null && !"".equals(searchMap.get("county"))) {
                	predicateList.add(cb.like(root.get("county").as(String.class), "%"+ searchMap.get("county") +"%"));
                }

                return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
                
            }
        };		
		
	}

	public Page<Towns> findSearch(Map whereMap, int page, int size) {
		Specification<Towns> specification = where(whereMap);
		PageRequest pageRequest = new PageRequest(page-1, size);
		return townsDao.findAll(specification, pageRequest);
	}

	public Towns findOne(String id) {
		return townsDao.findById(id).get();
	}

	public void add(Towns towns) {
		towns.setId(idWorker.nextId()+""); //主键值
		townsDao.save(towns);
	}
	
	public void update(Towns towns) {
		townsDao.save(towns);
	}

	public void delete(String id) {
		townsDao.deleteById(id);
	}

	public void deleteList(String[] ids) {
		for (String id : ids) {
			townsDao.deleteById(id);
		}
	}

}
