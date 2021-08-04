package ar.com.ada.api.aladas;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.ada.api.aladas.entities.Aeropuerto;
import ar.com.ada.api.aladas.entities.Vuelo;
import ar.com.ada.api.aladas.services.AeropuertoService;
import ar.com.ada.api.aladas.services.VueloService;

@SpringBootTest
class AladasApplicationTests {

	@Autowired
	VueloService vueloService;

	@Autowired
	AeropuertoService aeropuertoService;

	@Test
	void vueloTestPrecioNegativo() {

		Vuelo vueloConPrecioNegativo = new Vuelo();
		vueloConPrecioNegativo.setPrecio(new BigDecimal(-100));

		assertFalse(vueloService.validarPrecio(vueloConPrecioNegativo));
		// assertrue = afirmar que es verdadero
		// assertFalse = afirmar que no funciona

	}

	@Test
	void vueloTestPrecioOk() {

		Vuelo vueloConPrecioOk = new Vuelo();
		vueloConPrecioOk.setPrecio(new BigDecimal(100));

		assertTrue(vueloService.validarPrecio(vueloConPrecioOk));
		// assertrue = afirmar que es verdadero
		// assertFalse = afirmar que no funciona

	}

	@Test
	void aeropuertoValidarCodigoIATANoOk(){


		String codigoIATAOk1 = "EZE";
		String codigoIATAOk2 = "AEP";
		String codigoIATAOk3 = "NQN";
		String codigoIATAOk4 = "N  ";
		String codigoIATAOk5 = "N93";

		/*//Aca afirmo que espero que el leght del coso sea 3
		assertEquals(3, codigoIATAOk1.length());
		//Aca afirmo que espero que el resultado de la condicion
		//sea verdadera (en este caso leght() == 3)
		assertTrue(codigoIATAOk2.length() == 3);*/

		Aeropuerto aeropuerto1 = new Aeropuerto();
		aeropuerto1.setCodigoIATA(codigoIATAOk1);

		Aeropuerto aeropuerto2 = new Aeropuerto();
		aeropuerto2.setCodigoIATA(codigoIATAOk2);

		Aeropuerto aeropuerto3 = new Aeropuerto();
		aeropuerto3.setCodigoIATA(codigoIATAOk3);

		Aeropuerto aeropuerto4 = new Aeropuerto();
		aeropuerto4.setCodigoIATA(codigoIATAOk4);


		assertTrue(aeropuertoService.ValidarCodigoIATA(aeropuerto1));
		assertTrue(aeropuertoService.ValidarCodigoIATA(aeropuerto2));
		assertTrue(aeropuertoService.ValidarCodigoIATA(aeropuerto3));

		assertFalse(aeropuertoService.ValidarCodigoIATA(aeropuerto4));
		

	}

	@Test
	void aeropuertoValidarCodigoIATAOk(){

	}

	@Test
	void vueloVerificarValidacionAeropuertoOrigenDestino(){

	}

	@Test
	void chequearCapacidadQueLosPendientesNoTenganVuelosViejos(){
		// cuando se quieran hacer reservas de vuelo actuales no aparezcan viejos
	}

	@Test
	void  aeropuertoTestBuscadorIATA(){

	}

	@Test
	void vueloVerificarCapacidadMinima(){

	}

	@Test
	void vueloVerificarCapacidadMaxima(){
		
	}

	 


}
