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
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
/**
 * relacion de columna por tablero
 *
 * @version 1.0.0 2022-07-30
 * @author Nestor Quiroga <nqs48@hotmail.com>, Julian Escobar <julian.lasso@sofka.com.co>
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "krl_column_for_board")
public class ColumnForBoardDomain implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    private static final long serialVersionUID = 1L;

    /**
     * Script de actualizacion
     */
    @PreUpdate
    public void preUpdate() {
        if (this.updatedAt == null)
            this.updatedAt = Instant.now();
    }

    /**
     * Id de relacion de columna por tablero
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cfb_id", nullable = false)
    private Integer id;

    /**
     * Id de relacion de columna por tablero
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BoardDomain.class, optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "brd_id_board", nullable = false)
    @JsonBackReference(value = "columnsForBoard")
    private BoardDomain board;

    /**
     * Punto de enlace con la entidad columna (un columna por tablero puede tener muchas columna)
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ColumnDomain.class, optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "clm_id_column", nullable = false)
    @JsonBackReference(value = "columnBoard")
    private ColumnDomain column;

    /**
     * Fecha de creacion columna por tablero
     */
    @Column(name = "cfb_created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    /**
     * Fecha de actualizacion columna por tablero
     */
    @Column(name = "cfb_updated_at")
    private Instant updatedAt;

}
