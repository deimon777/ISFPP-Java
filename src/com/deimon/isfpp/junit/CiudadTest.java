package com.deimon.isfpp.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.deimon.ciudad.Ciudad;

@DisplayName("Ciudad Test")
class CiudadTest {

	static Ciudad madryn;
	static Ciudad trelew;
	static Ciudad comodoro;
	static Ciudad rawson;
	static Ciudad piramides;
	
	@BeforeAll
    static void initAll() {
		madryn = new Ciudad("Puerto Madryn");
		trelew = new Ciudad("Trelew");
		comodoro = new Ciudad("Comodoro Rivadavia");
		rawson = new Ciudad("Rawson");
		piramides = new Ciudad("Pto. Piramides");
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
