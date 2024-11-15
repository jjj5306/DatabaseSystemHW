package test.domain;

import java.util.Date;

public class Orders {
    private int orderid;
    private int custid;
    private int bookid;
    private int saleprice;
    private Date orderdate;
    private String bookname;

    public Orders() {
    }

    public Orders(int orderid, int custid, int bookid, int saleprice, Date orderdate, String bookname) {
        this.orderid = orderid;
        this.custid = custid;
        this.bookid = bookid;
        this.saleprice = saleprice;
        this.orderdate = orderdate;
        this.bookname = bookname;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(int saleprice) {
        this.saleprice = saleprice;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderid=" + orderid +
                ", custid=" + custid +
                ", bookid=" + bookid +
                ", saleprice=" + saleprice +
                ", orderdate=" + orderdate +
                ", bookname='" + bookname + '\'' +
                '}';
    }
}
