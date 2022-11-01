package org.sofka.mykrello.model.service.interfaces;

import java.util.List;

import org.sofka.mykrello.model.domain.LogDomain;

public interface LogServiceInterface {
    List<LogDomain> findByIdTask(Integer idTask);
    public LogDomain create(LogDomain log);
}
