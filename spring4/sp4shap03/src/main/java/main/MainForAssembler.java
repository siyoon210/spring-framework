package main;

import assembler.Assembler;
import spring.*;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForAssembler {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("명령어를 입력하세요");
            String command = reader.readLine();
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("종료합니다");
                break;
            }
            if (command.startsWith("new ")) {
                processNewCommand(command.split(" "));
                continue;
            } else if (command.startsWith("chagne ")) {
                processChangeCommand(command.split(" "));
                continue;

            }
            printHelp();
        }
    }

    private static Assembler assembler = new Assembler();

    private static void processNewCommand(String[] arg) {
        if (arg.length != 5) {
            printHelp();
            return;
        }
        MemberRegisterService regSvc = assembler.getMemberRegisterService();
        RegisterRequest req = new RegisterRequest();
        req.setEmail(arg[1]);
        req.setName(arg[2]);
        req.setPassword(arg[3]);
        req.setConfirmPassword(arg[4]);

        if (!req.isPasswordEqualToConfirmPassword()) {
            System.out.println("암호와 확인이 일치하지 않습니다.\n");
            return;
        }

        try {
            regSvc.regist(req);
            System.out.println("등록했습니다.\n");
        } catch (AlreadyExistingMemberException e) {
            System.out.println("이미 존재하는 이메일 입니다. \n");
        }
    }

    private static void processChangeCommand(String[] arg) {
        if (arg.length != 4) {
            printHelp();
            return;
        }
        ChangePasswordService chagePwdSvc = assembler.getChangePasswordService();
        try {
            chagePwdSvc.changePassword(arg[1], arg[2], arg[3]);
            System.out.println("암호를 변경했습니다. \n");
        } catch (MemberNotFoundException e) {
            System.out.println("존재하지 않는 이메일입니다. \n");

        } catch (IdPasswordNotMatchingException e) {
            System.out.println("이메일과 암호가 일치하지 않습니다. \n");

        }
    }


    private static void printHelp() {
        System.out.println("잘못된 명령어");
    }

}
