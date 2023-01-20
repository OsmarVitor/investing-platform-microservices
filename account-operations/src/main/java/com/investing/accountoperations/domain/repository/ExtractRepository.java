package com.investing.accountoperations.domain.repository;

import com.investing.accountoperations.domain.model.Extract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtractRepository extends JpaRepository<Extract, Long> {
;
}
