package br.com.manegerfiles.controller;


import br.com.manegerfiles.dto.DiretorioDTO;
import br.com.manegerfiles.service.FilesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FilesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilesService service;

    @Test
    public void testTrazerEstruturaDiretorioBanco() throws Exception {
        DiretorioDTO diretorioDTO = new DiretorioDTO();
        diretorioDTO.setNomeDiretorio("pasta_raiz");

        when(service.trazerEstruturaDiretorioBanco()).thenReturn(Collections.singletonList(diretorioDTO));

        mockMvc.perform(get("/diretorio/banco-dados")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testTrazerEstruturaDiretorioStorageServidor() throws Exception {
        DiretorioDTO diretorioDTO = new DiretorioDTO();
        diretorioDTO.setNomeDiretorio("pasta_raiz");

        when(service.trazerEstruturaDiretorioStorageServidor()).thenReturn(Collections.singletonList(diretorioDTO));

        mockMvc.perform(get("/diretorio/storage-servidor")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testSalvar() throws Exception {
        DiretorioDTO diretorioDTO = new DiretorioDTO();
        diretorioDTO.setNomeDiretorio("pasta_raiz");

        when(service.salvar(diretorioDTO)).thenReturn(diretorioDTO);

        mockMvc.perform(post("/diretorio")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nomeDiretorio\":\"pasta_raiz\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAtualizar() throws Exception {
        DiretorioDTO diretorioDTO = new DiretorioDTO();
        diretorioDTO.setNomeDiretorio("pasta_raiz");

        when(service.atualizar(diretorioDTO)).thenReturn(diretorioDTO);

        mockMvc.perform(put("/diretorio")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nomeDiretorio\":\"pasta_raiz\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeletarEstruturaDiretorioStorageServidor() throws Exception {
        Long idDiretorio = 1L;
        DiretorioDTO diretorioDTO = new DiretorioDTO();
        diretorioDTO.setNomeDiretorio("pasta_raiz");

        when(service.deletar(idDiretorio)).thenReturn(diretorioDTO);

        mockMvc.perform(MockMvcRequestBuilders.delete("/diretorio/" + idDiretorio)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(service, times(1)).deletar(idDiretorio);
    }


}
