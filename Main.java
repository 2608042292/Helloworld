public class Main {
    private double principal; // 贷款总额 (万元)
    private int months; // 贷款时间（月数）
    private double annualInterestRate; // 年利率（小数形式，例如5% 输入为0.05）

    // 构造函数
    public LoanCalculator(double principal, int months, double annualInterestRate) {
        this.principal = principal;
        this.months = months;
        this.annualInterestRate = annualInterestRate;
    }

    // 获取月利率
    private double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    // 计算等额本金还款方式的总利息
    public double calculateTotalInterestEqualPrincipal() {
        double monthlyInterestRate = getMonthlyInterestRate();
        return (months + 1) * principal * monthlyInterestRate / 2;
    }

    // 计算等额本息还款方式的总利息
    public double calculateTotalInterestEqualInstallment() {
        double monthlyInterestRate = getMonthlyInterestRate();
        double temp = Math.pow(1 + monthlyInterestRate, months);
        return months * principal * monthlyInterestRate * temp / (temp - 1) - principal;
    }

    // 根据还款方式计算总利息
    public double calculateTotalInterest(String repaymentMethod) {
        switch (repaymentMethod.toLowerCase()) {
            case "等额本金":
                return calculateTotalInterestEqualPrincipal();
            case "等额本息":
                return calculateTotalInterestEqualInstallment();
            default:
                throw new IllegalArgumentException("不支持的还款方式: " + repaymentMethod);
        }
    }

    public static void main(String[] args) {
// 假设贷款总额为100万，贷款时间为20年（240个月），年利率为5%
        LoanCalculator loanCalculator = new LoanCalculator(100, 240, 0.05);

// 计算等额本金还款方式的总利息
        double totalInterestEqualPrincipal = loanCalculator.calculateTotalInterest("等额本金");
        System.out.println("等额本金还款方式的总利息: " + totalInterestEqualPrincipal + " 万元");

// 计算等额本息还款方式的总利息
        double totalInterestEqualInstallment = loanCalculator.calculateTotalInterest("等额本息");
        System.out.println("等额本息还款方式的总利息: " + totalInterestEqualInstallment + " 万元");
    }
}