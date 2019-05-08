package com.meiguan.service;

import com.meiguan.dao.CommentDao;
import com.meiguan.pojo.Comment;
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
public class CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private IdWorker idWorker;

	public List<Comment> findAll() {

		return commentDao.findAll();
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Comment> findPage(int page, int size) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		return commentDao.findAll(pageRequest);
	}

	private Specification<Comment> where(Map searchMap) {
		
		return new Specification<Comment>() {
          
			@Override
			public Predicate toPredicate(Root<Comment> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();

                return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
                
            }
        };		
		
	}

	public Page<Comment> findSearch(Map whereMap, int page, int size) {
		Specification<Comment> specification = where(whereMap);
		PageRequest pageRequest = new PageRequest(page-1, size);
		return commentDao.findAll(specification, pageRequest);
	}

	public Comment findOne(String id) {
		return commentDao.findById(id).get();
	}

	public void add(Comment comment) {
		comment.setId(idWorker.nextId()+""); //主键值
		commentDao.save(comment);
	}
	
	public void update(Comment comment) {
		commentDao.save(comment);
	}

	public void delete(String id) {
		commentDao.deleteById(id);
	}

	public void deleteList(String[] ids) {
		for (String id : ids) {
			commentDao.deleteById(id);
		}
	}

}
