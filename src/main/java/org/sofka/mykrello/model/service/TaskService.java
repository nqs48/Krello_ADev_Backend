package org.sofka.mykrello.model.service;

import java.time.Instant;
import java.util.List;
import org.sofka.mykrello.model.domain.LogDomain;
import org.sofka.mykrello.model.domain.TaskDomain;
import org.sofka.mykrello.model.repository.TaskRepository;
import org.sofka.mykrello.model.service.interfaces.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class TaskService implements TaskServiceInterface {

    @Autowired
    private LogService logService;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private BoardService boardService;


    @Override
    public List<TaskDomain> findAllTasksById(Integer idBoard) {
        return null;
    }
    @Override
    public TaskDomain findById(Integer id) {
        var task = taskRepository.findById(id);
        if(task.isPresent()){
            if(task.get().getEnable())return task.get();
            return null;
        }else{
            return null;
        }
    }

    @Override
    public TaskDomain create(TaskDomain task) {
        var column = columnService.findById(1);
        var board = boardService.findById(task.getBoardTask().getId());
        task.setBoardTask(board);
        task.setColumnTask(column);
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public TaskDomain update(Integer id, TaskDomain task) {

        var currentTask = taskRepository.findById(id);
        LogDomain logDomain = new LogDomain();

        Integer idColumnPrevious = currentTask.get().getColumnTask().getId();
        Integer idColumnCurrent = task.getColumnTask().getId();

        logDomain.setPrevious(columnService.findById(idColumnPrevious));
        logDomain.setCurrent(columnService.findById(idColumnCurrent));

        task.setId(id);
        task.setBoardTask(currentTask.get().getBoardTask());
        task.setCreatedAtTask(currentTask.get().getCreatedAtTask());
        if(task.getNameTask()==null) task.setNameTask(currentTask.get().getNameTask());
        if(task.getDeliveryTask()==null) task.setDeliveryTask(currentTask.get().getDeliveryTask());
        if(task.getDescriptionTask()==null) task.setDescriptionTask(currentTask.get().getDescriptionTask());
        task.setEnable(currentTask.get().getEnable());
        task.setColumnTask(columnService.findById(idColumnCurrent));
        task.setUpdatedAtTask(Instant.now());

        logDomain.setTask(currentTask.get());
        logService.create(logDomain);
        return taskRepository.save(task);


    }

    @Override
    public TaskDomain delete(Integer id) {
        var taskToDelete = taskRepository.findById(id);
        if(taskToDelete.isPresent()){
            taskToDelete.get().setEnable(false);
            taskRepository.save(taskToDelete.get());
            return taskToDelete.get();
        }else{
            return null;
        }

    }
}
