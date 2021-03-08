package com.mphasis.main;

import java.sql.*;

public class ProcedureEX1 {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement psat=null;
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                 connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdb","inchara","password");
                System.out.println("connected....");
//               CallableStatement csat=connection.prepareCall("{call formatePhone(?)}");
//               csat.setString(1,"222222");
//               csat.execute();
//               String name=csat.getString(1);
//                System.out.println(name);
                 psat=connection.prepareStatement("insert into jdbcdb.product values(?,?,?)");
                psat.setInt(1,1);
                psat.setString(2,"keyBoard");
                psat.setInt(3,800);
                psat.executeUpdate();


            } catch (SQLException throwables) {
                try {
                    if(connection !=null && !connection.isClosed())
                        connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                throwables.printStackTrace();
            }finally {
                try {
                    if (psat !=null && !psat.isClosed());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }


