package org.zerock.club.service;

import org.springframework.http.ResponseEntity;
import org.zerock.club.dto.BoardDTO;
import org.zerock.club.entity.BoardTBL;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BoardService {

    BoardDTO get(Long num);
    ResponseEntity<?> delete(Long num);
    List<BoardTBL> all();
    BoardTBL updateBoard(Long num, BoardTBL boardTBL);
    BoardTBL createBoard(BoardTBL boardTBL);
//    BoardTBL updateBoard(Long num, BoardTBL boardTBL);

    default BoardTBL dtoToEntity(BoardDTO boardDTO){
        BoardTBL board = BoardTBL.builder()
                .p_id(boardDTO.getP_id())
                .p_title(boardDTO.getP_title())
                .p_nickname(boardDTO.getP_nickname())
                .p_content(boardDTO.getP_content())
                .p_writer(boardDTO.getP_writer())
                .counts(boardDTO.getCounts())
                .likes(boardDTO.getLikes())
                .createdTime(boardDTO.getCreatedTime())
                .updatedTime(boardDTO.getUpdatedTime())
                .build();

        return board;
    }

    default BoardDTO entityToDto(BoardTBL board){

        BoardDTO boardDTO = BoardDTO.builder()
                .p_id(board.getP_id())
                .p_title(board.getP_title())
                .p_nickname(board.getP_nickname())
                .p_content(board.getP_content())
                .p_writer(board.getP_writer())
                .counts(board.getCounts())
                .likes(board.getLikes())
                .createdTime(board.getCreatedTime())
                .updatedTime(board.getUpdatedTime())
                .build();

        return boardDTO;
    }
}
