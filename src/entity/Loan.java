package entity;

public class Loan {
    private int id;
    private int bookId;
    private int customerId;
    private String borrowedDate;
    private String dueDate;
    private String status;

    public Loan() {
    }

    public Loan(int id, int bookId, int customerId, String borrowedDate, String dueDate, String status) {
        this.id = id;
        this.bookId = bookId;
        this.customerId = customerId;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", customerId=" + customerId +
                ", borrowedDate='" + borrowedDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
