package dbTool;

import java.sql.*;

public class Dao {
    //생성자로 해결
    private final String dbPassword;
    private final String url;
    private final String dbUserId;
    //각 메소드로 해결
    public Connection connection = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet rs = null;

    public Dao() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.url = "jdbc:mariadb://localhost:3306/zerobase_1?allowMultiQueries=true";//다중쿼리허용
        this.dbUserId = "testuser1";
        this.dbPassword = "zerobase";
    }

    public void select() {//수동으로 객체닫음
        try {
            this.connection = DriverManager.getConnection(this.url, this.dbUserId, this.dbPassword);
            String sql = " SELECT * FROM history_info ;";
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.rs = this.preparedStatement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Dto dto) { //자동으로 객체닫음
        try {
            this.connection = DriverManager.getConnection(this.url, this.dbUserId, this.dbPassword);
            String sql = " INSERT INTO history_info (LAT,LNT,CALL_DTTM) " +
                    " VALUES ( ?, ?, NOW()); ";
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1, dto.getLat());
            this.preparedStatement.setString(2, dto.getLnt());
            this.preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (this.preparedStatement != null && !this.preparedStatement.isClosed()) {
                    this.preparedStatement.close();
                }
                if (this.connection != null && !this.connection.isClosed()) {
                    this.connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete() {//자동으로 객체닫음
        try {
            this.connection = DriverManager.getConnection(this.url, this.dbUserId, this.dbPassword);

            String sql1 = " DELETE FROM history_info " +
                    "WHERE ? IS NOT NULL ; " +
                    " ALTER TABLE history_info " +
                    " AUTO_INCREMENT = 1;";

            this.preparedStatement = this.connection.prepareStatement(sql1);
            this.preparedStatement.setString(1, "ID");
            this.preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (this.preparedStatement != null && !this.preparedStatement.isClosed()) {
                    this.preparedStatement.close();
                }
                if (this.connection != null && !this.connection.isClosed()) {
                    this.connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}