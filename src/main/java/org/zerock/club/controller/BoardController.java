package org.zerock.club.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.club.dto.BoardDTO;
import org.zerock.club.entity.BoardTBL;
import org.zerock.club.service.BoardService;

import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequestMapping("/board/")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 글 목록 전체 불러오기
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BoardTBL>> all(){

        return new ResponseEntity<>(boardService.all(), HttpStatus.OK);
    }

    // 글 하나만 읽어오기
    @GetMapping(value = "/{num}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BoardDTO> read(@PathVariable("num") Long num){

        System.out.println("글 조회함!");

        return new ResponseEntity<>(boardService.get(num), HttpStatus.OK);
    }

    // 글 작성
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BoardTBL> createBoard(@RequestBody BoardTBL boardTBL){

        return new ResponseEntity<>(boardService.createBoard(boardTBL), HttpStatus.OK);
    }

    // 글 삭제
    @DeleteMapping(value = "/{num}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteBoard(@PathVariable("num") Long num){
        System.out.println("=============================");

        return new ResponseEntity<>(boardService.delete(num),HttpStatus.OK);

    }

    // 글 수정
    @PutMapping(value = "/{num}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BoardTBL> updateBoard(@PathVariable("num")Long num, @RequestBody BoardTBL boardTBL){

        return new ResponseEntity<>(boardService.updateBoard(num, boardTBL), HttpStatus.OK);
    }

}
