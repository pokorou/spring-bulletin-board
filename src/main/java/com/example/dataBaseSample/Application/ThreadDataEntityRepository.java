package com.example.dataBaseSample.Application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ThreadDataEntityRepository extends JpaRepository<ThreadDataEntity, Integer> {

}
