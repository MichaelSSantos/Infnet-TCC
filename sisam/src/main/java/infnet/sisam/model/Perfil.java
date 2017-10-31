package infnet.sisam.model;

public enum Perfil {

	ADMINISTRADOR(1, "Administrador"), SECRETARIA(2, "Secretaria");

	private Integer id;
	private String descricao;

	private Perfil(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

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

}
