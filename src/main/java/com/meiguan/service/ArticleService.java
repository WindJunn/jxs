package com.meiguan.service;

import com.meiguan.dao.ArticleDao;
import com.meiguan.pojo.Article;
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
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Autowired
	private IdWorker idWorker;

	public List<Article> findAll() {

		return articleDao.findAll();
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Article> findPage(int page, int size) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		return articleDao.findAll(pageRequest);
	}

	private Specification<Article> where(Map searchMap) {
		
		return new Specification<Article>() {
          
			@Override
			public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("title")!=null && !"".equals(searchMap.get("title"))) {
                	predicateList.add(cb.like(root.get("title").as(String.class), "%"+ searchMap.get("title") +"%"));
                }
                // 作者
                if (searchMap.get("author")!=null && !"".equals(searchMap.get("author"))) {
                	predicateList.add(cb.like(root.get("author").as(String.class), "%"+ searchMap.get("author") +"%"));
                }
                // 文章类型  政策，文化，教育，农技，其他
                if (searchMap.get("article_type")!=null && !"".equals(searchMap.get("article_type"))) {
                	predicateList.add(cb.like(root.get("article_type").as(String.class), "%"+ searchMap.get("article_type") +"%"));
                }
                // 文章状态 审核通过，审核未通过，提交未审核
                if (searchMap.get("state")!=null && !"".equals(searchMap.get("state"))) {
                	predicateList.add(cb.like(root.get("state").as(String.class), "%"+ searchMap.get("state") +"%"));
                }

                return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
                
            }
        };		
		
	}

	public Page<Article> findSearch(Map whereMap, int page, int size) {
		Specification<Article> specification = where(whereMap);
		PageRequest pageRequest = new PageRequest(page-1, size);
		return articleDao.findAll(specification, pageRequest);
	}

	public Article findOne(String id) {
		return articleDao.findById(id).get();
	}

	public void add(Article article) {
//		article.setId(idWorker.nextId()+""); //主键值
		articleDao.save(article);
	}
	
	public void update(Article article) {
		articleDao.save(article);
	}

	public void delete(String id) {
		articleDao.deleteById(id);
	}

	public void deleteList(String[] ids) {
		for (String id : ids) {
			articleDao.deleteById(id);
		}
	}

}
