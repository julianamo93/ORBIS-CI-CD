package com.example.orbis_gs.controller;

import com.example.orbis_gs.OrbisGsApplication;
import com.example.orbis_gs.dto.UsuarioDTO;
import com.example.orbis_gs.producer.UsuarioProducer;
import com.example.orbis_gs.service.UsuarioService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {OrbisGsApplication.class, UsuarioServiceIntegrationTest.TestConfig.class})
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioServiceIntegrationTest {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioProducer usuarioProducer; // mockado

    @Test
    void createUsuario_deveChamarProducerComDadosCorretos() {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setEmail("teste@example.com");
        dto.setNome("Integration");
        dto.setSobrenome("Test");
        dto.setSenha("123456");
        dto.setCep("87654321");

        service.createUsuario(dto);

        Mockito.verify(usuarioProducer, Mockito.times(1))
                .enviarLogCadastro(Mockito.any(UsuarioDTO.class));
    }

    @TestConfiguration
    static class TestConfig {

        @Bean
        public UsuarioProducer usuarioProducer() {
            return Mockito.mock(UsuarioProducer.class);
        }
    }
}
