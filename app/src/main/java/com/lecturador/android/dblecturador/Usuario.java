/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecturador.android.dblecturador;

import java.io.Serializable;

/**
 *
 * @author Dario Pardo
 */
public class Usuario implements Serializable {
    private int idusuario;
    private String login;
    private String contrasenha;
    private String nombre;
    private int idempleado;

    public Usuario() {
        idusuario=0;
        idempleado=0;
        login="";
        contrasenha="";
        nombre="";


    }

    public Usuario(int idusuario, String login, String contrasenha, String nombre) {
        this.idusuario = idusuario;
        this.login = login;
        this.contrasenha = contrasenha;
        this.nombre = nombre;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contraseña) {
        this.contrasenha = contraseña;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "idusuario=" + idusuario +
                ", login='" + login + '\'' +
                ", contrasenha='" + contrasenha + '\'' +
                ", nombre='" + nombre + '\'' +
                ", idempleado=" + idempleado +
                '}';
    }








}