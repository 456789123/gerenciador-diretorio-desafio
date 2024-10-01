package br.com.manegerfiles.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiretorioDTO {

    private Long idDiretorio;
    private String nomeDiretorio;
    private List<DiretorioDTO> subDiretorios;
    private List<String> listaArquivos;
    private String messageRetorno;
}
