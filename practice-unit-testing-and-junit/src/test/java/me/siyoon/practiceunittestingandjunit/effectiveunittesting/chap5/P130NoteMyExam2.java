package me.siyoon.practiceunittestingandjunit.effectiveunittesting.chap5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class P130NoteMyExam2 {
    private GroupStub group = new GroupStub();

    interface Filter {
        boolean selectEmployee(Employee employee);
    }
    
    @Test
    public void groupShouldContainTwoSupervisors() {
        List<Employee> employees = getEmployees(new Filter() {
            @Override
            public boolean selectEmployee(Employee employee) {
                return employee.isSupervisor();
            }
        });

        assertEquals(2, employees.size());
    }

    private List<Employee> getEmployees(Filter filter) {
        List<Employee> employees = new ArrayList<>();

        for (Employee employee : group.list()) {
            if (filter.selectEmployee(employee)) {
                employees.add(employee);
            }
        }

        return employees;
    }

    @Test
    public void groupShouldContainFiveNewcomers() {
        LocalDateTime oneYearAgo = getOneYearAgo();

        final List<Employee> newComers = getEmployees(new Filter() {
            @Override
            public boolean selectEmployee(Employee employee) {
                return employee.startingDate().isAfter(oneYearAgo);
            }
        });

        assertEquals(5, newComers.size());
    }

    private LocalDateTime getOneYearAgo() {
        return LocalDateTime.of(2019, 1, 19, 0, 0);
    }
}
