package com.yicj.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class OperationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private Date createdAt;
    @PrePersist
    public void settingTime(){
        createdAt = new Date();
    }
}