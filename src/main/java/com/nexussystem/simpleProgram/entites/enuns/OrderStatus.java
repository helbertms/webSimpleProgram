package com.nexussystem.simpleProgram.entites.enuns;

public enum OrderStatus {
	
	Aguardando_Pagamento(1),
	Pago(2),
	Enviado(3),
	Entregue(4),
	Cancelado(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Error OrderStatus in enuns");
	}
}
	
