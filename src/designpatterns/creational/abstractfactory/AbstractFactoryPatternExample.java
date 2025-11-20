package designpatterns.creational.abstractfactory;

public class AbstractFactoryPatternExample {
    public static void main(String[] args) {
        String loanName = "Home";
        double loanAmount = 7000000;
        int years = 10;
        AbstractFactory loanFactory = FactoryCreator.getFactory("Loan");
        Loan loan = loanFactory.getLoan(loanName);
        loan.getInterestRate(10);
        loan.calculateLoanPayment(loanAmount, years);
    }
}
