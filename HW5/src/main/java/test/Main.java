package test;

import test.service.Insert;
import test.service.Delete;
import test.service.Retrieval;
import test.utils.DatabaseConnection;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        try (Connection conn = DatabaseConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.print("원하는 작업을 선택하세요: \n");
                System.out.println("1. 삽입");
                System.out.println("2. 삭제");
                System.out.println("3. 검색");
                System.out.println("4. 종료");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        while (true) {
                            System.out.print("원하는 작업을 선택하세요: \n");
                            System.out.println("1. Book");
                            System.out.println("2. Customer");
                            System.out.println("3. Order");
                            System.out.println("4. 이전 메뉴로");

                            String insertChoice = scanner.nextLine();

                            switch (insertChoice) {
                                case "1":
                                    Insert.insertBook(conn, scanner);
                                    break;
                                case "2":
                                    Insert.insertCustomer(conn, scanner);
                                    break;
                                case "3":
                                    Insert.insertOrder(conn, scanner);
                                    break;
                                case "4":
                                    break;
                                default:
                                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                                    continue;
                            }
                            if (insertChoice.equals("4")) break;
                        }
                        break;

                    case "2":
                        while (true) {
                            System.out.print("원하는 작업을 선택하세요: \n");
                            System.out.println("1. Book");
                            System.out.println("2. Customer");
                            System.out.println("3. Order");
                            System.out.println("4. 이전 메뉴로");

                            String deleteChoice = scanner.nextLine();

                            switch (deleteChoice) {
                                case "1":
                                    Delete.deleteBook(conn, scanner);
                                    break;
                                case "2":
                                    Delete.deleteCustomer(conn, scanner);
                                    break;
                                case "3":
                                    Delete.deleteOrder(conn, scanner);
                                    break;
                                case "4":
                                    break;
                                default:
                                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                                    continue;
                            }
                            if (deleteChoice.equals("4")) break;
                        }
                        break;

                    case "3":
                        while (true) {
                            System.out.print("원하는 작업을 선택하세요: \n");
                            System.out.println("1. Book");
                            System.out.println("2. Customer");
                            System.out.println("3. Order");
                            System.out.println("4. 이전 메뉴로");

                            String searchChoice = scanner.nextLine();

                            switch (searchChoice) {
                                case "1":
                                    Retrieval.searchBook(conn, scanner);
                                    break;
                                case "2":
                                    Retrieval.searchCustomer(conn, scanner);
                                    break;
                                case "3":
                                    Retrieval.searchOrder(conn, scanner);
                                    break;
                                case "4":
                                    break;
                                default:
                                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                                    continue;
                            }
                            if (searchChoice.equals("4")) break;
                        }
                        break;

                    case "4":
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    default:
                        System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                }
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 오류: " + e.getMessage());
        }
    }
}