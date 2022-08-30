package org.zerock.club.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AnswerDTO{
    private int a_no;
    private int c_id;
    private String a_content;
    private Timestamp a_regDate;

}
