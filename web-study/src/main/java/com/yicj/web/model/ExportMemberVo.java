package com.yicj.web.model;

import lombok.Data;

@Data
public class ExportMemberVo {
    private String name;
    private Integer gender;
    private String idCard;
    private String bankNo;
    private String bankName;
    private String phone;

    public String getGender() {
        return gender == 0 ? "男" : "女";
    }
}
