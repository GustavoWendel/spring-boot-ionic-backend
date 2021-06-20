package com.gustavowendel.cursomc.domain.enums;

public enum EstadoPagamento {
	PENDENTE(1, "PENDENTE"), QUITADO(2, "QUITADO"), CANCELADO(3, "CANCELADO");

	private int cod;
	private String descricao;

	EstadoPagamento(int cod, String descricao) {
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EstadoPagamento toEnum(Integer id) {
		if (id == null) {
			return null;
		}

		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido" + id);
	}

}
