package br.com.manegerfiles.repository;

import br.com.manegerfiles.model.Diretorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiretorioRepository extends JpaRepository<Diretorio, Long> {
}
