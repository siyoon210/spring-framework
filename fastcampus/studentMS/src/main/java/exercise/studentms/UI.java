package exercise.studentms;

import java.util.List;
import java.util.Scanner;

public class UI {
    public int main() {
        Scanner sc = new Scanner(System.in);
        int controlNum = 0;

        System.out.println();
        System.out.println("1) 학생 등록 ");
        System.out.println("2) 학생 목록보기 ");
        System.out.println("3) 종료 ");
        System.out.println(
        );

        do {
            System.out.print("번호를 입력하세요 : ");
            controlNum = sc.nextInt();
        } while (controlNum < 1 || controlNum > 3);
        System.out.println();
        return controlNum;
    }

    public Student addStudent(){
        Scanner sc = new Scanner(System.in);
        Student student = null;

        System.out.println("학생 정보를 입력해주세요");
        System.out.print("이름 : "); String name = sc.nextLine();
        int math = 0;
        int eng = 0;
        int lang = 0;
        boolean unvalidInput = false;
        do {
            try {
                System.out.print("수학점수 : ");
                math = sc.nextInt();
                System.out.print("영어점수 : ");
                eng = sc.nextInt();
                System.out.print("국어점수 : ");
                lang = sc.nextInt();
                unvalidInput = false;
            } catch (Exception e) {
                sc.nextLine();
                unvalidInput = true;
            }
        } while (unvalidInput == true);


        System.out.println("등록하시겠습니까? (Y/N)");
        sc.nextLine();
        String pattern = "(Y?|N?)";
        String commit = sc.next(pattern);

        if (commit == "Y") {
            student = new Student(name, math, eng, lang);
        } else {
            student =null;
            System.out.println("등록을 취소합니다.");
        }
        return student;
    }

    public void listStudnet(List<Student> studentList) {
        for (Student student : studentList) {
            System.out.println(student.getName() + "> "+ "수학 : " + student.getMath()+" 영어 : " + student.getEng()+" 국어 : " + student.getLang());
        }
    }

    public void end() {
        System.out.println("종료합니다.");
    }
}
