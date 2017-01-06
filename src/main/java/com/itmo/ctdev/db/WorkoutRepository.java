package com.itmo.ctdev.db;

import com.itmo.ctdev.db.entity.Workout;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author korektur
 *         06/01/2017
 */
public interface WorkoutRepository extends MongoRepository<Workout, String> {
}
