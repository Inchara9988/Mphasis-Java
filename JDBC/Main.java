package com.mphasis.main;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdb","inchara","password");
            DatabaseMetaData dbmd=connection.getMetaData();
            ResultSet rs=dbmd.getTables(null,"",null,new String[]{"TABLE"});
            while (rs.next()){
                System.out.println(rs.getString(3));
            }
            PreparedStatement preparedStatement=connection.prepareStatement("select name as 'PRODUCT NAME' from product");
            ResultSet result=preparedStatement.executeQuery();
            System.out.println(result);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
