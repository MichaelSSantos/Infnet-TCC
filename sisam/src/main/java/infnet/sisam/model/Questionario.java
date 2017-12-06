package infnet.sisam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Questionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private List<GrupoQuestoes> gruposQuestoes = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<GrupoQuestoes> getGruposQuestoes() {
		return gruposQuestoes;
	}

	public void setGruposQuestoes(List<GrupoQuestoes> gruposQuestoes) {
		this.gruposQuestoes = gruposQuestoes;
	}

}
