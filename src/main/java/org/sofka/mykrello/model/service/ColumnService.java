package org.sofka.mykrello.model.service;
import org.sofka.mykrello.model.domain.ColumnDomain;
import org.sofka.mykrello.model.repository.ColumnForBoardRepository;
import org.sofka.mykrello.model.repository.ColumnRepository;
import org.sofka.mykrello.model.service.interfaces.ColumnServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColumnService implements ColumnServiceInterface {

    @Autowired
    ColumnRepository columnRepository;

    @Autowired
    ColumnForBoardRepository columnForBoardRepository;

    @Override
    public ColumnDomain findById(Integer id) {
        return columnRepository.findById(id).orElse(null);
    }


}
