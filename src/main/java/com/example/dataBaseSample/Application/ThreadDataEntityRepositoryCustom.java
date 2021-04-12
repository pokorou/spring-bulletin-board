package com.example.dataBaseSample.Application;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface ThreadDataEntityRepositoryCustom  {
	public List<ThreadDataEntity> search(String search);
}
