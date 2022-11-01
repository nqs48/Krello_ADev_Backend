package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.model.domain.BoardDomain;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad Tablero
 *
 * @version 1.0.0 2022-07-30
 * @author Nestor Quiroga <nqs48@hotmail.com>, Julian Escobar <julian.lasso@sofka.com.co>
 * @since 1.0.0
 */
public interface BoardRepository extends JpaRepository<BoardDomain, Integer> { }
