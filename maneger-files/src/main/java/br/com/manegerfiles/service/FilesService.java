package br.com.manegerfiles.service;

import br.com.manegerfiles.dto.DiretorioDTO;
import br.com.manegerfiles.mapper.DiretorioMapper;
import br.com.manegerfiles.model.Diretorio;
import br.com.manegerfiles.repository.DiretorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FilesService {

    @Value("${app.diretorio}")
    private String directoryPath;

    private ObjectMapper objectMapper;


    @Autowired
    private DiretorioRepository diretorioRepository;


    public FilesService() {
        this.objectMapper = new ObjectMapper();
    }

    public List<DiretorioDTO> trazerEstruturaDiretorioStorageServidor() {
        File diretorioRaiz = new File(directoryPath);
        return montarEstruturaDiretorio(diretorioRaiz);
    }

    private List<DiretorioDTO> montarEstruturaDiretorio(File diretorio) {
        List<DiretorioDTO> estrutura = new ArrayList<>();
        if (diretorio.isDirectory()) {
            DiretorioDTO diretorioDTO = DiretorioDTO.builder().nomeDiretorio(diretorio.getName()).build();
            List<String> listaArquivos = new ArrayList<>();
            List<DiretorioDTO> subDiretorios = new ArrayList<>();
            for (File subDiretorio : diretorio.listFiles()) {
                if (subDiretorio.isDirectory()) {
                    subDiretorios.addAll(montarEstruturaDiretorio(subDiretorio));
                } else {
                    listaArquivos.add(subDiretorio.getName());
                }
            }
            diretorioDTO.setListaArquivos(listaArquivos);
            diretorioDTO.setSubDiretorios(subDiretorios);
            estrutura.add(diretorioDTO);
        } else {
            estrutura.add(DiretorioDTO.builder().listaArquivos(Collections.singletonList(diretorio.getName())).build());
        }
        return estrutura;
    }

    public FilesService(DiretorioRepository diretorioRepository) {
        this.diretorioRepository = diretorioRepository;
    }

    public List<DiretorioDTO> trazerEstruturaDiretorioBanco() {
        List<Diretorio> allDiretorios = diretorioRepository.findAll();
        List<Diretorio> rootDiretorios = allDiretorios.stream()
                .filter(diretorio -> diretorio.getParent() == null)
                .collect(Collectors.toList());
        return rootDiretorios.stream()
                .map(DiretorioMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public DiretorioDTO salvar(DiretorioDTO diretorioDTO) {
        Diretorio diretorio = DiretorioMapper.mapToEntity(diretorioDTO);
        DiretorioDTO retorno = DiretorioMapper.mapToDTO(diretorioRepository.save(diretorio));
        retorno.setMessageRetorno("Diretório salvo com sucesso.");
        return retorno;
    }

    public DiretorioDTO atualizar(DiretorioDTO diretorioDTO) {
        Diretorio diretorio = DiretorioMapper.mapToEntity(diretorioDTO);
        DiretorioDTO retorno = DiretorioMapper.mapToDTO(diretorioRepository.save(diretorio));
        retorno.setMessageRetorno("Diretório atualizado com sucesso.");
        return retorno;
    }

    public DiretorioDTO deletar(Long idDiretorio) {
        Optional<Diretorio> diretorioOptional = diretorioRepository.findById(idDiretorio);
        if (diretorioOptional.isPresent()) {
            diretorioRepository.delete(diretorioOptional.get());
            return DiretorioDTO.builder().messageRetorno(idDiretorio + " excluído com sucesso.").build();
        } else {
            throw new RuntimeException("Diretorio com o id " + idDiretorio + " não encontrado.");
        }
    }
}
