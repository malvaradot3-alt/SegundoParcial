/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.CreateConnection;
import modelo.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class EstudianteDao {

    private final CreateConnection coonFactory =
            new CreateConnection();

    private String ultimoError = "";

    public String getUltimoError() {
        return ultimoError;
    }

    
    public List<Estudiante> obtenerTodos() {

        List<Estudiante> lista = new ArrayList<>();

        String sql = "SELECT * FROM estudiante ORDER BY idestudiante";

        try (
            Connection conn = coonFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Estudiante est = new Estudiante(
                    rs.getInt("idestudiante"),
                    rs.getString("carnet"),
                    rs.getString("primerNombre"),
                    rs.getString("primerApellido"),
                    rs.getString("direccion"),
                    rs.getInt("telefono"),
                    rs.getString("carrera"),
                    rs.getString("fechaIngreso"),
                    rs.getDouble("cuotaMensual")
                );

                lista.add(est);
            }

        } catch (SQLException e) {

            System.out.println("ERROR AL CONSULTAR ESTUDIANTES");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }


    
    public boolean guardar(Estudiante est) {

        String sql =
            "INSERT INTO estudiante "
            + "(carnet, primerNombre, primerApellido, direccion, "
            + "telefono, carrera, fechaIngreso, cuotaMensual) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection conn = coonFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, est.getCarnet());
            ps.setString(2, est.getPrimerNombre());
            ps.setString(3, est.getApellido());
            ps.setString(4, est.getDireccion());
            ps.setInt(5, est.getTelefono());
            ps.setString(6, est.getCarrera());
            ps.setObject(7, est.getFechaIngreso(), java.sql.Types.OTHER);
            ps.setDouble(8, est.getCuotaMensual());

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {

            ultimoError = e.getMessage();
            System.out.println("ERROR AL GUARDAR ESTUDIANTE");
            System.out.println(e.getMessage());
            e.printStackTrace();

            return false;
        }
    }


    
    public boolean eliminar(int id) {

        String sql =
            "DELETE FROM estudiante "
            + "WHERE idestudiante = ?";

        try (
            Connection conn = coonFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {

            System.out.println("ERROR AL ELIMINAR ESTUDIANTE");
            System.out.println(e.getMessage());
            e.printStackTrace();

            return false;
        }
    }


   
    public boolean actualizar(Estudiante est) {

        String sql =
            "UPDATE estudiante SET "
            + "carnet = ?, "
            + "primerNombre = ?, "
            + "primerApellido = ?, "
            + "direccion = ?, "
            + "telefono = ?, "
            + "carrera = ?, "
            + "fechaIngreso = ?, "
            + "cuotaMensual = ? "
            + "WHERE idestudiante = ?";

        try (
            Connection conn = coonFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, est.getCarnet());
            ps.setString(2, est.getPrimerNombre());
            ps.setString(3, est.getApellido());
            ps.setString(4, est.getDireccion());
            ps.setInt(5, est.getTelefono());
            ps.setString(6, est.getCarrera());
            ps.setObject(7, est.getFechaIngreso(), java.sql.Types.OTHER);
            ps.setDouble(8, est.getCuotaMensual());
            ps.setInt(9, est.getId());

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {

            ultimoError = e.getMessage();
            System.out.println("ERROR AL ACTUALIZAR ESTUDIANTE");
            System.out.println(e.getMessage());
            e.printStackTrace();

            return false;
        }
    }
}

