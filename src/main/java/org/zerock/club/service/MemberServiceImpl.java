package org.zerock.club.service;

import lombok.RequiredArgsConstructor;
import org.zerock.club.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.club.entity.MemberTBL;
import org.zerock.club.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Override
    public Long register(MemberDTO memberDTO) {

        MemberTBL member = dtoToEntity(memberDTO);

        log.info("==========================");
        log.info(member);

        memberRepository.save(member);

        return member.getM_id();
    }

    @Override
    public MemberDTO get(Long num) {

        Optional<MemberTBL> result = memberRepository.getWithWriter(num);

        if(result.isPresent()){

            return entityToDTO(result.get());

        }

        return null;
    }

    @Override
    public List<MemberTBL> all(){

        List<MemberTBL> result = memberRepository.findAll();
        System.out.println(result);

        return result;
    }
}
