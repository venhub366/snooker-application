package com.snooker.table.app.controller;

import com.snooker.table.app.entity.SnookerTable;
import com.snooker.table.app.service.SnookerTableService;
import com.snooker.table.app.service.SnookerTableServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tables")
public class SnookerTableController {
	
	private static final Logger logger = LoggerFactory.getLogger(SnookerTableController.class);

    @Autowired
    private SnookerTableService snookerTableService;

    @GetMapping
    public List<SnookerTable> getAllTables() {
        return snookerTableService.getAllTables();
    }

    @GetMapping("/{id}")
    public SnookerTable getTableById(@PathVariable Long id) {
        return snookerTableService.getTableById(id);
    }

    @PostMapping("/addTable")
    public ResponseEntity<?> saveTable(@RequestBody SnookerTable table) {
        snookerTableService.saveTable(table);
        logger.info("Table object is {} ", table.toString());
        return new ResponseEntity<>("Snooker Table added successfully", HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public void deleteTable(@PathVariable Long id) {
        snookerTableService.deleteTable(id);
    }

    // Implement other CRUD operations and additional endpoints as needed
}
