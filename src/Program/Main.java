package Program;

import java.util.Locale;
import java.util.Scanner;

import entities.Atleta;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner std=new Scanner(System.in);
		System.out.printf("Qual a quantidade de atletas? ");
		int n=std.nextInt();
		Atleta[]atleta=new Atleta[n];
		
		
		for(int i=0;i<n;i++) {
			String sexo;
			double altura, peso;
			
			System.out.println("Digite os dados do atleta numero "+(i+1)+":");
			System.out.print("Nome: ");
			std.nextLine();
			String nome=std.nextLine();
			do {
				System.out.print("Sexo: ");
				sexo=std.nextLine();
				sexo=sexo.toUpperCase();
				if(!validaSexo(sexo))
					System.out.println("Erro! Entre com M ou F");
				}
			while(!validaSexo(sexo));
			
			do {
				System.out.print("Altura: ");
				altura=std.nextDouble();
				if(altura<=0)
					System.out.println("Valor invalido! Favor digitar um valor positivo:");
				}
				while(altura<=0);
			System.out.print("Peso: ");
			peso=std.nextDouble();
			atleta[i]=new Atleta(nome, peso, altura, sexo);
		}
		
		System.out.print(relatorio(atleta));
		
		
		std.close();
	}
	
	public static double pesoMedio(Atleta [] atleta) {
		double pesoMedio=0;
		for(int i=0;i<atleta.length;i++)
			pesoMedio+=atleta[i].getPeso();
		return pesoMedio/atleta.length;
	}
	
	public static String tallest(Atleta[]atleta) {
		String theTallest=atleta[0].getNome();
		int i=0;
		int j=i+1;
		while(i<atleta.length&&j<atleta.length)
			if(atleta[i].getAltura()<atleta[j].getAltura()){
				theTallest=atleta[j].getNome();
				i=j;
				j++;
			}
			else 
				j++;
		return theTallest;
	}
	
	public static double percentHomens(Atleta[]atleta) {
		int cont=0;
		for(int i=0;i<atleta.length;i++)
			if(atleta[i].getSexo().equals("M"))
				cont++;
		return ((double)cont/atleta.length)*100;
		
	}
	
		
	public static boolean validaSexo(String sexo) {
		return(sexo.equals("M")||sexo.equals("F"));
	}
	
	public static String alturaMediaMulheres(Atleta[]atleta) {
		double alturaMedia=0;
		int cont=0;
		for(int i=0;i<atleta.length;i++)
			if(atleta[i].getSexo().equals("F")) {
				alturaMedia+=atleta[i].getAltura();
				cont++;
			}
		if(alturaMedia==0)
			return "Não ha mulheres cadastradas";
		else {
			return "Altura Media das mulheres: "+String.format("%.2f",alturaMedia/cont);
		}
	}
	
	public static String relatorio(Atleta[]atleta) {
		return "RELATORIO\n"
				+"Peso medio dos atletas: "+String.format("%.2f",pesoMedio(atleta))+
				"\nAtleta mais alto: "+tallest(atleta)+"\n"+
				"Porcentagem de homens: "+String.format("%.1f",percentHomens(atleta))+"%\n"+
				alturaMediaMulheres(atleta)
				;
	}

}
