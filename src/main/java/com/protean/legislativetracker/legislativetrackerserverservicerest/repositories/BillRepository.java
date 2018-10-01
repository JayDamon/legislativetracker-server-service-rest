package com.protean.legislativetracker.legislativetrackerserverservicerest.repositories;

import com.protean.legislativetracker.legislativetrackerserverservicerest.model.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, Long> {
}
