package br.com.manegerfiles.service;

import br.com.manegerfiles.dto.DiretorioDTO;
import br.com.manegerfiles.model.Diretorio;
import br.com.manegerfiles.repository.DiretorioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FilesServiceTest {

    @InjectMocks
    private FilesService service;

    @Mock
    private DiretorioRepository repository;


    @Test
    public void testTrazerEstruturaDiretorioBanco() {
        Diretorio diretorio = new Diretorio();
        diretorio.setNome("pasta_raiz");
        diretorio.setSubDiretorios(new ArrayList<>());
        diretorio.setListaArquivos(new ArrayList<>());
        when(repository.findAll()).thenReturn(Collections.singletonList(diretorio));

        List<DiretorioDTO> result = service.trazerEstruturaDiretorioBanco();

        assertEquals(1, result.size());
        assertEquals("pasta_raiz", result.get(0).getNomeDiretorio());
    }

    @Test
    public void testTrazerEstruturaDiretorioStorageServidor() {
        Diretorio diretorio = new Diretorio();
        diretorio.setNome("pasta_raiz");
        when(repository.findAll()).thenReturn(Collections.singletonList(diretorio));

        ReflectionTestUtils.setField(service, "directoryPath", "/path/to/directory");

        List<DiretorioDTO> result = service.trazerEstruturaDiretorioStorageServidor();

        assertEquals(1, result.size());
    }

    @Test
    public void testDeletar() {
        Diretorio diretorio = new Diretorio();
        diretorio.setId(1L);
        diretorio.setNome("pasta_raiz");
        when(repository.findById(any(Long.class))).thenReturn(Optional.of(diretorio));

        DiretorioDTO result = service.deletar(1L);

        assertEquals("1 excluído com sucesso.", result.getMessageRetorno());
    }
}
