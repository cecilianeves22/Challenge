package br.com.fiap.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dto.UsuarioDTO;
import br.com.fiap.service.UsuarioService;



@RestController 
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
//	private List<UsuarioDTO> usuarioList = new ArrayList<>();
	
//	@PostConstruct
//	private void postConstruct() {
//		UsuarioDTO user = new UsuarioDTO(1,"cecilia","cecilia@gmail.com");
//		usuarioList.add(user);
//		
//	}
	
	@GetMapping("/usuarios")
	ResponseEntity<List<UsuarioDTO>> all() {
		return ResponseEntity.ok(usuarioService.getAllUsuario());
	}
	
	@GetMapping("/usuarios/{id}")
	ResponseEntity<List<UsuarioDTO>> all(@PathVariable Long id) {
		return ResponseEntity.ok(usuarioService.getAllUsuarioId(id));
	}
	
	@PostMapping("/cadastroUsuarios")
	public ResponseEntity<UsuarioDTO> newUsuario(@RequestBody UsuarioDTO newUsuario) {
		usuarioService.saveUsuario(newUsuario);
		return ResponseEntity.ok(newUsuario);
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<UsuarioDTO> replaceEmployee(@RequestBody UsuarioDTO newUsuario, @PathVariable Long id) {
		UsuarioDTO usuarioUpdated = usuarioService.updateUsuario(newUsuario,id);
		return ResponseEntity.ofNullable(usuarioUpdated);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<UsuarioDTO> deleteEmployee(@PathVariable Long id) {
		return ResponseEntity.ofNullable(usuarioService.deleteUsuario(id));
	}
	

}
