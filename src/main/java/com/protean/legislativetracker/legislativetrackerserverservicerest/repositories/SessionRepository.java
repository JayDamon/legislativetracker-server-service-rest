package com.protean.legislativetracker.legislativetrackerserverservicerest.repositories;

import com.protean.legislativetracker.legislativetrackerserverservicerest.model.LegislativeSession;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<LegislativeSession, Integer> {
}
