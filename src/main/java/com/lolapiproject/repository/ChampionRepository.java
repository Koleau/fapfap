package com.lolapiproject.repository;

import com.lolapiproject.bean.Champion;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Pflieger on 27/04/2016.
 */
public interface ChampionRepository extends MongoRepository<Champion, Integer>{
}
