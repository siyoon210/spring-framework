package project.prototype.pat.PatProtoType.repository;

import org.springframework.data.domain.Page;

public class PrintPage {
    public static void printPage(Page<?> page) {
        System.out.println("totalElements: " + page.getTotalElements());
        System.out.println("totalPages: " + page.getTotalPages());
        for (Object element : page) {
            System.out.println(element.toString());
        }
    }
}
