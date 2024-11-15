package test.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Insert {
    //Book 삽입
    public static void insertBook(Connection conn, Scanner scanner) {
        try {
            System.out.println("\n=== 도서 정보 입력 ===");
            System.out.print("도서 ID를 입력하세요: ");
            int bookid = Integer.parseInt(scanner.nextLine());

            System.out.print("도서명을 입력하세요: ");
            String bookname = scanner.nextLine();

            System.out.print("출판사를 입력하세요: ");
            String publisher = scanner.nextLine();

            System.out.print("가격을 입력하세요: ");
            int price = Integer.parseInt(scanner.nextLine());

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO Book (bookid, bookname, publisher, price) VALUES (" +
                    bookid + ", '" + bookname + "', '" + publisher + "', " + price + ")");
            System.out.println("도서가 성공적으로 등록되었습니다.");

        } catch (SQLException e) {
            System.out.println("도서 등록 중 오류가 발생했습니다: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("도서 ID와 가격은 숫자로 입력해주세요.");
        }
    }

    // Customer 삽입
    public static void insertCustomer(Connection conn, Scanner scanner) {
        try {
            System.out.println("\n=== 고객 정보 입력 ===");
            System.out.print("고객 ID를 입력하세요: ");
            int custid = Integer.parseInt(scanner.nextLine());

            System.out.print("고객명을 입력하세요: ");
            String name = scanner.nextLine();

            System.out.print("주소를 입력하세요: ");
            String address = scanner.nextLine();

            System.out.print("전화번호를 입력하세요: ");
            String phone = scanner.nextLine();

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO Customer (custid, name, address, phone) VALUES (" + custid + ", '" + name + "', '" + address + "', '" + phone + "')");
            System.out.println("고객이 성공적으로 등록되었습니다.");

        } catch (SQLException e) {
            System.out.println("고객 등록 중 오류가 발생했습니다: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("고객 ID는 숫자로 입력해주세요.");
        }
    }

    // Orders 삽입
    public static void insertOrder(Connection conn, Scanner scanner) {
        try {
            System.out.println("\n=== 주문 정보 입력 ===");
            System.out.print("주문 ID를 입력하세요: ");
            int orderid = Integer.parseInt(scanner.nextLine());

            System.out.print("고객 ID를 입력하세요: ");
            int custid = Integer.parseInt(scanner.nextLine());

            System.out.print("도서 ID를 입력하세요: ");
            int bookid = Integer.parseInt(scanner.nextLine());

            System.out.print("판매 가격을 입력하세요: ");
            int saleprice = Integer.parseInt(scanner.nextLine());

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT bookname FROM Book WHERE bookid = " + bookid);

            String bookname = "";
            if (rs.next()) {
                bookname = rs.getString("bookname");
            }

            stmt.executeUpdate("INSERT INTO Orders (orderid, custid, bookid, saleprice, orderdate, bookname) VALUES (" +
                    orderid + ", " + custid + ", " + bookid + ", " + saleprice + ", NOW(), '" + bookname + "')");
            System.out.println("주문이 성공적으로 등록되었습니다.");

        } catch (SQLException e) {
            System.out.println("주문 등록 중 오류가 발생했습니다: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("주문 ID, 고객 ID, 도서 ID, 판매 가격은 숫자로 입력해주세요.");
        }
    }

}
