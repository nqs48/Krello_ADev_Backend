package org.sofka.mykrello.model.service;
import org.sofka.mykrello.model.domain.ColumnForBoardDomain;
import org.sofka.mykrello.model.domain.TaskDomain;
import org.sofka.mykrello.model.repository.ColumnForBoardRepository;
import org.sofka.mykrello.model.service.interfaces.ColumnForBoardInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class ColumnForBoardService implements ColumnForBoardInterface {

    @Autowired
    ColumnForBoardRepository columnForBoardRepository;

    @Override
    public ColumnForBoardDomain getColumnForBoardById(Integer idColumn) {
        return columnForBoardRepository.findById(idColumn).orElse(null);
    }

    @Override
    public List<TaskDomain> getTasksByColumn(Integer idBoard,Integer idColumn) {
        var tasks =  columnForBoardRepository.findById(idColumn).get().getColumn().getTasksByColumn();
        List<TaskDomain> taskByBoard = new ArrayList<>();
        if(!tasks.isEmpty()){
            tasks.forEach((task)->{
                if(task.getBoardTask().getId().equals(idBoard) && task.getEnable()){
                    taskByBoard.add(task);
                }
            });
        }
        return taskByBoard;
    }
}
