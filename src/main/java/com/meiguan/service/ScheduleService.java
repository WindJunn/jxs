package com.meiguan.service;

import com.meiguan.dao.ScheduleDao;
import com.meiguan.pojo.Schedule;
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
public class ScheduleService {

	@Autowired
	private ScheduleDao scheduleDao;
	
	@Autowired
	private IdWorker idWorker;

	public List<Schedule> findAll() {

		return scheduleDao.findAll();
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Schedule> findPage(int page, int size) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		return scheduleDao.findAll(pageRequest);
	}

	private Specification<Schedule> where(Map searchMap) {
		
		return new Specification<Schedule>() {
          
			@Override
			public Predicate toPredicate(Root<Schedule> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 教员姓名
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+ searchMap.get("name") +"%"));
                }
                // 授课地点
                if (searchMap.get("teaching_site")!=null && !"".equals(searchMap.get("teaching_site"))) {
                	predicateList.add(cb.like(root.get("teaching_site").as(String.class), "%"+ searchMap.get("teaching_site") +"%"));
                }
                // 授课主题
                if (searchMap.get("teaching_theme")!=null && !"".equals(searchMap.get("teaching_theme"))) {
                	predicateList.add(cb.like(root.get("teaching_theme").as(String.class), "%"+ searchMap.get("teaching_theme") +"%"));
                }
                // 授课状态 1.已授课 2.未授课
                if (searchMap.get("teaching_state")!=null && !"".equals(searchMap.get("teaching_state"))) {
                	predicateList.add(cb.like(root.get("teaching_state").as(String.class), "%"+ searchMap.get("teaching_state") +"%"));
                }

                return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
                
            }
        };		
		
	}

	public Page<Schedule> findSearch(Map whereMap, int page, int size) {
		Specification<Schedule> specification = where(whereMap);
		PageRequest pageRequest = new PageRequest(page-1, size);
		return scheduleDao.findAll(specification, pageRequest);
	}

	public Schedule findOne(String id) {
		return scheduleDao.findById(id).get();
	}

	public void add(Schedule schedule) {
		schedule.setId(idWorker.nextId()+""); //主键值
		scheduleDao.save(schedule);
	}
	
	public void update(Schedule schedule) {
		scheduleDao.save(schedule);
	}

	public void delete(String id) {
		scheduleDao.deleteById(id);
	}

	public void deleteList(String[] ids) {
		for (String id : ids) {
			scheduleDao.deleteById(id);
		}
	}

}
