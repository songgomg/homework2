import java.util.Scanner;

public class work2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // รับประเภทของลูกค้า
        System.out.print("กรุณาใส่ประเภทลูกค้า (silver/gold/platinum): ");
        String customerCategory = input.nextLine();

        // รับยอดเงินการซื้อ
        System.out.print("กรุณาใส่จำนวนเงินที่ใช้ซื้อ: ");
        double totalAmount = input.nextDouble();

        // คำนวณยอดเงินหลังจากหักส่วนลด
        double discountedAmount = applyDiscount(customerCategory, totalAmount);

        // แสดงยอดเงินสุดท้ายหลังจากหักส่วนลด
        System.out.printf("จำนวนเงินสุดท้ายหลังจากหักส่วนลด: %.2f%n", discountedAmount);

        input.close();
    }

    public static double applyDiscount(String customerCategory, double totalAmount) {
        double discountRate;

        // กำหนดอัตราส่วนลดตามประเภทของลูกค้า
        switch (customerCategory.toLowerCase()) {
            case "silver":
                discountRate = (totalAmount > 1000) ? 0.02 : 0.0;
                break;
            case "gold":
                discountRate = (totalAmount > 1000) ? 0.03 : 0.0;
                break;
            case "platinum":
                discountRate = 0.05;
                break;
            default:
                discountRate = 0.0;
                break;
        }

        // คำนวณยอดเงินสุดท้าย
        return totalAmount * (1 - discountRate);
    }
}