package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.QuestionarioDao;
import infnet.sisam.model.Questionario;

@Service
@Transactional
public class QuestionarioService {

	@Autowired
	private QuestionarioDao  questionarioDao;
	
	public void salvar(Questionario questionario) {
		questionarioDao.salvar(questionario);
	}

	public List<Questionario> lista() {
		return questionarioDao.findAll();
	}

	public void remover(Integer id) {
		questionarioDao.excluir(questionarioDao.buscar(id));
	}

	public Questionario buscar(Integer id) {
		return questionarioDao.buscar(id);
	}
	
	public Questionario buscarPorId(Integer id) {
		return questionarioDao.buscarPorId(id);
	}
	
	public void atualizar(Questionario questionario) {
		questionarioDao.atualizar(questionario);
	}
	
	
	
}
