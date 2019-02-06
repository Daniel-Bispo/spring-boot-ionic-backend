package com.danielbispo.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.danielbispo.cursomc.domain.Categoria;
import com.danielbispo.cursomc.domain.Produto;

@Repository
//@Transactional(readOnly=true)
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	// https://docs.spring.io/spring-data/jpa/docs/2.1.4.RELEASE/reference/html/#jpa.query-methods
	
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
}
