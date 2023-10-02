package com.imd.web.swaptales.enums;

public enum StatusOrder {
	EM_ANDAMENTO("A caminho"), FINALIZADA("Entrege"), CANCELADA("Cancelada"), AGUARDANDO_PAGAMENTO("Aguardando pagamento");
	
	private String descricao;

	StatusOrder(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
