package org.zerock.club.service;

import org.zerock.club.dto.MemberDTO;
import org.zerock.club.entity.MemberTBL;

import java.util.List;

public interface MemberService {

    Long register(MemberDTO memberDTO);

    MemberDTO get(Long num);
    List<MemberTBL> all();

    default MemberTBL dtoToEntity(MemberDTO memberDTO){
        MemberTBL member = MemberTBL.builder()
                .m_id(memberDTO.getM_id())
                .m_email(memberDTO.getM_email())
                .m_nickname(memberDTO.getM_nickname())
                .m_introduce(memberDTO.getM_introduce())
                .build();

        return member;
    }

    default MemberDTO entityToDTO(MemberTBL member){

        MemberDTO memberDTO = MemberDTO.builder()
                .m_id(member.getM_id())
                .m_email(member.getM_email())
                .m_nickname(member.getM_nickname())
                .m_introduce(member.getM_introduce())
                .m_gender(member.getM_gender())
                .m_regDate(member.getM_regDate())
                .build();

        return memberDTO;

    }

}
