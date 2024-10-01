package br.com.manegerfiles.controller;

import br.com.manegerfiles.dto.DiretorioDTO;
import br.com.manegerfiles.service.FilesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/diretorio")
public class FilesController {

    private FilesService service;

    @RequestMapping("/banco-dados")
    public ResponseEntity<List<DiretorioDTO>> trazerEstruturaDiretorioBanco() {
        return ResponseEntity.ok(service.trazerEstruturaDiretorioBanco());
    }

    @RequestMapping("/storage-servidor")
    public ResponseEntity<List<DiretorioDTO>> trazerEstruturaDiretorioStorageServidor() {
        return ResponseEntity.ok(service.trazerEstruturaDiretorioStorageServidor());
    }

    @PostMapping
    public ResponseEntity<DiretorioDTO> trazerEstruturaDiretorioStorageServidor(@RequestBody DiretorioDTO diretorio) {
        return ResponseEntity.ok(service.salvar(diretorio));
    }

    @PutMapping
    public ResponseEntity<DiretorioDTO> atualizarEstruturaDiretorioStorageServidor(@RequestBody DiretorioDTO diretorio) {
        return ResponseEntity.ok(service.atualizar(diretorio));
    }

    @DeleteMapping("/{idDiretorio}")
    public ResponseEntity<DiretorioDTO> deletarEstruturaDiretorioStorageServidor(@PathVariable("idDiretorio") Long idDiretorio) {
        return ResponseEntity.ok(service.deletar(idDiretorio));
    }

}
