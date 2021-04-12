package com.example.dataBaseSample.Application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ThreadDataEntityRepositoryImpl implements ThreadDataEntityRepositoryCustom{
	@Autowired
	EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ThreadDataEntity> search(String search) {
		StringBuilder sql=new StringBuilder();
		sql.append("SELECT * FROM THREAD_DATA_ENTITY WHERE title LIKE ? ORDER BY id DESC");
		Query query=manager.createNativeQuery(sql.toString(),ThreadDataEntity.class);
		query.setParameter(1, "%"+search+"%");
		
		
		
		return query.getResultList();
	}

}
