import java.util.Scanner;

public class work2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // รับข้อมูลจากผู้ใช้
        System.out.print("ประเภทลูกค้า (silver/gold/platinum): ");
        String customerCategory = input.nextLine().trim();

        System.out.print("ยอดซื้อ: ");
        double amount = input.nextDouble();

        // คำนวณยอดเงินสุดท้ายหลังจากหักส่วนลด
        double finalPrice = myMethod(customerCategory, amount);

        // แสดงผลลัพธ์
        System.out.printf("ยอดเงินที่ต้องชำระหลังหักส่วนลด: %.2f%n", finalPrice);

        input.close();
    }

    public static double myMethod(String customerCategory, double amount) {
        double discountPercentage = getDiscountPercentage(customerCategory, amount);
        return amount - (amount * discountPercentage);
    }

    private static double getDiscountPercentage(String customerCategory, double amount) {
        switch (customerCategory.toLowerCase()) {
            case "silver":
                return (amount > 1000) ? 0.02 : 0.0;
            case "gold":
                return (amount > 1000) ? 0.03 : 0.0;
            case "platinum":
                return 0.05;
            default:
                return 0.0;
        }
    }
}