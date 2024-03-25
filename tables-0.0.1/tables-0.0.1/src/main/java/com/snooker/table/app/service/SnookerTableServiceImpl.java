package com.snooker.table.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snooker.table.app.entity.SnookerTable;
import com.snooker.table.app.entity.TableStatus;
import com.snooker.table.app.repository.SnookerTableRepository;

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

    @Override
    public SnookerTable getTableById(Long id) {
        Optional<SnookerTable> optionalTable = snookerTableRepository.findById(id);
        return optionalTable.orElse(null); // Return null if table with given ID is not found
    }
	
    @Override
    public double calculateCost(Long id, int hours) {
        SnookerTable table = snookerTableRepository.findById(id).orElse(null);
        if (table != null) {
            double basePrice = table.getBasePrice();
            double hourlyCharge = table.getHourlyCharge();
            return basePrice + (hourlyCharge * hours);
        } else {
            return -1; // Indicate table not found
        }
    }


    // Implement other methods as needed
}