package com.example.dataBaseSample.Application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ComentDataRepositoryCustomImpl implements ComentDataRepositoryCustom {
@Autowired
EntityManager manager;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<ComentDataEntity> searchThread(Integer threadNumber) {
		StringBuilder sql=new StringBuilder();
		sql.append("SELECT * FROM COMENT_DATA_ENTITY WHERE THREAD_NUMBER=");
		sql.append(threadNumber);
			System.out.println("クエリ実行前");
		Query query=manager.createNativeQuery(sql.toString(),ComentDataEntity.class);
		System.out.println("クエリ実行後");
		
		
		
		return query.getResultList();
	}

}
