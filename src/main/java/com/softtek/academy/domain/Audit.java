package com.softtek.academy.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;




@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public class Audit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "createDate")
	private Date createDate;
	@Column(name = "updateDate")
	private Date updateDate;

	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	
	
//	@PreUpdate
	public void preUpdate(){
		updateDate=Calendar.getInstance().getTime();
	}
	
//	@PrePersist
	public void prePersist(){
		if(createDate==null){
			createDate= Calendar.getInstance().getTime();
		}
		if(updateDate==null){
			updateDate= Calendar.getInstance().getTime();
		}
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Audit other = (Audit) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Audit [createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
	
	
}
