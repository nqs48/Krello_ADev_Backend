package org.sofka.mykrello.model.domain;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
/**
 * Entidad del Log
 *
 * @version 1.0.0 2022-07-30
 * @author Nestor Quiroga <nqs48@hotmail.com>, Julian Escobar <julian.lasso@sofka.com.co>
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "krl_log")
public class LogDomain implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    private static final long serialVersionUID = 1L;

    /**
     * Id del log
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id", nullable = false, updatable = false)
    private Integer id;

    /**
     * Punto de enlace con la entidad tareas (una tarea puede tener muchos logs)
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TaskDomain.class, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "tsk_id_task", nullable = false, updatable = false)
    @JsonBackReference(value = "taskLog")
    private TaskDomain task;

    /**
     * Punto de enlace con la entidad columna previa (una tarea puede tener muchas columnas previas)
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ColumnDomain.class, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "clm_id_previous", nullable = false, updatable = false)
    @JsonBackReference(value = "logPrevious")
    private ColumnDomain previous;

    /**
     * Punto de enlace con la entidad columna (una tarea puede tener muchas columnas)
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ColumnDomain.class, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "clm_id_current", nullable = false, updatable = false)
    @JsonBackReference(value = "logCurrent")
    private ColumnDomain current;

    @Column(name = "log_created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

}
