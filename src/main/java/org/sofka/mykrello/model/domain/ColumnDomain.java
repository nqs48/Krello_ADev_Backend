package org.sofka.mykrello.model.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
/**
 * Entidad del Tablero
 *
 * @version 1.0.0 2022-07-30
 * @author Nestor Quiroga <nqs48@hotmail.com>, Julian Escobar <julian.lasso@sofka.com.co>
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "krl_column")
public class ColumnDomain implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    private static final long serialVersionUID = 1L;

    @PreUpdate
    public void preUpdate() {
        if (this.updatedAt == null)
            this.updatedAt = Instant.now();
    }

    /**
     * Identificador del la columna
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clm_id", nullable = false)
    private Integer id;

    /**
     * Nombre del la columna
     */
    @Column(name = "clm_name", nullable = false, length = 100)
    private String name;

    /**
     * Fecha de creación del la columna
     */
    @Column(name = "clm_created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    /**
     * Fecha de actualización del la columna
     */
    @Column(name = "clm_updated_at")
    private Instant updatedAt;

    /**
     * Punto de enlace entre la entidad de Columna y Logs Previos (una Columna puede tener muchos Logs previos)
     */
    @OneToMany(fetch = FetchType.LAZY, targetEntity = LogDomain.class, cascade = CascadeType.ALL, mappedBy = "previous")
    @JsonBackReference(value = "logPrevious")
    private List<LogDomain> logPrevious = new ArrayList<>();

    /**
     * Punto de enlace entre la entidad de Columna y Logs actuales (una Columna puede tener muchos Logs actuales)
     */
    @OneToMany(fetch = FetchType.LAZY, targetEntity = LogDomain.class, cascade = CascadeType.ALL, mappedBy = "current")
    @JsonBackReference(value = "logCurrent")
    private List<LogDomain> logCurrent = new ArrayList<>();

    /**
     * Punto de enlace entre la entidad de Columna y columnas por tablero (una Columna puede tener muchos columnas por tablero)
     */
    @OneToMany(fetch = FetchType.LAZY, targetEntity = ColumnForBoardDomain.class, cascade = CascadeType.ALL, mappedBy = "column")
    @JsonManagedReference(value = "columnBoard")
    private List<ColumnForBoardDomain> columnForBoardsDetail = new ArrayList<>();

    /**
     * Punto de enlace entre la entidad de Columna y tareas (una Columna puede tener muchas tareas)
     */
    @OneToMany(fetch = FetchType.LAZY,targetEntity = TaskDomain.class,mappedBy = "columnTask",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "task-by-column")
    private List<TaskDomain> tasksByColumn = new ArrayList<>();

}
