package com.pralineso.cursomc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa  Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer cod) {
		
		//refica se é nulo, se for volta nulo
		if(cod == null) {
			return null;
		}
		
		//varre os tipos, quado acha retorna o tipo
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		//se percorreu e nao achou nada, dispara a excecao
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}
	
	
}
