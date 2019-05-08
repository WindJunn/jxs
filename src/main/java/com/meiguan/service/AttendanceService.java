package com.meiguan.service;

import com.meiguan.dao.AttendanceDao;
import com.meiguan.pojo.Attendance;
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
public class AttendanceService {

	@Autowired
	private AttendanceDao attendanceDao;
	
	@Autowired
	private IdWorker idWorker;

	public List<Attendance> findAll() {

		return attendanceDao.findAll();
	}

	public List findAllAttendance() {

		return attendanceDao.findAllAttendance();
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Attendance> findPage(int page, int size) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		return attendanceDao.findAll(pageRequest);
	}

	private Specification<Attendance> where(Map searchMap) {
		
		return new Specification<Attendance>() {
          
			@Override
			public Predicate toPredicate(Root<Attendance> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();

                return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
                
            }
        };		
		
	}

	public Page<Attendance> findSearch(Map whereMap, int page, int size) {
		Specification<Attendance> specification = where(whereMap);
		PageRequest pageRequest = new PageRequest(page-1, size);
		return attendanceDao.findAll(specification, pageRequest);
	}

	public Attendance findOne(String id) {
		return attendanceDao.findById(id).get();
	}

	public void add(Attendance attendance) {
		attendance.setId(idWorker.nextId()+""); //主键值
		attendanceDao.save(attendance);
	}
	
	public void update(Attendance attendance) {
		attendanceDao.save(attendance);
	}

	public void delete(String id) {
		attendanceDao.deleteById(id);
	}

	public void deleteList(String[] ids) {
		for (String id : ids) {
			attendanceDao.deleteById(id);
		}
	}

}
