package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println();
			System.out.printf("Digite os dados do %do contribuinte: \n", i+1);
			System.out.print("Renda anual com salário: ");
			Double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			Double servicesIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			Double capitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			Double healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			Double educationSpending = sc.nextDouble();
			
			TaxPayer taxPayer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
						
			list.add(taxPayer);
		}
		
		System.out.println();
		for (int i=0; i<n; i++) {
			System.out.println();
			
			System.out.printf("Resumo do %do contribuinte: \n", i+1);
			System.out.printf("Imposto Bruto Total: %.2f%n",list.get(i).grossTax());
	    	System.out.printf("Abatimento.........: %.2f%n",list.get(i).taxRebate());
	    	System.out.printf("Imposto Devido.....: %.2f%n",list.get(i).netTax());
		}
		sc.close();
	}
}