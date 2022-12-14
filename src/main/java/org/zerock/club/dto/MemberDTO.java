package org.zerock.club.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Base64;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

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


    //// 뷰에서 이미지 불러오기용: 바이트 배열의 이미지를 Base64를 통해 인코딩한 뒤 문자열로 반환. 뷰에서 타임리프로 <img th:src="${dto.profileImage}">등으로 쓰면 된다.
   //// PostDTO에서 같은 방식 사용
   public String getProfileImage() {
      if( m_profilePic == null ) return "data:image/png;base64," + defaultPropic();// 프사가 없으면 기본프사 반환
      return "data:image/png;base64," + new String(Base64.getEncoder().encodeToString(m_profilePic));
   }
   
   @Override
   public String toString() {
      return "MemberDTO [m_id=" + m_id + ", m_email=" + m_email + ", m_nickname=" + m_nickname + ", m_password="
            + m_password + ", m_birth=" + m_birth + ", m_introduce=" + m_introduce + ", m_profilePic="
            + m_profilePic + ", m_gender=" + m_gender + ", m_licensed=" + m_licensed + ", m_warnCount="
            + m_warnCount + ", m_available=" + m_available + ", m_regDate=" + m_regDate + "]";
   }
   
   
   
   
   
   //// 문자열로 저장된 기본 프사 이미지
   private String defaultPropic() {
      //// 약 2천5백 자
      return "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";
   }
   
}
