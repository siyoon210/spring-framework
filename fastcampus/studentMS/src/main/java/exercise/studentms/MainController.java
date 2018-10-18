package exercise.studentms;

import exercise.studentms.dao.StudentDAO;

public class MainController {
    private StudentDAO studentDAO;
    private UI ui;

    public MainController(StudentDAO studentDAO, UI ui) {
        this.studentDAO = studentDAO;
        this.ui = ui;
    }

    public void control() {

        while (true) {
            int controlNum = ui.main();
            if (controlNum == 1) {
                Student student = ui.addStudent();
                if (student != null) {
                    studentDAO.addStudent(student);
                    System.out.println("등록했습니다.");
                }
            } else if (controlNum == 2) {
                ui.listStudnet(studentDAO.getStudentList());
            } else if (controlNum == 3) {
                ui.end();
                break;
            }else{
                System.out.println("잘못된 입력값");
            }
        }



    }

}
