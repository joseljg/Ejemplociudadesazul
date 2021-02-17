package com.example.ejemplociudades.modelos;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.ejemplociudades.clases.Provincia;
import com.example.ejemplociudades.utilidades.ImagenesBlobBitmap;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ProvinciaDB {

	//----------------------------------------------------------....
	public static boolean insertarProvinciaTabla(Provincia p)
	{
		Connection conexion = BaseDB.conectarConBaseDeDatos();
		if(conexion == null)
		{
			return false;
		}
		//----------------------------
		try {
			String ordensql = "INSERT INTO provincias (nombre) VALUES (?);";
			PreparedStatement pst = conexion.prepareStatement(ordensql);
			pst.setString(1, p.getNombre());
			int filasAfectadas = pst.executeUpdate();
			pst.close();
			conexion.close();
			if(filasAfectadas > 0)
			{
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}
	//-----------------------------------------------------------
	public static Provincia buscarProvinciaTabla(String nombre)
	{
		Connection conexion = BaseDB.conectarConBaseDeDatos();
		if(conexion == null)
		{
			return null;
		}
		//---------------------------------
		Provincia provinciaEncontrada = null;
		try {
			ResultSet resultadosql = BaseDB.buscarFilasEnTabla(conexion, "provincias", "nombre", nombre);
			//------------------------------------------------
			if(resultadosql == null)
			{
				return null;
			}
			while(resultadosql.next())
			{
				int idprovincia = resultadosql.getInt("idprovincia");
				String nombreprovincia = resultadosql.getString("nombre");
				Blob foto = resultadosql.getBlob("foto");
				Bitmap fotobm = ImagenesBlobBitmap.blob_to_bitmap(foto,ImagenesBlobBitmap.ancho, ImagenesBlobBitmap.alto);
				provinciaEncontrada = new Provincia(idprovincia,nombreprovincia, fotobm);
			}
			resultadosql.close();
			conexion.close();
			return provinciaEncontrada;
		} catch (SQLException e) {
          return null;
		}
	}

    public static ArrayList<Provincia> obtenerProvincias() {
		Connection conexion = BaseDB.conectarConBaseDeDatos();
		if(conexion == null)
		{
			return null;
		}
		ArrayList<Provincia> provinciasDevueltas = new ArrayList<Provincia>();
		try {
			Statement sentencia = conexion.createStatement();
			String ordenSQL = "select * from provincias";
			ResultSet resultado = sentencia.executeQuery(ordenSQL);
			while(resultado.next())
			{
				int idprovincia = resultado.getInt("idprovincia");
				String nombre = resultado.getString("nombre");
				Blob foto = resultado.getBlob("foto");
				Bitmap fotobm = ImagenesBlobBitmap.blob_to_bitmap(foto,ImagenesBlobBitmap.ancho, ImagenesBlobBitmap.alto);
				Provincia p = new Provincia(idprovincia, nombre, fotobm);
				provinciasDevueltas.add(p);
			}
			resultado.close();
			sentencia.close();
			conexion.close();
			return provinciasDevueltas;
		} catch (SQLException e) {
			Log.i("sql", "error sql");
			return provinciasDevueltas;
		}
    }

    public static boolean borrarProvinciaTabla(Provincia p) {
		Connection conexion = BaseDB.conectarConBaseDeDatos();
		if(conexion == null)
		{
			return false;
		}
		//----------------------------
		try {
			String ordensql = "DELETE FROM provincias WHERE nombre LIKE ?;";
			PreparedStatement pst = conexion.prepareStatement(ordensql);
			pst.setString(1, p.getNombre());
			int filasAfectadas = pst.executeUpdate();
			pst.close();
			conexion.close();
			if(filasAfectadas > 0)
			{
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
    }

    public static boolean actualizarProvinciaTabla(Provincia p) {
		Connection conexion = BaseDB.conectarConBaseDeDatos();
		if(conexion == null)
		{
			return false;
		}
		//----------------------------
		try {
			String ordensql = "UPDATE provincias SET nombre = ? WHERE idprovincia = ?";
			PreparedStatement pst = conexion.prepareStatement(ordensql);
			pst.setString(1, p.getNombre());
			pst.setInt(2, p.getIdprovincia());
			int filasAfectadas = pst.executeUpdate();
			pst.close();
			conexion.close();
			if(filasAfectadas > 0)
			{
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
    }
//--------------------------------------------------------------
}
