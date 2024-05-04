package controller;

import entity.Customer;
import jdbc.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private Connection conn;

    public CustomerController() {
        conn = DatabaseManager.getConnection();
    }

    public void closeConnection() {
        DatabaseManager.closeConnection(conn);
    }

    public void addCustomer(String name, String phone) {
        // Add customer
        String sql = "INSERT INTO customers (name, phone) VALUES (?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, phone);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Thêm khách hàng thành công");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm khách hàng");
            e.printStackTrace();
        }
    }

    public void updateCustomer(int customerId, String newName, String newPhone) {
        // Update customer
        String sql = "UPDATE customers SET name = ?, phone = ? WHERE id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newName);
            statement.setString(2, newPhone);
            statement.setInt(3, customerId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật thông tin khách hàng thành công");
            } else {
                System.out.println("Không tìm thấy khách hàng cần cập nhật");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật thông tin khách hàng");
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int customerId) {
        // Delete customer
        String sql = "DELETE FROM customers WHERE id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, customerId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Xóa khách hàng thành công");
            } else {
                System.out.println("Không tìm thấy khách hàng cần xóa");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa khách hàng");
            e.printStackTrace();
        }
    }

    public Customer getCustomer(int customerId) {
        // Get customer
        String sql = "SELECT * FROM customers WHERE id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                return new Customer(customerId, name, phone);
            } else {
                System.out.println("Không tìm thấy khách hàng");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy thông tin khách hàng");
            e.printStackTrace();
        }
        return null; // Trả về null nếu không tìm thấy khách hàng
    }

    public List<Customer> getAllCustomers() {
        // Get all customers
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                customers.add(new Customer(id, name, phone));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy danh sách khách hàng");
            e.printStackTrace();
        }
        return customers;
    }
}
