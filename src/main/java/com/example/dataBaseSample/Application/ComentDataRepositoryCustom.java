package com.example.dataBaseSample.Application;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface ComentDataRepositoryCustom {
	public List<ComentDataEntity> searchThread(Integer threadNumber);
}
