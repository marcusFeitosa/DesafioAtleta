package entities;

public class Atleta {
	private String nome;
	private double peso;
	private double altura;
	private String sexo;
	
	public Atleta(String nome, double peso, double altura, String sexo) {
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
		this.sexo = sexo;
	}
	
	public Atleta() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
