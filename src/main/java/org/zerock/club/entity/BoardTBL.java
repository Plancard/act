package org.zerock.club.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardTBL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id;

    private Long p_writer;
    private String p_title;
    private String p_content;
    private Date createdTime;
    private Date updatedTime;
    private int likes;
    private int counts;
    private String p_nickname;


}
