package com.pralineso.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");

	private int cod;
	private String descricao;

	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EstadoPagamento toEnum(Integer cod) {

		//refica se é nulo, se for volta nulo
		if(cod == null) {
			return null;
		}

		//varre os tipos, quado acha retorna o tipo
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}

		//se percorreu e nao achou nada, dispara a excecao
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}
}
