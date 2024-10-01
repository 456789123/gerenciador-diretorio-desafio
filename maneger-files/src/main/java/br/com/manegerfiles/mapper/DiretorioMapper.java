package br.com.manegerfiles.mapper;

import br.com.manegerfiles.dto.DiretorioDTO;
import br.com.manegerfiles.model.Arquivo;
import br.com.manegerfiles.model.Diretorio;

import java.util.List;
import java.util.stream.Collectors;

public class DiretorioMapper {

    public static DiretorioDTO mapToDTO(Diretorio diretorio) {
        DiretorioDTO diretorioDTO = DiretorioDTO.builder().
                                        idDiretorio(diretorio.getId()).
                                        nomeDiretorio(diretorio.getNome()).
                                    build();

        List<DiretorioDTO> subDiretorios = diretorio.getSubDiretorios().stream()
                .map(DiretorioMapper::mapToDTO)
                .collect(Collectors.toList());
        diretorioDTO.setSubDiretorios(subDiretorios);

        List<String> listaArquivos = diretorio.getListaArquivos().stream()
                .map(Arquivo::getNome)
                .collect(Collectors.toList());
        diretorioDTO.setListaArquivos(listaArquivos);

        return diretorioDTO;
    }

    public static Diretorio mapToEntity(DiretorioDTO diretorioDTO) {
        Diretorio diretorio = new Diretorio();
        diretorio.setNome(diretorioDTO.getNomeDiretorio());

        List<Diretorio> subDiretorios = diretorioDTO.getSubDiretorios().stream()
                .map(DiretorioMapper::mapToEntity)
                .collect(Collectors.toList());
        diretorio.setSubDiretorios(subDiretorios);

        List<Arquivo> listaArquivos = diretorioDTO.getListaArquivos().stream()
                .map(nome -> {
                    Arquivo arquivo = new Arquivo();
                    arquivo.setNome(nome);
                    arquivo.setDiretorio(diretorio);
                    return arquivo;
                })
                .collect(Collectors.toList());
        diretorio.setListaArquivos(listaArquivos);

        return diretorio;
    }
}
