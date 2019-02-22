package com.gmdiias.controle.clientes;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmdiias.basic.BasicController;

@RestController
@RequestMapping("api/cliente")
public class ClienteController extends BasicController<Cliente, ClienteRepository, ClienteService> {

	@RequestMapping(value = "/pdfreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> clienteReport(
			@RequestParam(value = "nome") Optional<String> nome,
			@RequestParam(value = "situacao") Optional<String> situacao,
			@RequestParam(value = "data") @DateTimeFormat(pattern = "dd/MM/yyyy") Optional<Date> data) throws IOException {
		
		ByteArrayInputStream bis = GeneratePdfReport.pdfClientes(service.findFilter(nome, data, situacao));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	@GetMapping(path = {"filtro"})
	public List<Cliente> filtro(
			@RequestParam(value = "nome") Optional<String> nome,
			@RequestParam(value = "situacao") Optional<String> situacao,
			@RequestParam(value = "data") @DateTimeFormat(pattern = "dd/MM/yyyy") Optional<Date> data
			) {
			return service.findFilter(nome, data, situacao);
	}
}
