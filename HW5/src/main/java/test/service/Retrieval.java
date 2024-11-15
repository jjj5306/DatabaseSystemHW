package test.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Retrieval {
    // Book 검색
    public static void searchBook(Connection conn, Scanner scanner) {
        try {
            System.out.println("\n=== 도서 검색 ===");
            System.out.print("검색할 도서명을 입력하세요: ");
            String searchName = scanner.nextLine();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Book WHERE bookname LIKE '%" + searchName + "%'");

            System.out.println("\n검색 결과:");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("도서ID: " + rs.getInt("bookid"));
                System.out.println("도서명: " + rs.getString("bookname"));
                System.out.println("출판사: " + rs.getString("publisher"));
                System.out.println("가격: " + rs.getInt("price"));
                System.out.println("------------------------");
            }

            if (!found) {
                System.out.println("검색 결과가 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("검색 중 오류가 발생했습니다.");
        }
    }

    // Customer 검색
    public static void searchCustomer(Connection conn, Scanner scanner) {
        try {
            System.out.println("\n=== 고객 검색 ===");
            System.out.print("검색할 고객명을 입력하세요: ");
            String searchName = scanner.nextLine();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customer WHERE name LIKE '%" + searchName + "%'");

            System.out.println("\n검색 결과:");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("고객ID: " + rs.getInt("custid"));
                System.out.println("고객명: " + rs.getString("name"));
                System.out.println("주소: " + rs.getString("address"));
                System.out.println("전화번호: " + rs.getString("phone"));
                System.out.println("------------------------");
            }

            if (!found) {
                System.out.println("검색 결과가 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("검색 중 오류가 발생했습니다.");
        }
    }

    // Orders 검색
    public static void searchOrder(Connection conn, Scanner scanner) {
        try {
            System.out.println("\n=== 주문 검색 ===");
            System.out.print("검색할 도서명을 입력하세요: ");
            String searchName = scanner.nextLine();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT o.*, c.name as customer_name FROM Orders o " +
                    "JOIN Customer c ON o.custid = c.custid " +
                    "WHERE o.bookname LIKE '%" + searchName + "%'");

            System.out.println("\n검색 결과:");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("주문ID: " + rs.getInt("orderid"));
                System.out.println("고객명: " + rs.getString("customer_name"));
                System.out.println("도서명: " + rs.getString("bookname"));
                System.out.println("판매가격: " + rs.getInt("saleprice"));
                System.out.println("주문일자: " + rs.getDate("orderdate"));
                System.out.println("------------------------");
            }

            if (!found) {
                System.out.println("검색 결과가 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("검색 중 오류가 발생했습니다.");
        }
    }
}