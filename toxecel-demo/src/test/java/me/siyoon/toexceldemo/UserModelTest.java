package me.siyoon.toexceldemo;

import com.github.ckpoint.toexcel.core.ToWorkBook;
import com.github.ckpoint.toexcel.core.ToWorkSheet;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserModelTest {

    @Test
    public void test() throws Exception {
        //given
        ToWorkBook toWorkBook = new ToWorkBook(new File("src/main/resources/excel/test.xlsx"));
        System.out.println("toWorkBook = " + toWorkBook.getSheets());
        ToWorkSheet toWorkSheet = toWorkBook.getSheetAt(0);
        System.out.println("toWorkSheet = " + toWorkSheet.getCell(1, 0));
        System.out.println("toWorkSheet = " + toWorkSheet.getCell(2, 0));
        System.out.println("toWorkSheet = " + toWorkSheet.getCell(1, 1));
        System.out.println("toWorkSheet = " + toWorkSheet.getCell(2, 1));
        System.out.println("toWorkSheet = " + toWorkSheet.getCell(1, 2));
        System.out.println("toWorkSheet = " + toWorkSheet.getCell(2, 2));

        //when
        List<UserModel> userModels = toWorkSheet.map(UserModel.class);

        //then
        for (UserModel userModel : userModels) {
            System.out.println("userModel = " + userModel.toString());
        }
        assertThat(userModels.size()).isEqualTo(2);
    }

}