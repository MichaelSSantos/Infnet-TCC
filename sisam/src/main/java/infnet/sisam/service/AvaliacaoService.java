package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.AvaliacaoDao;
import infnet.sisam.model.Aluno;
import infnet.sisam.model.Avaliacao;

@Service
@Transactional
public class AvaliacaoService {

	@Autowired
	private AvaliacaoDao avaliacaoDao;

	@Autowired
	private TurmaService turmaService;

	@Autowired
	private AlunoService alunoService;

	public List<Avaliacao> listar() {
		return avaliacaoDao.findAll();
	}

	public void salvar(Avaliacao avaliacao) {

		avaliacaoDao.salvar(avaliacao);

		avaliacao.getTurmas().forEach(turma -> {
			turma = turmaService.buscar(turma.getId());
			turma.setAvaliacao(avaliacao);
			turmaService.salvar(turma);

			List<Aluno> alunos = turma.getAlunos();
			for (Aluno aluno : alunos) {
				aluno.setTurma(turma);
				alunoService.getAlunoDao().salvar(aluno);
			}
		});

	}

	public Avaliacao buscar(Integer id) {
		return avaliacaoDao.buscar(id);
	}

	public void atualizar(Avaliacao avaliacao) {
		avaliacaoDao.atualizar(avaliacao);
	}

	public void remover(Integer id) {
		avaliacaoDao.excluir(avaliacaoDao.buscar(id));
	}

	public List<Avaliacao> buscaAvaliacaoPendente() {
		return avaliacaoDao.buscaAvaliacaoPendente();
	}

}
