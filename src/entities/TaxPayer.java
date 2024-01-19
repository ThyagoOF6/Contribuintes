package entities;

public class TaxPayer {
	
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;
	
	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	public double salaryTax() {
		double salary = salaryIncome / 12.0;
		double percentagem = 0;
		
		if (salary < 3000.00) {
			percentagem = 0.00;
		} else if (salary <= 5000.00) {
			percentagem = 0.1;
		} else {
			percentagem = 0.2;
		}
		return 12 * (salary * percentagem);
	}
	
	public double servicesTax() {
		return servicesIncome * 0.15;
	}
	
	public double capitalTax() {
		return capitalIncome * 0.2;
	}
	
	public double grossTax() {
		double grossTax = salaryTax() + servicesTax() + capitalTax();
		return grossTax;
	}
	
	public double taxRebate() {
		
		double deductibleExpense = healthSpending + educationSpending;

		double maximumDeductible = grossTax() * 0.3;
		
		double rebates = 0;

		if (deductibleExpense > maximumDeductible) {
			rebates = maximumDeductible;
		} else {
			rebates = deductibleExpense;
		}
		return rebates;
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}
}