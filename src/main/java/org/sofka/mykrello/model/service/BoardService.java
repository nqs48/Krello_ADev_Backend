package org.sofka.mykrello.model.service;

import java.util.ArrayList;
import java.util.List;
import org.sofka.mykrello.model.domain.BoardDomain;
import org.sofka.mykrello.model.domain.ColumnForBoardDomain;
import org.sofka.mykrello.model.repository.BoardRepository;
import org.sofka.mykrello.model.repository.ColumnForBoardRepository;
import org.sofka.mykrello.model.repository.ColumnRepository;
import org.sofka.mykrello.model.repository.TaskRepository;
import org.sofka.mykrello.model.service.interfaces.BoardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService implements BoardServiceInterface {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ColumnRepository columnRepository;

    @Autowired
    private ColumnForBoardRepository columnForBoardRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BoardDomain> getAll() {
        List<BoardDomain> boardsEnables = new ArrayList<>();
        var boards =  boardRepository.findAll();
        if(!boards.isEmpty()){
            boards.forEach((board)->{
                if(board.getEnable())boardsEnables.add(board);
            });
        }
        return boardsEnables;
    }

    @Override
    @Transactional(readOnly = true)
    public BoardDomain findById(Integer id) {
        var board = boardRepository.findById(id);
        if(board.isPresent()){
            if(board.get().getEnable())return board.get();
            return null;
        }else{
            return null;
        }
    }

    @Override
    @Transactional
    public BoardDomain create(BoardDomain board) {
        var newBoard = boardRepository.save(board);
        var columns = columnRepository.findAll();
        if (!columns.isEmpty()) {
            columns.forEach(column -> {
                var columnForBoard = new ColumnForBoardDomain();
                columnForBoard.setColumn(column);
                columnForBoard.setBoard(newBoard);
                columnForBoardRepository.save(columnForBoard);
            });
        }
        return newBoard;
    }

    @Override
    @Transactional
    public BoardDomain update(Integer id, BoardDomain board) {
        var boardfind = boardRepository.findById(id);
        if(boardfind.isPresent()){
            board.setId(id);
            board.setCreatedAt(boardfind.get().getCreatedAt());
            board.setTasksByBoard(boardfind.get().getTasksByBoard());
            board.setColumnsForBoard(boardfind.get().getColumnsForBoard());
            if(board.getName() == null) board.setName(boardfind.get().getName());
            board.setEnable(true);
        }
        return boardRepository.save(board);
    }

    @Override
    @Transactional
    public BoardDomain delete(Integer id) {
        var optionalBoard = boardRepository.findById(id);
        if (optionalBoard.isPresent()) {
            var board = optionalBoard.get();
            var tasksForboard = board.getTasksByBoard();
            if(!tasksForboard.isEmpty()){
                tasksForboard.forEach((task)->{
                    task.setEnable(false);
                    taskRepository.save(task);
                });
            }
            optionalBoard.get().setEnable(false);
            boardRepository.save(optionalBoard.get());
            return optionalBoard.get();
        }
        return null;
    }

}
