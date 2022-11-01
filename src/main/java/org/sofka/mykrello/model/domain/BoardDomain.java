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
@Table(name = "krl_board")
public class BoardDomain implements Serializable {

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
     * Identificador del tablero
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brd_id", nullable = false)
    private Integer id;

    /**
     * Nombre del tablero
     */
    @Column(name = "brd_name", nullable = false, length = 100)
    private String name;

    /**
     * Fecha de creación del tablero
     */
    @Column(name = "brd_created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();
    /**
     * Fecha de actualización del tablero
     */
    @Column(name = "brd_updated_at")
    private Instant updatedAt;

    /**
     * Disponibilidad del tablero para borrado lógico
     */
    @Column(name = "brd_enable")
    private Boolean enable = true;

    /**
     * Punto de enlace entre la entidad del Tablero y Columnas Por Tablero (un tablero puede tener muchas Columnas Por Tablero)
     */
    @OneToMany(fetch = FetchType.LAZY, targetEntity = ColumnForBoardDomain.class, cascade = CascadeType.ALL, mappedBy = "board")
    @JsonManagedReference(value = "columnsForBoard")
    private List<ColumnForBoardDomain> columnsForBoard = new ArrayList<>();

    /**
     * Punto de enlace entre la entidad del Tablero y tareas (un tablero puede tener muchas tareas)
     */
    @OneToMany(mappedBy = "boardTask",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "tasksByBoard")
    private List<TaskDomain> tasksByBoard = new ArrayList<>();


}
