package com.snooker.table.app.service;

import com.snooker.table.app.entity.SnookerTable;
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
    public SnookerTable getTableById(Long id) {
        return snookerTableRepository.findById(id).orElse(null);
    }

    @Override
    public SnookerTable saveTable(SnookerTable table) {
        return snookerTableRepository.save(table);
    }

    @Override
    public void deleteTable(Long id) {
        snookerTableRepository.deleteById(id);
    }

    // Implement other methods as needed
}