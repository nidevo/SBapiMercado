package com.api.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.mercado.model.Produto;

public interface MercadoRepository extends JpaRepository<Produto, Long> {

}
