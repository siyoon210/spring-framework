package me.siyoon.practiceunittestingandjunit.effectiveunittesting.chap5;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupStub {
    List<Employee> list() {
        List<Employee> list = new ArrayList<>();
        list.add(
                Employee.builder()
                        .isSupervisor(true)
                        .startDate(LocalDateTime.of(2019, 2, 1, 0, 0))
                        .build()
        );
        list.add(
                Employee.builder()
                        .isSupervisor(true)
                        .startDate(LocalDateTime.of(2019, 2, 1, 0, 0))
                        .build()
        );
        list.add(
                Employee.builder()
                        .isSupervisor(false)
                        .startDate(LocalDateTime.of(2019, 2, 1, 0, 0))
                        .build()
        );
        list.add(
                Employee.builder()
                        .isSupervisor(false)
                        .startDate(LocalDateTime.of(2019, 2, 1, 0, 0))
                        .build()
        );
        list.add(
                Employee.builder()
                        .isSupervisor(false)
                        .startDate(LocalDateTime.of(2019, 2, 1, 0, 0))
                        .build()
        );
        list.add(
                Employee.builder()
                        .isSupervisor(false)
                        .startDate(LocalDateTime.of(2018, 1, 1, 0, 0))
                        .build()
        );

        return list;
    }
}
