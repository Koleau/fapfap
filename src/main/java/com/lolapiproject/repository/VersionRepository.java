package com.lolapiproject.repository;

import com.lolapiproject.bean.Version;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Pflieger on 27/04/2016.
 */
public interface VersionRepository extends MongoRepository<Version, Integer> {

    public Version findByCollection(String collection);

}
