package com.pralineso.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pralineso.cursomc.domain.Categoria;
import com.pralineso.cursomc.dto.CategoriaDTO;
import com.pralineso.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@Autowired //instacia automaticamente
	private CategoriaService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);//pega o q vir no ?? e joga como corpo da pagina
	}

	//metood para inserir no banco
	@RequestMapping(method=RequestMethod.POST )
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){ // @Req pra converter o json para obj java auto
		obj = service.insert(obj);
		//pega uri do novo recurso inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).build();

	}

	//mwtodo para atualizar
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	//mwtodo para deletar
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	//metodo para listar
	@RequestMapping(method=RequestMethod.GET)
	//lista de categoriadto pra retorna so a "parte principal da categoria"(sem os produtos vinculados)
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = service.findAll();
		//converte a list pra dto
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
