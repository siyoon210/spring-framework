package me.siyoon.practiceunittestingandjunit.effectiveunittesting.chap5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class P130NoteMyExam {
    private GroupStub group = new GroupStub();
    
    @Test
    public void groupShouldContainTwoSupervisors() {
        final List<Employee> employees = getEmployees(Employee::isSupervisor);

        assertEquals(2, employees.size());
    }

    private List<Employee> getEmployees(Predicate<? super Employee> predicate) {
        return group.list().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Test
    public void groupShouldContainFiveNewcomers() {
        LocalDateTime oneYearAgo = getOneYearAgo();
        final List<Employee> newComers = getEmployees(e -> e.startingDate().isAfter(oneYearAgo));

        assertEquals(5, newComers.size());
    }

    private LocalDateTime getOneYearAgo() {
        return LocalDateTime.of(2019, 1, 19, 0, 0);
    }
}
