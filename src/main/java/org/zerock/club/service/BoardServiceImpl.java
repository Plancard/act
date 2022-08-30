package org.zerock.club.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.zerock.club.dto.BoardDTO;
import org.zerock.club.entity.BoardTBL;
import org.zerock.club.repository.BoardTBLRepository;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardTBLRepository boardRepository;

    @Override
    public BoardDTO get(Long num) {
        Optional<BoardTBL> result = boardRepository.getWithWriter(num);

        boardRepository.addCounts(num);

        if(result.isPresent()){
            return entityToDto(result.get());
        }
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long num) {

        boardRepository.deleteById(num);
        return null;
    }

    @Override
    public List<BoardTBL> all() {
        List<BoardTBL> result = boardRepository.findAll();

        return result;
    }

    @Override
    public BoardTBL updateBoard(Long num, BoardTBL boardTBL) {

        boardTBL.setP_id(num);

        return boardRepository.save(boardTBL);
    }

    @Override
    public BoardTBL createBoard(BoardTBL boardTBL) {

        return boardRepository.save(boardTBL);
    }

//    @Override
//    public BoardTBL updateBoard(Long num, BoardTBL boardTBL) {
//
//        return boardRepository.findById(num);
//    }
}
