package br.com.fiap.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.dao.UsuarioRepository;
import br.com.fiap.dto.UsuarioDTO;
import br.com.fiap.entity.UsuarioEntity;



@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	
	public UsuarioDTO saveUsuario(UsuarioDTO usuario) {
		if (!isValidEmail(usuario.getEmail())) {
			throw new IllegalArgumentException("O email fornecido é inválido.");
		}
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioRepository.save(usuarioEntity);
		return usuario;
	}
	
	private boolean isValidEmail(String email) {
		if (email == null || email.isEmpty()) {
            return false; 
        }
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public List<UsuarioDTO> getAllUsuario(){
		return usuarioRepository.findAll().stream().map(entity -> new UsuarioDTO(entity)).toList();
	}
	
	public List<UsuarioDTO> getAllUsuarioId(Long id){
		return usuarioRepository.findAll().stream().map(entity -> new UsuarioDTO(entity)).toList();
	}
	
	public UsuarioDTO findById(Long id) {
		Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(id);
		 if(usuarioEntity.isPresent()) {
			 return new UsuarioDTO(usuarioEntity.get());
		 } 
		 return null;
	}
	
	public UsuarioDTO updateUsuario(UsuarioDTO newUsuario, Long id) {
		Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findById(id);
		if(usuarioEntityOptional.isPresent()) {
			UsuarioEntity usuarioEntity = usuarioEntityOptional.get();
			usuarioEntity.setId(newUsuario.getId());
			usuarioEntity.setNome(newUsuario.getNome());
			usuarioEntity.setEmail(newUsuario.getEmail());
			usuarioRepository.save(usuarioEntity);
			return newUsuario;
		}
		return null;
		
	}
	
	public UsuarioDTO deleteUsuario(Long id) {
		Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findById(id);
		if(usuarioEntityOptional.isPresent()) {
			UsuarioEntity usuarioEntity = usuarioEntityOptional.get();
			usuarioRepository.delete(usuarioEntity);
			return new UsuarioDTO(usuarioEntity);
		}
		return null;
	}
	
	

}
