package com.pralineso.cursomc.domain.enums;

public enum Perfil {

	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");
	
	private int cod;
	private String descricao;

	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Perfil toEnum(Integer cod) {

		//refica se é nulo, se for volta nulo
		if(cod == null) {
			return null;
		}

		//varre os tipos, quado acha retorna o tipo
		for(Perfil x : Perfil.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}

		//se percorreu e nao achou nada, dispara a excecao
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}
}
