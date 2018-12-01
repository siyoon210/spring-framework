package project.prototype.pat.PatProtoType.repository;

import org.springframework.data.domain.Page;

import java.util.Set;

public class Print {
    public static void printPage(Page<?> page) {
        System.out.println("totalElements: " + page.getTotalElements());
        System.out.println("totalPages: " + page.getTotalPages());
        for (Object element : page) {
            System.out.println(element.toString());
        }
    }
    public static void printSet(Set<?> set) {
        System.out.println("setSize: " + set.size());
        for (Object element : set) {
            System.out.println(element.toString());
        }
    }
}
