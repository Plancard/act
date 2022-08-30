package org.zerock.club.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.club.dto.MemberDTO;
import org.zerock.club.entity.MemberTBL;
import org.zerock.club.service.MemberService;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("/member/")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping(value = "")
    public ResponseEntity<Long> register(@RequestBody MemberDTO memberDTO){

        log.info("-----------register-------------------------------");
        log.info(memberDTO);

        Long num = Long.valueOf(memberService.register(memberDTO));

        return new ResponseEntity<>(num, HttpStatus.OK);
    }

    @GetMapping(value = "/{num}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberDTO> read(@PathVariable("num") Long num){

        log.info("-----------read-------------------------------");
        log.info(num);
        return new ResponseEntity<>(memberService.get(num), HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MemberTBL>> all(){

        return new ResponseEntity<>(memberService.all(), HttpStatus.OK);
    }
}
