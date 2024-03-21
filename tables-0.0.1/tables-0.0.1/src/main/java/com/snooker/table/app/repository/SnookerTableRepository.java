package com.snooker.table.app.repository;

import com.snooker.table.app.entity.SnookerTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnookerTableRepository extends JpaRepository<SnookerTable, Long> {
}
