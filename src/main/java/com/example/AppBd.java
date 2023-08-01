package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppBd {
    private static final String PASSWORD = "";
    private static final String USERNAME = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";
    private Connection conn;

    public static void main(String[] args) {
      new AppBd();
    }

    public AppBd(){
        try(var conn = getConnection()) {
            listarEstados(conn);
            System.out.println();
            localizarEstado(conn,"BA");
            listaDadosTabela(conn,"cliente");
            System.out.println();
            listaDadosTabela(conn,"produto");
    }   catch (SQLException e){
                System.out.println("Não foi possivel conectar ao banco de dados");
            }
        }


    private void listaDadosTabela(Connection conn, String tabela) {
        var sql = "select * from " + tabela;
        System.out.println(sql);
        try {
            var statement= conn.createStatement();
            var result = statement.executeQuery(sql);
            var metadata = result.getMetaData();
    
            int cols = metadata.getColumnCount();
            
            for (int i = 1; i <= cols; i++) {
                System.out.printf("%-25s | ", metadata.getColumnName(i));
            }
            System.out.println();
            System.out.println();
            
            while( result.next()){
                
                for (int i = 1; i <= cols; i++) {
                    System.out.printf("%-25s | ", result.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.err.println("erro na execução da consulta " + e.getMessage());
        }
    }

    private void localizarEstado(Connection conn, String uf) {
        try {
         //var sql ="select * from estado where uf = '" + uf + "'"; não deve ser feito,
        var sql ="select * from estado where uf = ?";
        var statement = conn.prepareStatement(sql);
        System.out.println(sql);
        statement.setString(1, uf);
        var result = statement.executeQuery();
        if(result.next()){
            System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"),result.getString("nome"), result.getString("uf"));
        }
    } catch (SQLException e) {
        System.err.println("erro ao executar consulta SQL");
    }
}

    private void listarEstados(Connection conn) {
        try {
            System.out.println("Conexão Estabelecida");

            var statement = conn.createStatement();
            var result = statement.executeQuery("select * from estado");
            while(result.next()) {
                System.out.printf("id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            }
    }   catch (SQLException e){
                System.err.println("Não foi possivel conectar ao banco de dados ");
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    private void carregarDriveJDBC() {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            System.err.println("Não foi possivel carregar O BD ");
        }
    }
}
