package com.lecturador.android.negocio;

import android.database.Cursor;
import android.util.Log;

import com.lecturador.android.dblecturador.DBhelper;
import com.lecturador.android.dblecturador.DBmanager;
import com.lecturador.android.dblecturador.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dario Pardo on 5/3/2015.
 */
public class NUsuario {

    private Usuario usuario;

    public NUsuario() {
        setUsuario(new Usuario());
    }

    public NUsuario(Usuario user) {
        this.setUsuario(new Usuario());
        this.getUsuario().setIdempleado(user.getIdempleado());
        this.getUsuario().setLogin(user.getLogin());
        this.getUsuario().setContrasenha(user.getContrasenha());
        this.getUsuario().setNombre(user.getNombre());
    }

    public NUsuario(int id, String login, String password, String nombre, int idempleado) {
        this.setUsuario(new Usuario());
        this.getUsuario().setIdempleado(id);
        this.getUsuario().setLogin(login);
        this.getUsuario().setContrasenha(password);
        this.getUsuario().setNombre(nombre);
        this.getUsuario().setIdempleado(idempleado);

    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void insertarUsuario(Usuario user) {
      insertarUsuario(user.getIdusuario(),user.getLogin(),user.getContrasenha(),user.getNombre(),user.getIdempleado());
    }

    public void insertarUsuario(int id, String login, String password, String nombre,int idempleado ) {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(id);
        datos.add(nombre);
        datos.add(login);
        datos.add(password);
        datos.add(idempleado);
        DBmanager.insertarTupla(DBhelper.NOMTAUSUARIO, DBhelper.COLSUSUARIO, datos);

        DBmanager.CerrarBD();

        Log.e("NUsuario", "se inserto un usuario correctamente");


    }

    public Usuario getUsuario(String lsLogin, String lsContrasena){

        Usuario loUsuario=new Usuario();
        String lsConsulta= DBhelper.COLUSLOGIN +" = '"+lsLogin+"' and  "+DBhelper.COLUSPASSWORD +" = '"+lsContrasena+"' ";
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAUSUARIO, DBhelper.COLSUSUARIO, lsConsulta, null);

        if (cursor.moveToNext())
        {
            loUsuario.setIdusuario(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLUSID))));
            loUsuario.setIdempleado(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLUSIDEMPLEADO))));
            loUsuario.setContrasenha(cursor.getString(cursor.getColumnIndex(DBhelper.COLUSPASSWORD)).trim());
            loUsuario.setLogin(cursor.getString(cursor.getColumnIndex(DBhelper.COLUSLOGIN)).trim());
            loUsuario.setNombre(cursor.getString(cursor.getColumnIndex(DBhelper.COLUSNOMBREE)).trim());

        }
        DBmanager.CerrarBD();
        return loUsuario;
    }
}
