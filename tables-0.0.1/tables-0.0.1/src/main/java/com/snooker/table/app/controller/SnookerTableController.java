package com.snooker.table.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.snooker.table.app.entity.SnookerTable;
import com.snooker.table.app.entity.TableStatus;
import com.snooker.table.app.service.SnookerTableService;

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

    @GetMapping("/{id}/tableStatus")
    public TableStatus getTableStatusById(@PathVariable Long id) {
        return snookerTableService.getSnookerTableStatus(id);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<SnookerTable> getTableById(@PathVariable Long id) {
        SnookerTable table = snookerTableService.getTableById(id);
        if (table != null) {
            return new ResponseEntity<>(table, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addTable")
    public ResponseEntity<?> saveTable(@RequestBody SnookerTable table) {
        snookerTableService.addNewTable(table);
        logger.info("Table object is {} ", table.toString());
        return new ResponseEntity<>("Snooker Table added successfully", HttpStatus.CREATED);

    }
    
    @PutMapping("/{id}/{status}")
    public ResponseEntity<String> updateSnookerTableStatus(@PathVariable Long id, @PathVariable String status) {
        try {
            TableStatus tableStatus = TableStatus.valueOf(status); // Convert string status to TableStatus enum
            snookerTableService.updateSnookerTableStatus(id, tableStatus);
            return new ResponseEntity<>("Status updated successfully for table ID: " + id, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Invalid status provided: " + status, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTable(@PathVariable Long id) {
        snookerTableService.deleteTable(id);
    }
    
    @GetMapping("/{id}/calculateCost")
    public ResponseEntity<?> calculateCost(@PathVariable Long id, @RequestParam int hours) {
        SnookerTable table = snookerTableService.getTableById(id);
        if (table != null && table.getStatus() == TableStatus.BOOKED) {
            double basePrice = table.getBasePrice();
            double hourlyCharge = table.getHourlyCharge();
            double totalCost = basePrice + (hourlyCharge * hours);
            return new ResponseEntity<>(totalCost, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Table is not Booked Yet", HttpStatus.NOT_FOUND);
        }
    }

    // Implement other CRUD operations and additional endpoints as needed
}
