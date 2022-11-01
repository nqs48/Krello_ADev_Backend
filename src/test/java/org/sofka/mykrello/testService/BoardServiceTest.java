package org.sofka.mykrello.testService;


import org.junit.jupiter.api.Test;
import org.sofka.mykrello.model.domain.BoardDomain;
import org.sofka.mykrello.model.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void createBoard() {
        BoardDomain board = new BoardDomain();
        board.setName("BoardTest");
        board.setCreatedAt(Instant.now());
        board.setUpdatedAt(Instant.now());

        BoardDomain newBoard= boardService.create(board);

        assertEquals(true,newBoard instanceof BoardDomain);

    }
}
