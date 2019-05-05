package com.meiguan.service;

import com.meiguan.dao.VedioDao;
import com.meiguan.pojo.Vedio;
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
public class VedioService {

	@Autowired
	private VedioDao vedioDao;
	
	@Autowired
	private IdWorker idWorker;

	public List<Vedio> findAll() {

		return vedioDao.findAll();
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Vedio> findPage(int page, int size) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		return vedioDao.findAll(pageRequest);
	}

	private Specification<Vedio> where(Map searchMap) {
		
		return new Specification<Vedio>() {
          
			@Override
			public Predicate toPredicate(Root<Vedio> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("title")!=null && !"".equals(searchMap.get("title"))) {
                	predicateList.add(cb.like(root.get("title").as(String.class), "%"+ searchMap.get("title") +"%"));
                }
                // 作者
                if (searchMap.get("author")!=null && !"".equals(searchMap.get("author"))) {
                	predicateList.add(cb.like(root.get("author").as(String.class), "%"+ searchMap.get("author") +"%"));
                }
                // 视频地址
                if (searchMap.get("video_url")!=null && !"".equals(searchMap.get("video_url"))) {
                	predicateList.add(cb.like(root.get("video_url").as(String.class), "%"+ searchMap.get("video_url") +"%"));
                }
                // 视频类型  政策，文化，教育，农技，其他
                if (searchMap.get("type")!=null && !"".equals(searchMap.get("type"))) {
                	predicateList.add(cb.like(root.get("type").as(String.class), "%"+ searchMap.get("type") +"%"));
                }
                // 视频状态 审核通过，审核未通过，提交未审核
                if (searchMap.get("state")!=null && !"".equals(searchMap.get("state"))) {
                	predicateList.add(cb.like(root.get("state").as(String.class), "%"+ searchMap.get("state") +"%"));
                }

                return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
                
            }
        };		
		
	}

	public Page<Vedio> findSearch(Map whereMap, int page, int size) {
		Specification<Vedio> specification = where(whereMap);
		PageRequest pageRequest = new PageRequest(page-1, size);
		return vedioDao.findAll(specification, pageRequest);
	}

	public Vedio findOne(Integer id) {
		return vedioDao.findOne(id);
	}

	public void add(Vedio vedio) {
		vedio.setId(idWorker.nextId()); //主键值
		vedioDao.save(vedio);
	}
	
	public void update(Vedio vedio) {
		vedioDao.save(vedio);
	}

	public void delete(String id) {
		vedioDao.delete(id);
	}

	public void deleteList(String[] ids) {
		for (String id : ids) {
			vedioDao.delete(id);
		}
	}

}
