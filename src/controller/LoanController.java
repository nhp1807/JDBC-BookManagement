package controller;

import entity.Loan;
import jdbc.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoanController {
    private Connection conn;

    public LoanController() {
        conn = DatabaseManager.getConnection();
    }

    public void closeConnection() {
        DatabaseManager.closeConnection(conn);
    }

    public void addLoan(int bookId, int customerId, String borrowDate, String dueDate, String status) {
        // Add loan
        String sql = "INSERT INTO loans (bookId, customerId, borrowDate, dueDate, status) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, bookId);
            statement.setInt(2, customerId);
            statement.setString(3, borrowDate);
            statement.setString(4, dueDate);
            statement.setString(5, status);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Thêm phiếu mượn thành công");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm phiếu mượn");
            e.printStackTrace();
        }
    }

    public void updateLoan(int loanId, int bookId, int customerId, String borrowDate, String dueDate, String status) {
        // Update loan
        String sql = "UPDATE loans SET bookId = ?, customerId = ?, borrowDate = ?, dueDate = ?, status = ? WHERE id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, bookId);
            statement.setInt(2, customerId);
            statement.setString(3, borrowDate);
            statement.setString(4, dueDate);
            statement.setString(5, status);
            statement.setInt(6, loanId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật thông tin phiếu mượn thành công");
            } else {
                System.out.println("Không tìm thấy phiếu mượn cần cập nhật");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật thông tin phiếu mượn");
            e.printStackTrace();
        }
    }

    public void deleteLoan(int loanId) {
        // Delete loan
        String sql = "DELETE FROM loans WHERE id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, loanId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Xóa phiếu mượn thành công");
            } else {
                System.out.println("Không tìm thấy phiếu mượn cần xóa");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa phiếu mượn");
            e.printStackTrace();
        }
    }

    public Loan getLoan(int loanId) {
        // Get loan
        String sql = "SELECT * FROM loans WHERE id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, loanId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int bookId = resultSet.getInt("bookId");
                int customerId = resultSet.getInt("customerId");
                String borrowDate = resultSet.getString("borrowDate");
                String dueDate = resultSet.getString("dueDate");
                String status = resultSet.getString("status");
                return new Loan(loanId, bookId, customerId, borrowDate, dueDate, status);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy thông tin phiếu mượn");
            e.printStackTrace();
        }
        return null;
    }

    public List<Loan> getAllLoans() {
        // Get all loans
        List<Loan> loans = new ArrayList<>();
        String sql = "SELECT * FROM loans";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int loanId = resultSet.getInt("id");
                int bookId = resultSet.getInt("bookId");
                int customerId = resultSet.getInt("customerId");
                String borrowDate = resultSet.getString("borrowDate");
                String dueDate = resultSet.getString("dueDate");
                String status = resultSet.getString("status");
                loans.add(new Loan(loanId, bookId, customerId, borrowDate, dueDate, status));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy thông tin tất cả phiếu mượn");
            e.printStackTrace();
        }
        return loans;
    }
}
