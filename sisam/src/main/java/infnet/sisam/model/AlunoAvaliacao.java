package infnet.sisam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private Boolean avaliacao_respondida;

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

	public Boolean getAvaliacao_respondida() {
		return avaliacao_respondida;
	}

	public void setAvaliacao_respondida(Boolean avaliacao_respondida) {
		this.avaliacao_respondida = avaliacao_respondida;
	}

}
