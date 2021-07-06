package com.app.examen.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.examen.model.entity.Jobs;

public interface JobsDao extends CrudRepository<Jobs, Long>{

}
