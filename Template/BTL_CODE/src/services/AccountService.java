package services;

import csdl.CSDL;
import dao.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class AccountService {

    public void createAdminAccount() {

        String sqlCheckExists = "SELECT EXISTS(SELECT *FROM QLHSHocSinh.Accounts WHERE Username = 'admin');";
        try {
            Connection connection = CSDL.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCheckExists);
            if (resultSet.next()) {
                if (resultSet.getInt(1) == 1) {
                    return;
                }
            }

            String hashPassword = BCrypt.hashpw("admin", BCrypt.gensalt(10));
            String sqlCreateAdmin = "INSERT INTO Accounts VALUES (null, 'admin', ?, 'Admin', 'ADMIN');";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateAdmin);
            preparedStatement.setString(1, hashPassword);
            preparedStatement.execute();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Account getAccountByUsername(String username) {

        String sqlSelectUser = "SELECT * FROM QLHSHocSinh.Accounts WHERE Username = ?";
        Account account = null;
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectUser);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                account = new Account();
                account.setAccountId(resultSet.getInt("AccountId"));
                account.setUsername(resultSet.getString("Username"));
                account.setPassword(resultSet.getString("Password"));
                account.setDisplayName(resultSet.getString("DisplayName"));
                account.setRole(resultSet.getString("Role"));
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return account;
    }

    public List<Account> getAllAccounts() {
        List<Account> accounts = new LinkedList<>();
        String sqlGetAllUsers = "SELECT AccountId, Username, DisplayName, Role FROM QLHSHocSinh.Accounts";
        try {

            Connection connection = CSDL.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlGetAllUsers);
            while (resultSet.next()) {
                Account account = new Account();
                account.setAccountId(resultSet.getInt("AccountId"));
                account.setUsername(resultSet.getString("Username"));
                account.setDisplayName(resultSet.getString("DisplayName"));
                account.setRole(resultSet.getString("Role"));
                accounts.add(account);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return accounts;
    }

    public List<Account> getAccountsLikeUsername(String username) {
        List<Account> accounts = new LinkedList<>();

        String sqlGetAccountsLikeUsername = "SELECT AccountId, Username, DisplayName, Role FROM QLHSHocSinh.Accounts WHERE Username LIKE ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAccountsLikeUsername);
            preparedStatement.setString(1, "%" + username + "%");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Account account = new Account();
                account.setAccountId(resultSet.getInt("AccountId"));
                account.setUsername(resultSet.getString("Username"));
                account.setDisplayName(resultSet.getString("DisplayName"));
                account.setRole(resultSet.getString("Role"));
                accounts.add(account);
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return accounts;
    }

    public Boolean createNewAccount(Account account) {
        String sqlCreateNewUser = "INSERT INTO QLHSHocSinh.Accounts VALUES(null, ?, ?, ?, ?)";
        try {

            account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt(10)));

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateNewUser);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getDisplayName());
            preparedStatement.setString(4, account.getRole());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean updateAccount(Account account) {
        String sqlUpdateUser = "UPDATE accounts SET DisplayName = ?, Role = ? WHERE AccountId = ?";
        try {

            if (account.getPassword() != null) {
                account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt(10)));
                sqlUpdateUser = "UPDATE accounts SET DisplayName = ?, Role = ?, Password = ? WHERE AccountId = ?";
            }

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateUser);

            preparedStatement.setString(1, account.getDisplayName());
            preparedStatement.setString(2, account.getRole());

            if (account.getPassword() != null) {
                preparedStatement.setString(3, account.getPassword());
                preparedStatement.setInt(4, account.getAccountId());
            } else {
                preparedStatement.setInt(3, account.getAccountId());
            }

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean deleteAccount(Integer accountId) {
        String sqlDeleteUser = "DELETE FROM accounts WHERE AccountId = ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteUser);

            preparedStatement.setInt(1, accountId);

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
