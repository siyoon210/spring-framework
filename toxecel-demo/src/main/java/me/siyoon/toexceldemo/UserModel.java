package me.siyoon.toexceldemo;

import com.github.ckpoint.toexcel.annotation.ExcelHeader;
import lombok.ToString;

@ToString
public class UserModel {
    @ExcelHeader(headerName = "name", headerNames = {"nick-name, nickName, email"})
    private String name;

    @ExcelHeader(headerName = "age")
    private Double age;

    @ExcelHeader(headerName = "gender")
    private String gender;
}