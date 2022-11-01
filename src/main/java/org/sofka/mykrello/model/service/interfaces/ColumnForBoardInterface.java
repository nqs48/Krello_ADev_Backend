package org.sofka.mykrello.model.service.interfaces;
import org.sofka.mykrello.model.domain.ColumnForBoardDomain;
import org.sofka.mykrello.model.domain.TaskDomain;

import java.util.List;

/**
 * Interfaz para el servicio ColumnService
 *
 * @version 1.0.0 2022-07-30
 * @author Nestor Quiroga <nqs48@hotmail.com>, Julian Escobar <julian.lasso@sofka.com.co>
 * @since 1.0.0
 */
public interface ColumnForBoardInterface {

    /**
     * Develve la columna por tablero mediante su Id
     *
     * @return Entidad columna por tablero
     *
     * @author Nestor Quiroga <nqs48@hotmail.com>, Julian Escobar <julian.lasso@sofka.com.co>
     * @since 0.0.1 2022-07-26
     */
    ColumnForBoardDomain getColumnForBoardById(Integer idColumn);

    /**
     * Develve una lista de tareas pertenecientes a esa columna por tablero mediante el id del tablero y de la columna
     *
     * @return Entidad columna por tablero
     *
     * @author Nestor Quiroga <nqs48@hotmail.com>, Julian Escobar <julian.lasso@sofka.com.co>
     * @since 0.0.1 2022-07-26
     */
    List<TaskDomain> getTasksByColumn(Integer idBoard,Integer idColumn);

}
