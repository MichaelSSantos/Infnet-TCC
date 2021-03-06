package infnet.sisam.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "turma")
public class Turma {

	@Id
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat
	@Column(name = "data_inicio")
	private Calendar dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat
	@Column(name = "data_fim")
	private Calendar dataFim;

	private String descricao;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Professor professor;

	@OneToMany(mappedBy = "turma", fetch=FetchType.EAGER)
	private List<Aluno> alunos;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Modulo modulo;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Avaliacao avaliacao;

	public Turma() {

	}

	public Turma(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

}
