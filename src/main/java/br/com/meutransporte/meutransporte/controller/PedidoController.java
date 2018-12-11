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

import br.com.meutransporte.meutransporte.dao.PedidoDAO;
import br.com.meutransporte.meutransporte.model.Pedido;

@RestController
@RequestMapping
public class PedidoController {

	@Autowired
	private PedidoDAO pedidoDAO;

	@GetMapping(path = "pedido", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Pedido> getPedido() {
		List<Pedido> list = pedidoDAO.findAll();
		return list;
	}

	@GetMapping(path = "pedido/{nome}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Pedido getMotorista(@PathVariable("nome") String nome) {
		return pedidoDAO.findByNome(nome).get();
	}

	@PostMapping(path = "pedido", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public Pedido addMotorista(@RequestBody Pedido ped) {
		System.out.println("(Service Side) Creating pedido: " + ped.getNome());
		return pedidoDAO.save(ped);
	}

	@PutMapping(path = "pedido", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public Pedido updateMotorista(@RequestBody Pedido ped) {
		System.out.println("(Service Side) Editing pedido: " + ped.getNome());

		return pedidoDAO.save(ped);
	}

	@DeleteMapping(path = "pedido/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public void deleteMotorista(@PathVariable("id") Long id) {
		System.out.println("(Service Side) Deleting pedido: " + id);
		pedidoDAO.deleteById(id);
	}
}