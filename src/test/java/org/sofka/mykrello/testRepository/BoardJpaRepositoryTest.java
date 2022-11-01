package org.sofka.mykrello.testRepository;


import org.junit.jupiter.api.Test;
import org.sofka.mykrello.model.domain.BoardDomain;
import org.sofka.mykrello.model.repository.BoardRepository;
import org.sofka.mykrello.model.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class BoardJpaRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void saveBoard() {
        var board = new BoardDomain();
        board.setName("BoardTest");
        board.setCreatedAt(Instant.now());

        boardRepository.save(board);
        boardRepository.flush();

        assertEquals(1,boardRepository.findAll().size());

    }

    @Test
    public void findById(){
        var board = new BoardDomain();
        board.setName("BoardTest");
        board.setCreatedAt(Instant.now());

        boardRepository.save(board);
        boardRepository.flush();

        var boardFound = boardRepository.findById(board.getId());
        assertEquals(board.getName(),boardFound.get().getName());
    }

//    @Test
//    public void findById2(){
//        var board = new BoardDomain();
//        board.setName("BoardTest");
//        board.setCreatedAt(Instant.now());
//
//        boardService.create(board);
//
//        var boardFound = boardService.findById(board.getId());
//        System.out.println(boardFound);
//        assertEquals(board.getName(),boardFound.getName());
//
//    }






}
