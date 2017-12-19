package infnet.sisam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "AlunoAvaliacao.buscaAlunoAvaliacao", query = "SELECT aa FROM AlunoAvaliacao aa "
		+ "WHERE  aa.avaliacao.id=:idAvaliacao AND aa.aluno.id=:idAluno")
@Entity
@Table(name = "aluno_avaliacao")
public class AlunoAvaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Avaliacao avaliacao;

	@ManyToOne
	private Aluno aluno;

	@Column(name = "avaliacao_respondida")
	private Boolean avaliacaoRespondida;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Boolean getAvaliacaoRespondida() {
		return avaliacaoRespondida;
	}

	public void setAvaliacaoRespondida(Boolean avaliacao_respondida) {
		this.avaliacaoRespondida = avaliacao_respondida;
	}

}
