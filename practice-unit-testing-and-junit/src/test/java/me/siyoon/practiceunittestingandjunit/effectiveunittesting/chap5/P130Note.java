package me.siyoon.practiceunittestingandjunit.effectiveunittesting.chap5;

import lombok.Getter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class P130Note {
    private GroupStub group = new GroupStub();
    
    @Test
    public void groupShouldContainTwoSupervisors() {
        List<Employee> all = group.list();
        List<Employee> employees = new ArrayList<>(all);
        Iterator<Employee> i = employees.iterator();
        while (i.hasNext()) {
            Employee employee = i.next();
            if (!employee.isSupervisor()) {
                i.remove();
            }
        }

        assertEquals(2, employees.size());
    }

    @Test
    public void groupShouldContainFiveNewcomers() {
        List<Employee> newComers = new ArrayList<>();
        for (Employee employee : group.list()) {
            LocalDateTime oneYearAgo = getOneYearAgo();
            if (employee.startingDate().isAfter(oneYearAgo)) {
                newComers.add(employee);
            }
        }

        assertEquals(5, newComers.size());
    }

    private LocalDateTime getOneYearAgo() {
        return LocalDateTime.of(2019, 1, 19, 0, 0);
    }
}
