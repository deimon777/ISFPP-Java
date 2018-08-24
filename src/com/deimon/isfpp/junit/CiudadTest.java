package com.deimon.isfpp.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deimon.entidades.ciudad.Vertice;

@DisplayName("Ciudad Test")
class CiudadTest {

	static Vertice madryn;
	static Vertice trelew;
	static Vertice comodoro;
	static Vertice rawson;
	static Vertice piramides;
	
	@BeforeAll
    static void initAll() {
		madryn = new Vertice("Puerto Madryn");
		trelew = new Vertice("Trelew");
		comodoro = new Vertice("Comodoro Rivadavia");
		rawson = new Vertice("Rawson");
		piramides = new Vertice("Pto. Piramides");
    }

    @BeforeEach
    void init() {
    }

    @Test
    @DisplayName("Nombre Ciudades")
    void succeedingTest() {
        assertEquals("Puerto Madryn", madryn.getNombre());
    }

//    @Test
//    void failingTest() {
//        fail("a failing test");
//    }
//
//    @Test
//    @Disabled("for demonstration purposes")
//    void skippedTest() {
//        // not executed
//    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
