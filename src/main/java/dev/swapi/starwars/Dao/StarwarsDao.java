package dev.swapi.starwars.Dao;

import dev.swapi.starwars.entity.Starwars;
import dev.swapi.starwars.entity.StarwarsTPMV;
import net.bytebuddy.asm.Advice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StarwarsDao {
    public static void inserirDados(Starwars starwars) {

        String sql = "INSERT INTO starships (name,model,manufacturer,cost_in_credits," +
                "passengers,cargo_capacity, MGLT) VALUES (?,?,?,?,?,?,?)";
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/starwars?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=America/Sao_Paulo",
                    "root", "root");

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, starwars.getName());
            preparedStatement.setString(2, starwars.getModel());
            preparedStatement.setString(3, starwars.getManufacturer());
            preparedStatement.setString(4, starwars.getCost_in_credits());
            preparedStatement.setInt(5, starwars.getPassengers());
            preparedStatement.setInt(6, starwars.getCargo_capacity());
            preparedStatement.setString(7, starwars.getMGLT());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static String consultaNaveMaisLenta() {
        String sql = "select name, MGLT from starships where MGLT = (SELECT min(MGLT) FROM starships)";
        String result = null;
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/starwars?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=America/Sao_Paulo",
                    "root", "root");

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            result= resultSet.getString("name");
        }

        preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public static ArrayList<Starwars> consultaListaDados() {
        ArrayList<Starwars> starwarsArrayList = null;

        String sql = "select * from starships";
        String result = null;
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/starwars?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=America/Sao_Paulo",
                    "root", "root");

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            Starwars starwars;
            while (resultSet.next()){
                starwars = new Starwars();
                starwars.setName(resultSet.getString("name"));
                starwars.setModel(resultSet.getString("model"));
                starwars.setManufacturer(resultSet.getString("manufacturer"));
                starwars.setCost_in_credits(resultSet.getString("cost_in_credits"));
                starwars.setPassengers(resultSet.getInt("passengers"));
                starwars.setCargo_capacity(resultSet.getInt("cargo_capacity"));
                starwars.setMGLT(resultSet.getString("MGLT"));
              starwarsArrayList.add(starwars);
            }
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return starwarsArrayList;
    }
    public static String consultaNaveMaisRapida() {
        String sql = "select name, MGLT from starships where MGLT = (SELECT max(MGLT) FROM starships)";
        String result = null;
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/starwars?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=America/Sao_Paulo",
                    "root", "root");

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                result= resultSet.getString("name");
            }

            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public static StarwarsTPMV consultaNaveMenorNumeroParada() {
        ArrayList<Starwars> starwarsArrayList;
        starwarsArrayList = consultaListaDados();
        StarwarsTPMV starwarsTPMV = null;

        for (int i = 0; i < starwarsArrayList.size(); ++i) {
            Starwars obj = (Starwars) starwarsArrayList.get(i);
            starwarsTPMV = (StarwarsTPMV) retornaDadosNave(obj.getMGLT(), obj.getCargo_capacity());
        }
        return starwarsTPMV;
    }

    public static Object retornaDadosNave(String MGLT, Integer Cargo_capacity){
         final int VELOCIDADE_NECESSARIA = 200;
         final int QTO_PASSAGEIROS       = 300;
         int MGLTInteger                 = Integer.parseInt(MGLT);
         int NumeroParada                = 0;
         int DistanciaEmMGLT             = 0;
         int QtdEmViagem                 = 0;
         int TotalDeParadas              = 0;

         NumeroParada    = VELOCIDADE_NECESSARIA/MGLTInteger;
         DistanciaEmMGLT = NumeroParada * MGLTInteger;
         QtdEmViagem     =  QTO_PASSAGEIROS/Cargo_capacity;
         TotalDeParadas  = NumeroParada * QtdEmViagem;

        StarwarsTPMV starwarsTPMV = new StarwarsTPMV();

        starwarsTPMV.getNumeroParada(NumeroParada);
        starwarsTPMV.getDistanciaEmMGLT(DistanciaEmMGLT);
        starwarsTPMV.getQtdEmViagem(QtdEmViagem);
        starwarsTPMV.getTotalDeParadas(TotalDeParadas);

        return starwarsTPMV;
    }

}