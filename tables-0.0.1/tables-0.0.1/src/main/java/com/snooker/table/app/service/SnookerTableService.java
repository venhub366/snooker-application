package com.snooker.table.app.service;

import com.snooker.table.app.entity.SnookerTable;
import com.snooker.table.app.entity.TableStatus;

import java.util.List;

public interface SnookerTableService {
    List<SnookerTable> getAllTables();
    void deleteTable(Long id);
	SnookerTable updateSnookerTableStatus(Long tableId, TableStatus status);
	SnookerTable addNewTable(SnookerTable table);
	TableStatus getSnookerTableStatus(Long id);
	SnookerTable getTableById(Long id);
	double calculateCost(Long id, int hours);
}
