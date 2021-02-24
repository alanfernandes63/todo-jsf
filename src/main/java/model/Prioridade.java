package model;

public enum Prioridade {

	ALTA("Alta"), MEDIA("Média"), BAIXA("Baixa");

	private String label;

	private Prioridade(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

}
