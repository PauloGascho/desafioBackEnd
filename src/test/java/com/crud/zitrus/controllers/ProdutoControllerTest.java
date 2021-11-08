package com.crud.zitrus.controllers;

import com.crud.zitrus.models.Produto;
import com.crud.zitrus.repositories.ProdutoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.Mockito.when;

@WebMvcTest
public class ProdutoControllerTest {
    static final String BASE_URL = "/produtos";

    @Autowired
    private ProdutoController produtoController;

    @MockBean
    private ProdutoRepository produtoRepository;

    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(this.produtoController);
    }

    @Test
    public void detalharProduto_200() {

        UUID produtoId = UUID.fromString("e3c4dea1-72b7-4e9b-b5bb-e9582fcece74");
        Produto produto = this.criaProduto();

        when(this.produtoRepository.findById(produtoId)).thenReturn(java.util.Optional.ofNullable(produto));

        RestAssuredMockMvc.given().contentType(ContentType.JSON)
                .when().get(BASE_URL+"/{produtoId}","e3c4dea1-72b7-4e9b-b5bb-e9582fcece74")
                .then().statusCode(HttpStatus.OK.value());
    }

    @Test
    public void detalharProduto_404() {
        UUID outroProdutoId = UUID.fromString("a8e634d2-a29f-4cb1-a8d6-ec35ed70d41f");
        when(this.produtoRepository.findById(outroProdutoId)).thenReturn(null);

        RestAssuredMockMvc.given().contentType(ContentType.JSON)
                .when().get(BASE_URL+"/{produtoId}","a8e634d2-a29f-4cb1-a8d6-ec35ed70d41f")
                .then().statusCode(HttpStatus.NOT_FOUND.value());
    }

    public Produto criaProduto() {
        return new Produto(
                UUID.fromString("e3c4dea1-72b7-4e9b-b5bb-e9582fcece74"),
                "codigo",
                "descrição",
                "tipo",
                BigDecimal.valueOf(10),
                BigDecimal.valueOf(1)
        );
    }
}
