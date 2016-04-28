package com.lolapiproject.repository;

import com.lolapiproject.bean.Rune;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Pflieger on 26/04/2016.
 */
public interface RuneRepository extends MongoRepository <Rune, Integer>{

}
