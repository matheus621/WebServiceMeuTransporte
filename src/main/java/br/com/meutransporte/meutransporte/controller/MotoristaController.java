package br.com.meutransporte.meutransporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meutransporte.meutransporte.dao.MotoristaDAO;
import br.com.meutransporte.meutransporte.model.Motorista;

@RestController
@RequestMapping
public class MotoristaController {

	@Autowired
	private MotoristaDAO motoristaDAO;

	@GetMapping(path = "motorista", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Motorista> getMotorista() {
		List<Motorista> list = motoristaDAO.findAll();
		return list;
	}

	@GetMapping(path = "motorista/{nome}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Motorista getMotorista(@PathVariable("nome") String nome) {
		return motoristaDAO.findByNome(nome).get();
	}

	@PostMapping(path = "motorista", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public Motorista addMotorista(@RequestBody Motorista mot) {
		System.out.println("(Service Side) Creating motorista: " + mot.getNome());
		return motoristaDAO.save(mot);
	}

	@PutMapping(path = "motorista", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public Motorista updateMotorista(@RequestBody Motorista mot) {
		System.out.println("(Service Side) Editing motorista: " + mot.getNome());

		return motoristaDAO.save(mot);
	}

	@DeleteMapping(path = "motorista/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public void deleteMotorista(@PathVariable("id") Long id) {
		System.out.println("(Service Side) Deleting motorista: " + id);
		motoristaDAO.deleteById(id);
	}
}