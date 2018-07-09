package com.dpc.service.impl;

import java.util.List;

import com.dpc.dao.BloodSugarDao;
import com.dpc.pojo.BloodSugar;
import com.dpc.service.BloodSugarService;

public class BloodSugarServiceImpl implements BloodSugarService {
	
		private BloodSugarDao bloodSugarDao;
		
		

	    public BloodSugarDao getBloodSugarDao() {
			return bloodSugarDao;
		}



		public void setBloodSugarDao(BloodSugarDao bloodSugarDao) {
			this.bloodSugarDao = bloodSugarDao;
		}



	  @Override
	  public boolean addBloodSugarRecord(BloodSugar record) {
		return bloodSugarDao.addBloodSugarRecord(record);
	 }



	@Override
	public List<BloodSugar> getBloodSugarRecord(int userId) {
		return bloodSugarDao.getBloodSugarRecord(userId);
	}





}
