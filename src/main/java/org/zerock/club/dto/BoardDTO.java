package org.zerock.club.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

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
