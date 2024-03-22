package com.snooker.table.app.service;

import com.snooker.table.app.entity.SnookerTable;
import com.snooker.table.app.entity.TableStatus;
import com.snooker.table.app.repository.SnookerTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnookerTableServiceImpl implements SnookerTableService {

    @Autowired
    private SnookerTableRepository snookerTableRepository;

    @Override
    public List<SnookerTable> getAllTables() {
        return snookerTableRepository.findAll();
    }

    @Override
    public TableStatus getSnookerTableStatus(Long tableId) {
        SnookerTable table = snookerTableRepository.findById(tableId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid table ID"));
        return table.getStatus();
    }

    @Override
    public SnookerTable addNewTable(SnookerTable table) {
    	table.setStatus(TableStatus.AVAILABLE);
        return snookerTableRepository.save(table);
    }
    @Override
    public SnookerTable updateSnookerTableStatus(Long tableId, TableStatus status) {
        SnookerTable table = snookerTableRepository.findById(tableId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid table ID"));
        table.setStatus(status);
        return snookerTableRepository.save(table);
    }

    @Override
    public void deleteTable(Long id) {
        snookerTableRepository.deleteById(id);
    }


    // Implement other methods as needed
}