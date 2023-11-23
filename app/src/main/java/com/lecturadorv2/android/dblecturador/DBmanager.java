package com.lecturadorv2.android.dblecturador;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;

public class DBmanager {

	private static SQLiteDatabase manager;
	private static DBhelper helper;
	private static Context contexto;
	private static int _openCounter;

	/**
	 * constructor que crea la BD que se encuentre especificada en el dbhelper
	 * 
	 * @param context
	 * @return
     */
	public static void inicializar(AppCompatActivity context) {
		contexto = context;
		CrearBD(context);

	}

	public static Context getContexto() {
		return contexto;
	}

	public static void CrearBD(Context context) {
		helper = new DBhelper(context);

		AbrirBD();
		CerrarBD();
	}

	public static void AbrirBD() {
		try {
			_openCounter++;
			if (_openCounter == 1) {
				manager = helper.getWritableDatabase();
			}
		} catch (Exception e) {
			Log.e("DBManager", "no se puede ABRIR la db Error " + e.toString());
		}
	}

	public static void CerrarBD() {
		try {
			_openCounter--;
			if (_openCounter == 0) {
				manager.close();
			}
		} catch (Exception e) {
			Log.e("DBManager", "no se puede CERRAR la db Error " + e.toString());
		}
	}

	public static long insertarTupla(String nombreTabla, String[] columnas,
			List<Object> datos) {

		// Log.v("DBManager", "INSERTANDO TUPLA ");
		ContentValues contentValues = new ContentValues();
		// Log.v("DBManager", "poniendo valores en contentvalues");
		for (int i = 0; i < columnas.length; i++) {

			// Log.v("DBManager",
			// columnas[i] + " = " + String.valueOf(datos.get(i)));
			contentValues.put(columnas[i], String.valueOf(datos.get(i)));

		}

		Long x = manager.insert(nombreTabla, null, contentValues);

		 Log.v("DBMAnager", "filas insertadas:" + x);
		return x;

	}

	public static void modificarTupla(String nombreTabla, String[] columnas,
			List<Object> datos, String condicion) {
		// Log.v("DBMAnager", "MODIFICANDO TUPLA ");
		ContentValues values = new ContentValues();
		// Log.v("DBMAnager", "poniendo los valores en contetvalues ");

		for (int i = 0; i < columnas.length; i++) {
			// Log.v("DBMAnager", columnas[i] + String.valueOf(datos.get(i)));
			values.put(columnas[i], String.valueOf(datos.get(i)));
		}
		manager.update(nombreTabla, values, condicion, null);
	}

	public static Cursor listarTabla(String nombreTabla, String[] columnas) {
		return listarTabla(nombreTabla, columnas, null);
	}

	public static Cursor listarTabla(String nombreTabla, String[] columnas,
			String[] ordenarPor) {
		return listarTabla(nombreTabla, columnas, null, null, ordenarPor);
	}

	public static Cursor listarTabla(String nombreTabla, String[] columnas,
			String filtros, String[] valores) {
		return listarTabla(nombreTabla, columnas, filtros, valores, null);
	}

	public static Cursor listarTabla(String nombreTabla, String[] columnas,
			String filtros, String[] valores, String[] ordenarPor) {

		String orderBy = null;
		if (ordenarPor != null) {
			StringBuilder sb = new StringBuilder();
			for (String columna : ordenarPor) {
				if (sb.length() > 0)
					sb.append(", ");
				sb.append(columna);
			}
			orderBy = sb.toString();
		}

		Cursor cursor = manager.query(nombreTabla, columnas,
				filtros, valores, null, null, orderBy);

		return cursor;
	}

	public static void eliminarTupla(String nombreTabla, String condicion) {
		manager.delete(nombreTabla, condicion, null);
	}

	public static Cursor buscarTuplas(String nombreTabla,
			String[] columnas, String Condiciones,String orderby) {

		// String lsSql="Select * from "+nombreTabla+" where "+Condiciones;
		Cursor cursor = manager.query(true,nombreTabla, columnas,
				Condiciones , null, null, null, orderby, null);

		return cursor;
		// return null;
	}
	public static int buscarTuplaMax(String nombreTabla,String nombreCol,
									  String Condiciones,String orderby) {

		// String lsSql="Select * from "+nombreTabla+" where "+Condiciones;
         int result=0;
		String lsSql = "select MAX(" + nombreCol + ") from "
				+ nombreTabla+" where "+Condiciones;
		AbrirBD();
		Cursor cursor = manager.rawQuery(lsSql, null);

		try{
			if (cursor.moveToNext()) {
				result = Integer.valueOf(cursor.getString(0));
			}
		} catch (Exception e) {
				e.printStackTrace();
				Log.e("DBmanager", "ERROR por obtenerRegistro e= " + e.toString());
		} finally {
			cursor.close();
			CerrarBD();
		}


		return result;
		// return null;
	}
	public static Boolean existe(String nombreTabla, String[] columnas,
			String condicion) {
		boolean b = false;
		AbrirBD();
		try {

			return existeSinConexion(nombreTabla, columnas, condicion);
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("DBmanager", "ERROR por existe e= " + e.toString());
		} finally {
			CerrarBD();
		}
		return b;

	}

	public static Boolean existeSinConexion(String nombreTabla,
			String[] columnas, String condicion) {
		boolean b = false;
	    Cursor cursor = manager.query(nombreTabla, columnas,
				condicion, null, null, null, null);
		try {

			if (cursor.moveToFirst()) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("DBmanager", "ERROR por existeSinConexion e= " + e.toString());
		} finally {
			cursor.close();
		}
		return b;

	}

	public static void LimpiarTabla(String nombreTabla) {
		manager.execSQL("delete from " + nombreTabla);
	}

	public static int GenerarID(String nombreTabla, String nombreID) {
		String lsSql = "select ifnull( MAX(" + nombreID + " )+1,1) from "
				+ nombreTabla;

		AbrirBD();
		int id = 0;
		Cursor cursor = manager.rawQuery(lsSql, null);
		try {

			if (cursor.moveToNext()) {
				id = Integer.valueOf(cursor.getString(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("DBmanager", "ERROR por obtenerRegistro e= " + e.toString());
		} finally {
			cursor.close();
			CerrarBD();
		}

		return id;
	}

	public static int Cantidad_de_Registros(String nombreTabla) {
		AbrirBD();
		try {
			return Cantidad_de_Registros_Sin_Conexion(nombreTabla);
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("DBmanager", "ERROR por IniciarSesion e= " + e.toString());
		} finally {
			CerrarBD();
		}

		return 0;
	}

	public static int Cantidad_de_Registros_Sin_Conexion(String nombreTabla) {
		String lsSql = "SELECT count(*) nroFilas FROM  " + nombreTabla;
		int liCantReg = 0;
		Cursor cursor = null;
		try {
			cursor = manager.rawQuery(lsSql, null);
			if (cursor.moveToNext()) {
				liCantReg = Integer.valueOf(cursor.getString(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("DBmanager", "ERROR por IniciarSesion e= " + e.toString());
		} finally {
			cursor.close();
		}

		return liCantReg;
	}

	public static Cursor EjecutarConsulta(String consulta) {

		return EjecutarConsulta(consulta, null);
	}
	
	public static Cursor EjecutarConsulta(String consulta, String[] valores) {

	    Cursor loC = manager.rawQuery(consulta, valores);
		return loC;
	}

}
