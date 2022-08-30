package org.zerock.club.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class MemberTBL{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long m_id;

    private String m_code;
    private String m_email;
    private String m_nickname;
    private String m_password;
    private Date m_birth;
    private String m_introduce;
    private byte[] m_profilePic;
    private String m_gender;
    private boolean m_licensed;
    private int m_warnCount;
    private boolean m_available;
    private Timestamp m_regDate;


}
