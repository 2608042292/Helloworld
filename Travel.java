public class Travel {
    public static void main(String[] args) {
        TravelMethod travelMethod = new SelfDrivingTravel(7, 1); // 小轿车自驾7天游
        travelMethod.showTravelInfo();
        System.out.println("旅行费用：" + travelMethod.calculatePrice() + "元");
    }
}

abstract class TravelMethod {
    protected int days;

    public TravelMethod(int days) {
        this.days = days;
    }

    public abstract void showTravelInfo();
    public abstract double calculatePrice();
}

class SelfDrivingTravel extends TravelMethod {
    private int carType; // 自驾车型

    public SelfDrivingTravel(int days, int carType) {
        super(days);
        this.carType = carType;
    }

    public void showTravelInfo() {
        System.out.println("出行方式：自驾游");
        System.out.println("出行天数：" + days);
        System.out.println("车型：" + (carType == 1 ? "小轿车" : "越野车"));
    }

    public double calculatePrice() {
        double basePrice = carType == 1 ? 500.0 : 800.0;
        double pricePerDay = carType == 1 ? 50.0 : 80.0;
        return basePrice + days * pricePerDay;
    }
}