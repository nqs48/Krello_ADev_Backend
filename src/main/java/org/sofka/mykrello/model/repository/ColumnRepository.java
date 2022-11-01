package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.model.domain.ColumnDomain;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad columna
 *
 * @version 1.0.0 2022-07-30
 * @author Nestor Quiroga <nqs48@hotmail.com>, Julian Escobar <julian.lasso@sofka.com.co>
 * @since 1.0.0
 */
public interface ColumnRepository extends JpaRepository<ColumnDomain, Integer> { }
