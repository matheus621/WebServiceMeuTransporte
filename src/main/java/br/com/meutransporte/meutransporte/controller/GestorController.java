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

import br.com.meutransporte.meutransporte.dao.GestorDAO;
import br.com.meutransporte.meutransporte.model.Gestor;




@RestController
@RequestMapping
public class GestorController {

	@Autowired
	private GestorDAO gestorDAO;

	@GetMapping(path = "gestor", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Gestor> getGestor() {
		List<Gestor> list = gestorDAO.findAll();
		return list;
	}

	@GetMapping(path = "gestor/{nome}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Gestor getGestor(@PathVariable("nome") String nome) {
		return gestorDAO.findByNome(nome).get();
	}

	@PostMapping(path = "gestor", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public Gestor addGestor(@RequestBody Gestor ges) {
		System.out.println("(Service Side) Creating gestor: " + ges.getNome());
		return gestorDAO.save(ges);
	}

	@PutMapping(path = "gestor", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public Gestor updateGestor(@RequestBody Gestor ges) {
		System.out.println("(Service Side) Editing motorista: " + ges.getNome());

		return gestorDAO.save(ges);
	}

	@DeleteMapping(path = "gestor/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public void deleteGestor(@PathVariable("id") Long id) {
		System.out.println("(Service Side) Deleting gestor: " + id);
		gestorDAO.deleteById(id);
	}
}