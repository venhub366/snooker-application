package com.snooker.table.app.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.snooker.table.app.entity.SnookerTable;
import com.snooker.table.app.entity.TableStatus;
import com.snooker.table.app.repository.SnookerTableRepository;

public class SnookerTableServiceTest {

    @Mock
    private SnookerTableRepository snookerTableRepository;

    @InjectMocks
    private SnookerTableService snookerTableService;

    @Test
    public void testUpdateSnookerTableStatus() {
        // Create a mock SnookerTable object
        SnookerTable mockTable = new SnookerTable();
        mockTable.setId(1L);
        mockTable.setStatus(TableStatus.AVAILABLE);

        // Mock the behavior of the repository
        when(snookerTableRepository.findById(1L)).thenReturn(java.util.Optional.of(mockTable));

        // Update the status
        snookerTableService.updateSnookerTableStatus(1L, TableStatus.BOOKED);

        // Verify that the status is updated
        assertEquals(TableStatus.BOOKED, mockTable.getStatus());
    }

}
