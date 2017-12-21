package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.AlunoAvaliacaoDao;
import infnet.sisam.dao.UsuarioDao;
import infnet.sisam.model.AlunoAvaliacao;
import infnet.sisam.model.Usuario;

@Service
@Transactional
public class AlunoAvaliacaoService {

	@Autowired
	private AlunoAvaliacaoDao alunoAvaliacaoDao;
	/*@Autowired
	private UsuarioDao usuarioDao;*/

	public List<AlunoAvaliacao> listar() {
		return alunoAvaliacaoDao.findAll();
	}

	public void salvar(AlunoAvaliacao alunoAvaliacao) {
		alunoAvaliacaoDao.salvar(alunoAvaliacao);
	}

	public AlunoAvaliacao buscar(Integer id) {
		return alunoAvaliacaoDao.buscar(id);
	}

	public void atualizar(AlunoAvaliacao alunoAvaliacao) {
		alunoAvaliacaoDao.atualizar(alunoAvaliacao);
	}

	public void finalizarAlunoAvaliacao(AlunoAvaliacao alunoAvaliacao) {
		alunoAvaliacao.setAvaliacaoRespondida(true);
		alunoAvaliacaoDao.atualizar(alunoAvaliacao);
//		Usuario usuario = usuarioDao.buscaUsuarioPorEmail(alunoAvaliacao.getAluno().getEmail()).get(0);
//		usuarioDao.excluir(usuario);
	}

	public void remover(Integer id) {
		alunoAvaliacaoDao.excluir(alunoAvaliacaoDao.buscar(id));
	}

	public AlunoAvaliacaoDao getAlunoAvaliacaoDao() {
		return alunoAvaliacaoDao;
	}

	public void setAlunoAvaliacaoDao(AlunoAvaliacaoDao alunoAvaliacaoDao) {
		this.alunoAvaliacaoDao = alunoAvaliacaoDao;
	}

}
