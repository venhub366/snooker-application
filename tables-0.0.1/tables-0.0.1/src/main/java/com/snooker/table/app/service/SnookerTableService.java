package com.snooker.table.app.service;

import com.snooker.table.app.entity.SnookerTable;

import java.util.List;

public interface SnookerTableService {
    List<SnookerTable> getAllTables();
    SnookerTable getTableById(Long id);
    SnookerTable saveTable(SnookerTable table);
    void deleteTable(Long id);
    // Other methods as needed
}
