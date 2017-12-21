package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.UsuarioDao;
import infnet.sisam.model.Usuario;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void salvar(Usuario usuario) {
		codificarPassword(usuario);
		usuarioDao.salvar(usuario);
	}

	public List<Usuario> listar() {
		return usuarioDao.findAll();
	}

	public void atualizar(Usuario usuario, String oldPassword) {

		// TODO MARRETA
		oldPassword = oldPassword.substring(1);

		if (!oldPassword.equals(usuario.getSenha())) {
			codificarPassword(usuario);
		}
		atualizar(usuario);
	}

	public void atualizar(Usuario usuario) {
		codificarPassword(usuario);
		usuarioDao.atualizar(usuario);
	}

	public Usuario loadUserByUsername(String email) {
		List<Usuario> usus = usuarioDao.buscaUsuarioPorEmail(email);
		if (usus.isEmpty()) {
			return null;
		} else {
			return usus.get(0);
		}
	}

	public Usuario buscar(Integer id) {
		return usuarioDao.buscar(id);
	}

	public void remover(Integer id) {
		usuarioDao.excluir(usuarioDao.buscar(id));
	}

//	public Usuario criarUsuarioParaAvaliacao(Aluno aluno) {
//		
//		Usuario usuario = loadUserByUsername(aluno.getEmail());
//		Permissao permissao = permissaoService.buscar(3);
//		
//		int senha = new Random().nextInt(9999999);
//		 
//		if (usuario != null) {
//			usuario.setSenha(String.valueOf(senha));
//			codificarPassword(usuario);
//			atualizarUsuario(usuario);
//		} else {
//			usuario = new Usuario();
//			usuario.setEmail(aluno.getEmail());
//			usuario.setNome(aluno.getNome());
//			usuario.setPermissao(permissao);
//			usuario.setSenha(String.valueOf(senha));
//			codificarPassword(usuario);
//			salvar(usuario);
//		}
//		usuario.setSenha(String.valueOf(senha));
//		
//		return usuario;
//	}

	private void codificarPassword(Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
	}

}
