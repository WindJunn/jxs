package com.meiguan.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_vedio")
public class Vedio {

	@Id
	private Integer id;//标题


	
	private String title;//
	private String author;//作者
	private java.util.Date add_time;//
	private java.util.Date update_time;//
	private String video_url;//视频地址
	private String type;//视频类型  政策，文化，教育，农技，其他
	private String state;//视频状态 审核通过，审核未通过，提交未审核

	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {		
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {		
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public java.util.Date getAdd_time() {		
		return add_time;
	}
	public void setAdd_time(java.util.Date add_time) {
		this.add_time = add_time;
	}

	public java.util.Date getUpdate_time() {		
		return update_time;
	}
	public void setUpdate_time(java.util.Date update_time) {
		this.update_time = update_time;
	}

	public String getVideo_url() {		
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	public String getType() {		
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getState() {		
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}


	
}
