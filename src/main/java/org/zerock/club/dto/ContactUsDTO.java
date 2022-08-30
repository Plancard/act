package org.zerock.club.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ContactUsDTO{
    private int c_id;
    private String m_email;
    private String c_contentTitle;
    private String c_contactUsValues;
    private String c_content;
    private Timestamp c_regDate;
    private boolean c_checked;
    private MemberDTO memberDTO;
    private ContactUsImgDTO contactUsImgDTO;

}
