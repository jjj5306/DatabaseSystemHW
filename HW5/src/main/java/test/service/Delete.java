package test.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
    // Book 삭제
    public static void deleteBook(Connection conn, Scanner scanner) {
        try {
            System.out.println("\n=== 도서 삭제 ===");
            System.out.print("삭제할 도서 ID를 입력하세요: ");
            int bookid = Integer.parseInt(scanner.nextLine());

            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate("DELETE FROM Book WHERE bookid = " + bookid);

            if (result > 0) {
                System.out.println("도서가 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("해당 ID의 도서를 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("삭제 중 오류가 발생했습니다.");
        }
    }

    // Customer 삭제
    public static void deleteCustomer(Connection conn, Scanner scanner) {
        try {
            System.out.println("\n=== 고객 삭제 ===");
            System.out.print("삭제할 고객 ID를 입력하세요: ");
            int custid = Integer.parseInt(scanner.nextLine());

            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate("DELETE FROM Customer WHERE custid = " + custid);

            if (result > 0) {
                System.out.println("고객이 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("해당 ID의 고객을 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("삭제 중 오류가 발생했습니다.");
        }
    }

    // Orders 삭제
    public static void deleteOrder(Connection conn, Scanner scanner) {
        try {
            System.out.println("\n=== 주문 삭제 ===");
            System.out.print("삭제할 주문 ID를 입력하세요: ");
            int orderid = Integer.parseInt(scanner.nextLine());

            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate("DELETE FROM Orders WHERE orderid = " + orderid);

            if (result > 0) {
                System.out.println("주문이 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("해당 ID의 주문을 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("삭제 중 오류가 발생했습니다.");
        }
    }
}