package com.protean.legislativetracker.legislativetrackerserverservicerest.repositories;

import com.protean.legislativetracker.legislativetrackerserverservicerest.model.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State, Integer> {
}
