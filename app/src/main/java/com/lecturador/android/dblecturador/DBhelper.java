package com.lecturador.android.dblecturador;

//import java.io.File;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBhelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "dbLecturador.db";
    public static int DATABASE_VERSION1 = 1;
    public static int DATABASE_VERSION2 = 2;
    public static int DATABASE_VERSION = DATABASE_VERSION1;

    // COLUMNAS

    // 1 PARAMETROS
    public static String NOMTAPARAMETROS = "parametros";
    public static String COLPACODZONA = "codZona";
    public static String COLPAIDEMPLEADO = "idEmpleado";
    public static String COLPACANTMEDIDORES = "cantMedidores";
    public static String COLPACANTSOCIOS="cantSocios";
    public static String[] COLSPARAMETROS = {COLPACODZONA, COLPAIDEMPLEADO, COLPACANTMEDIDORES,COLPACANTSOCIOS};
    public static String CTPARAMETROS = " create table parametros ( " +
            " codZona integer not null, " +
            " idEmpleado integer not null, " +
            " cantMedidores integer not null, " +
            " cantSocios integer not null  );";

    // 2 USUARIO
    public static String NOMTAUSUARIO = "Usuario";
    public static String COLUSID = "id";
    public static String COLUSNOMBREE = "nombre";
    public static String COLUSLOGIN = "login";
    public static String COLUSPASSWORD = "password";
    public static String COLUSIDEMPLEADO = "idempleado";
    public static String[] COLSUSUARIO = {COLUSID, COLUSNOMBREE, COLUSLOGIN,
            COLUSPASSWORD, COLUSIDEMPLEADO};

    public static String CTUSUARIO = " create table usuario("
            + " 	id integer  ,"   ///+ " 	idempleado integer primary key ,"
            + " 	nombre text not null,"
            + " 	login text not null,"
            + " 	password text not null, "
            + "     idempleado integer "
            + " 	);";

    // 3 EMPLEADO
    public static String NOMTAEMPLEADO = "empleado";
    public static String COLEMCODIGO = "codigo";
    public static String COLEMCI = "ci";
    public static String COLEMNOMBRE = "nombre";
    public static String COLEMTELEFONO = "telefono";
    public static String COLEMDIRECCION = "direccion";
    public static String COLEMIDZONA = "idzona";
    public static String[] COLSEMPLEADO = {COLEMCODIGO, COLEMCI, COLEMNOMBRE,
            COLEMTELEFONO, COLEMDIRECCION, COLEMIDZONA};
    public static String CTEMPLEADO = " create table empleado ( " +
            " codigo integer  not null , " +
            " ci integer not null , " +
            " nombre text not null , " +
            " telefono integer not null , " +
            " direccion text not null , " +
            " idzona integer not null ); ";


    // 4 MEDIDOR
    public static String NOMTAMEDIDOR = "Medidor";
    public static String COLMEID = "id";
    public static String COLMEMARCADOR = "marcador";
    public static String COLMEIDCATEGORIA = "idcategoria";
    public static String COLMEIDZONA = "idzona";
    public static String COLMECODSOCIO = "codsocio";
    public static String[] COLSMEDIDOR = {COLMEID, COLMEMARCADOR, COLMEIDCATEGORIA, COLMEIDZONA, COLMECODSOCIO};
    public static String CTMEDIDOR = "create table medidor(" +
            "        id integer primary key, " +
            "        marcador integer not null, " +
            "        idcategoria integer not null ," +
            "        idzona integer not null ," +
            "        codsocio integer not null ); ";


    // 4 SOCIO
    public static String NOMTASOCIO = "Socio";
    public static String COLSOCODIGO = "codigo";
    public static String COLSOCI = "ci";
    public static String COLSONOMBRE = "nombre";
    public static String COLSODIRECCION="direccion";
    public static String[] COLSSOCIO={COLSOCODIGO,COLSOCI,COLSONOMBRE,COLSODIRECCION};
    public static String CTSOCIO=" create table socio ( " +
            " codigo integer not null, " +
            " ci integer not null, " +
            " nombre text not null, " +
            " direccion text not null ); ";


    public static String NOMTALECTURACION="lecturacion";
    public static String COLLEID="id";
    public static String COLLELCTURA="lectura";
    public static String COLLEIDTIPO="idtipo";
    public static String COLLECONSUMO="consumo";
    public static String COLLEOBSERVACION="observacion";
    public static String COLLEIDPERIODO="idPeriodo";
    public static String COLLEIDMEDIDOR="idmedidor";
    public static String[] COLSLECTURACION={COLLEID,COLLELCTURA,COLLEIDTIPO,COLLECONSUMO,COLLEOBSERVACION,COLLEIDPERIODO,COLLEIDMEDIDOR};
    public static String CTLECTURACION="create table lecturacion (  " +
            " id integer not null , " +
            " lectura integer not null , " +
            " idtipo integer not null , " +
            " consumo integer not null ," +
            " observacion text not null ," +
            " idPeriodo integer not null ," +
            " idmedidor integer not null ); ";

    // TABLA 1 CONFIGURACIONES
    public static String NOMTACNF="ltcnf";
    public static String COLCNFNITM="ltcnfNitm";
    public static String COLCNFWURL="ltcnfwUrl";
    public static String COLCNFONLY="ltcnfOnly";
    public static String COLCNFPRIN="ltcnfPrin";
    public static String COLCNFGPSA="ltcnfGpsA";
    public static String COLCNFNPRI="ltcnfNpri";
    public static String[] COLSCNF={COLCNFNITM , COLCNFWURL, COLCNFONLY, COLCNFPRIN, COLCNFGPSA,COLCNFNPRI};
    public static String CTCNF="create table ltcnf (  " +
            " ltcnfNitm integer not null, " +
            " ltcnfwUrl text not null, " +
            " ltcnfOnly boolean, " +
            " ltcnfPrin boolean, " +
            " ltcnfGpsA boolean,  " +
            " ltcnfNpri int ); ";


    // TABLA 2 HEADER AVISO COBRANZA
    public static  String NOMTAHPW="bshpw";
    public static String COLBSHPWNHPF="bshpwNhpf";
    public static String COLBSHPWANIO="bshpwAnio";
    public static String COLBSHPWMESF="bshpwMesf";
    public static String COLBSHPWFGEN="bshpwFgen";
    public static String COLBSHPWFENT="bshpwFent";
    public static String COLBSHPWFVTO="bshpwFvto";
    public static String COLBSHPWFCOR="bshpwFcor";
    public static String COLBSHPWNHPC="bshpwNhpc";
    public static String COLBSHPWNCAT="bshpwNcat";
    public static String COLBSHPWDCAT="bshpwDcat";
    public static String COLBSHPWLANT="bshpwLant";
    public static String COLBSHPWLACT="bshpwLact";
    public static String COLBSHPWCONS="bshpwCons";
    public static String COLBSHPWCONF="bshpwConf";
    public static String COLBSHPWIMCO="bshpwImco";
    public static String COLBSHPWFINI="bshpwFini";
    public static String COLBSHPWFFIN="bshpwFfin";
    public static String COLBSHPWIMPT="bshpwImpt";
    public static String COLBSHPWICFI="bshpwIcfi";
    public static String COLBSHPWIMOR="bshpwImor";
    public static String COLBSHPWNMOR="bshpwNmor";
    public static String COLBSHPWCMOR="bshpwCmor";
    public static String COLBSHPWCORT="bshpwCort";
    public static String COLBSHPWDESC="bshpwDesc";
    public static String COLBSHPWCPER="bshpwCper";
    public static String COLBSHPWNOMB="bshpwNomb";
    public static String COLBSHPWNMED="bshpwNmed";
    public static String COLBSHPWNUME="bshpwNume";
    public static String COLBSHPWNCNT="bshpwNcnt";
    public static String COLBSHPWNSER="bshpwNser";
    public static String COLBSHPWDPTO="bshpwDpto";
    public static String COLBSHPWNPRO="bshpwNpro";
    public static String COLBSHPWNCIU="bshpwNciu";
    public static String COLBSHPWDCIU="bshpwDciu";
    public static String COLBSHPWNUVE="bshpwNuve";
    public static String COLBSHPWDUVE="bshpwDuve";
    public static String COLBSHPWNMZA="bshpwNmza";
    public static String COLBSHPWDMZA="bshpwDmza";
    public static String COLBSHPWNLOT="bshpwNlot";
    public static String COLBSHPWDLOT="bshpwDlot";
    public static String COLBSHPWNBAR="bshpwNbar";
    public static String COLBSHPWDBAR="bshpwDbar";
    public static String COLBSHPWNIMB="bshpwNimb";
    public static String COLBSHPWDIMB="bshpwDimb";
    public static String COLBSHPWNZON="bshpwNzon";
    public static String COLBSHPWDZON="bshpwDzon";
    public static String COLBSHPWNRUT="bshpwNrut";
    public static String COLBSHPWDRUT="bshpwDrut";
    public static String COLBSHPWCODF="bshpwCodf";
    public static String COLBSHPWNRED="bshpwNred";
    public static String COLBSHPWNVIA="bshpwNvia";
    public static String COLBSHPWNROI="bshpwNroi";
    public static String COLBSHPWDIRE="bshpwDire";
    public static String COLBSHPWCLAS="bshpwClas";
    public static String COLBSHPWIPLV="bshpwIplv";
    public static String COLBSHPWNFAC="bshpwNfac";
    public static String COLBSHPWNTPC="bshpwNtpc";
    public static String COLBSHPWNTCN="bshpwNtcn";
    public static String COLBSHPWNDTB="bshpwNdtb";
    public static String COLBSHPWONOF="bshpwOnof";
    public static String COLBSHPWLMAX="bshpwLmax";
    public static String COLBSHPWCONP="bshpwConp";
    public static String COLBSHPWKVAT="bshpwKvat";
    public static String COLBSHPWCOBS="bshpwCobs";
    public static String COLBSHPWNLEC="bshpwNlec";
    public static String COLBSHPWPTJC="bshpwPtjc";
    public static String COLBSHPWSTAD="bshpwStad";
    public static String COLBSHPWLATI="bshpwLati";
    public static String COLBSHPWLONG="bshpwLong";
    public static String COLBSHPWSTAT="bshpwStat";
    public static String COLBSHPWRIDE="bshpwRide";
    public static String [] COLSBSHPW={ COLBSHPWNHPF,COLBSHPWANIO,COLBSHPWMESF,COLBSHPWFGEN,COLBSHPWFENT,COLBSHPWFVTO,
            COLBSHPWFCOR,COLBSHPWNHPC,COLBSHPWNCAT,COLBSHPWDCAT,COLBSHPWLANT,COLBSHPWLACT,
            COLBSHPWCONS,COLBSHPWCONF,COLBSHPWIMCO,COLBSHPWFINI,COLBSHPWFFIN,COLBSHPWIMPT,
            COLBSHPWICFI,COLBSHPWIMOR,COLBSHPWNMOR,COLBSHPWCMOR,COLBSHPWCORT,COLBSHPWDESC,
            COLBSHPWCPER,COLBSHPWNOMB,COLBSHPWNMED,COLBSHPWNUME,COLBSHPWNCNT,COLBSHPWNSER,
            COLBSHPWDPTO,COLBSHPWNPRO,COLBSHPWNCIU,COLBSHPWDCIU,COLBSHPWNUVE,COLBSHPWDUVE,
            COLBSHPWNMZA,COLBSHPWDMZA,COLBSHPWNLOT,COLBSHPWDLOT,COLBSHPWNBAR,COLBSHPWDBAR,
            COLBSHPWNIMB,COLBSHPWDIMB,COLBSHPWNZON,COLBSHPWDZON,COLBSHPWNRUT,COLBSHPWDRUT,
            COLBSHPWCODF,COLBSHPWNRED,COLBSHPWNVIA,COLBSHPWNROI,COLBSHPWDIRE,COLBSHPWCLAS,
            COLBSHPWIPLV,COLBSHPWNFAC,COLBSHPWNTPC,COLBSHPWNTCN,COLBSHPWNDTB,COLBSHPWONOF,
            COLBSHPWLMAX,COLBSHPWCONP,COLBSHPWKVAT,COLBSHPWCOBS,COLBSHPWNLEC,COLBSHPWPTJC,
            COLBSHPWSTAD,COLBSHPWLATI,COLBSHPWLONG,COLBSHPWSTAT,COLBSHPWRIDE};
    public static String CTBSHPW=" create table bshpw (  " +
            " bshpwNhpf integer not null , " +
            " bshpwAnio integer not null , " +
            " bshpwMesf integer not null , " +
            " bshpwFgen text not null , " +
            " bshpwFent text not null , " +
            " bshpwFvto text not null , " +
            " bshpwFcor text not null , " +
            " bshpwNhpc integer not null , " +
            " bshpwNcat integer not null , " +
            " bshpwDcat text not null , " +
            " bshpwLant integer not null , " +
            " bshpwLact integer not null , " +
            " bshpwCons integer not null , " +
            " bshpwConf integer not null , " +
            " bshpwImco real not null , " +
            " bshpwFini text not null , " +
            " bshpwFfin text not null , " +
            " bshpwImpt real not null , " +
            " bshpwIcfi real not null , " +
            " bshpwImor real not null , " +
            " bshpwNmor integer not null , " +
            " bshpwCmor integer not null , " +
            " bshpwCort text not null , " +
            " bshpwDesc text not null , " +
            " bshpwCper integer not null , " +
            " bshpwNomb text not null , " +
            " bshpwNmed integer not null , " +
            " bshpwNume text not null , " +
            " bshpwNcnt integer not null , " +
            " bshpwNser integer not null , " +
            " bshpwDpto integer not null , " +
            " bshpwNpro integer not null , " +
            " bshpwNciu integer not null , " +
            " bshpwDciu text not null , " +
            " bshpwNuve integer not null , " +
            " bshpwDuve text not null , " +
            " bshpwNmza integer not null , " +
            " bshpwDmza text not null , " +
            " bshpwNlot integer not null , " +
            " bshpwDlot text not null , " +
            " bshpwNbar integer not null , " +
            " bshpwDbar text not null , " +
            " bshpwNimb integer not null , " +
            " bshpwDimb text not null , " +
            " bshpwNzon integer not null , " +
            " bshpwDzon text not null , " +
            " bshpwNrut integer not null , " +
            " bshpwDrut text not null , " +
            " bshpwCodf integer not null , " +
            " bshpwNred integer not null , " +
            " bshpwNvia integer not null , " +
            " bshpwNroi integer not null , " +
            " bshpwDire text not null , " +
            " bshpwClas integer not null , " +
            " bshpwIplv integer not null , " +
            " bshpwNfac integer not null , " +
            " bshpwNtpc integer not null , " +
            " bshpwNtcn integer not null , " +
            " bshpwNdtb integer not null , " +
            " bshpwOnof integer not null , " +
            " bshpwLmax integer not null , " +
            " bshpwConp integer not null , " +
            " bshpwKvat integer not null , " +
            " bshpwCobs integer not null , " +
            " bshpwNlec integer not null , " +
            " bshpwPtjc integer not null , " +
            " bshpwStad integer not null , " +
            " bshpwLati text not null , " +
            " bshpwLong text not null , " +
            " bshpwStat integer not null , " +
            " bshpwRide integer not null ); ";


    // TABLA 2 DETALLE AVISO COBRANZA
    public static  String NOMTADPW="bsdpw";
    public static String COLBSDPWNHPF="bsdpwNhpf";
    public static String COLBSDPWORDE="bsdpwOrde";
    public static String COLBSDPWNHPC="bsdpwNhpc";
    public static String COLBSDPWDHPC="bsdpwDhpc";
    public static String COLBSDPWNCAT="bsdpwNcat";
    public static String COLBSDPWDCAT="bsdpwDcat";
    public static String COLBSDPWNCTA="bsdpwNcta";
    public static String COLBSDPWCMON="bsdpwCmon";
    public static String COLBSDPWTCAM="bsdpwTcam";
    public static String COLBSDPWCANT="bsdpwCant";
    public static String COLBSDPWPUNI="bsdpwPuni";
    public static String COLBSDPWIMPT="bsdpwImpt";
    public static String COLBSDPWCREF="bsdpwCref";
    public static String COLBSDPWFACI="bsdpwFaci";
    public static String COLBSDPWINEX="bsdpwInex";
    public static String COLBSDPWCPRD="bsdpwCprd";
    public static String COLBSDPWNTPO="bsdpwNtpo";
    public static String COLBSDPWNTPC="bsdpwNtpc";
    public static String COLBSDPWSTAD="bsdpwStad";
    public static String COLBSDPWSTAT="bsdpwStat";
    public static String COLBSDPWRIDE="bsdpwRide";
    public static String [] COLSBSDPW={ COLBSDPWNHPF,COLBSDPWORDE,COLBSDPWNHPC,COLBSDPWDHPC,COLBSDPWNCAT,COLBSDPWDCAT,
            COLBSDPWNCTA,COLBSDPWCMON,COLBSDPWTCAM,COLBSDPWCANT,COLBSDPWPUNI,COLBSDPWIMPT,
            COLBSDPWCREF,COLBSDPWFACI,COLBSDPWINEX,COLBSDPWCPRD,COLBSDPWNTPO,COLBSDPWNTPC,
            COLBSDPWSTAD,COLBSDPWSTAT,COLBSDPWRIDE};
    public static String CTBSDPW="create table bsdpw (  " +
            " bsdpwNhpf integer not null , " +
            " bsdpwOrde integer not null , " +
            " bsdpwNhpc integer not null , " +
            " bsdpwDhpc text not null ," +
            " bsdpwNcat integer not null ," +
            " bsdpwDcat text not null ," +
            " bsdpwNcta text not null ," +
            " bsdpwCmon integer not null ," +
            " bsdpwTcam real not null ," +
            " bsdpwCant real not null ," +
            " bsdpwPuni real not null ," +
            " bsdpwImpt real not null ," +
            " bsdpwCref text not null ," +
            " bsdpwFaci real not null ," +
            " bsdpwInex text not null ," +
            " bsdpwCprd integer not null ," +
            " bsdpwNtpo integer not null ," +
            " bsdpwNtpc integer not null ," +
            " bsdpwStad integer not null ," +
            " bsdpwStat integer not null ," +
            " bsdpwRide integer not null ); ";


    // TABLA 3 :  ZONAS
    public static  String NOMTALTZON="ltZon";
    public static String COLLTZONNZON="ltZonNzon";
    public static String COLLTZONDZON="ltZonDzon";
    public static String COLLTZONRNGO="ltZonRngo";
    public static String COLLTZONCREH="ltZonCreh";
    public static String COLLTZONCRED="ltZonCred";
    public static String COLLTZONCRHI="ltZonCrhi";
    public static String [] COLSLTZON={COLLTZONNZON,COLLTZONDZON,COLLTZONRNGO,COLLTZONCREH,COLLTZONCRED,COLLTZONCRHI};
    public static String CTLTZON="create table ltZon (  " +
            " ltZonNzon integer not null ," +
            " ltZonDzon text not null , " +
            " ltZonRngo integer not null , " +
            " ltZonCreh integer not null , " +
            " ltZonCred integer not null ," +
            " ltZonCrhi integer not null ); " ;


    // TABLA 4 : TARIFAS
    public static  String NOMTATAW="bstaw";
    public static String COLBSTAWANIO ="bstawanio";
    public static String COLBSTAWMESF ="bstawmesf";
    public static String COLBSTAWNSER ="bstawnser";
    public static String COLBSTAWNOSE ="bstawnose";
    public static String COLBSTAWNHPC ="bstawnhpc";
    public static String COLBSTAWNOCO ="bstawnoco";
    public static String COLBSTAWNCAT ="bstawncat";
    public static String COLBSTAWNOCA ="bstawnoca";
    public static String COLBSTAWFIVA ="bstawfiva";
    public static String COLBSTAWVAFA ="bstawvafa";
    public static String COLBSTAWDESD ="bstawdesd";
    public static String COLBSTAWHAST ="bstawhast";
    public static String COLBSTAWCMON ="bstawcmon";
    public static String COLBSTAWVAL1 ="bstawval1";
    public static String COLBSTAWVAL2 ="bstawval2";
    public static String COLBSTAWSTAT ="bstawstat";
    public static String [] COLSBSTAW={COLBSTAWANIO,COLBSTAWMESF,COLBSTAWNSER,COLBSTAWNOSE,COLBSTAWNHPC,COLBSTAWNOCO,
                                       COLBSTAWNCAT,COLBSTAWNOCA,COLBSTAWFIVA,COLBSTAWVAFA,COLBSTAWDESD,
                                       COLBSTAWHAST,COLBSTAWCMON,COLBSTAWVAL1,COLBSTAWVAL2,COLBSTAWSTAT};
    public static String CTBSTAW=" create table bstaw (  " +
            " bstawanio integer not null , " +
            " bstawmesf integer not null, " +
            " bstawnser integer not null, " +
            " bstawnose text not null, " +
            " bstawnhpc integer not null, " +
            " bstawnoco text not null, " +
            " bstawncat integer not null, " +
            " bstawnoca text not null, " +
            " bstawfiva text not null, " +
            " bstawvafa text not null, " +
            " bstawdesd integer not null, " +
            " bstawhast integer not null, " +
            " bstawcmon integer not null, " +
            " bstawval1 real not null, " +
            " bstawval2 real not null, " +
            " bstawstat integer not null ); ";

    // TABLA 5 : PARAMETROS EMPRESA
    public static  String NOMTAENW="bsenw";
    public static String COLBSENWIMPR = "bsenwImpr";
    public static String COLBSENWNOMB = "bsenwNomb";
    public static String COLBSENWSIGL = "bsenwSigl";
    public static String COLBSENWNNIT = "bsenwNnit";
    public static String COLBSENWDIRE = "bsenwDire";
    public static String COLBSENWTELF = "bsenwTelf";
    public static String COLBSENWANIO = "bsenwAnio";
    public static String COLBSENWMESF = "bsenwMesf";
    public static String COLBSENWDMES = "bsenwDmes";
    public static String COLBSENWNHPC = "bsenwNhpc";
    public static  String [] COLSBSENW ={COLBSENWIMPR, COLBSENWNOMB,COLBSENWSIGL,COLBSENWNNIT,COLBSENWDIRE,
                                         COLBSENWTELF,COLBSENWANIO,COLBSENWMESF,COLBSENWDMES, COLBSENWNHPC};
    public static String CTBSENW=" create table bsenw (  " +
            " bsenwImpr int not null , " +
            " bsenwNomb text not null , " +
            " bsenwSigl text not null , " +
            " bsenwNnit text not null , " +
            " bsenwDire text not null , " +
            " bsenwTelf text not null , " +
            " bsenwAnio int not null , " +
            " bsenwMesf int not null , " +
            " bsenwDmes text not null , " +
            " bsenwNhpc int not null  ); " ;


    // TABLA 6 : OBSERVACIONES
    public static  String NOMTAOBW="bsobw";
    public static String COLBSOBWCODO = "bsobwCodo";
    public static String COLBSOBWDESC = "bsobwDesc";
    public static  String [] COLSBSOBW ={COLBSOBWCODO,COLBSOBWDESC};
    public static String CTBSOBW=" create table bsobw (  " +
            " bsobwCodo int not null , " +
            " bsobwDesc text not null); " ;


    // TABLA 7 : CENTROS DE COBRANZA
    public static  String NOMTABSCCW="bsccw";
    public static String COLBSCCWCODO = "bsccwCodo";
    public static String COLBSCCWDESC = "bsccwDesc";
    public static  String [] COLSBSCCW ={COLBSCCWCODO,COLBSCCWDESC};
    public static String CTBSCCW=" create table bsccw (  " +
            " bsccwCodo int not null , " +
            " bsccwDesc text not null); " ;


    // TABLA 8 : HISTORICOS DE PAGO
    public static  String NOMTABSDHW="bsdhw";
    public static String COLBSDHWNHPF = "bsdhwNhpf";
    public static String COLBSDHWORDE = "bsdhwOrde";
    public static String COLBSDHWPERI = "bsdhwPeri";
    public static String COLBSDHWCONS = "bsdhwCons";
    public static String COLBSDHWIMPT = "bsdhwImpt";
    public static String COLBSDHWSTAD = "bsdhwStad";

    public static  String [] COLSBSDHW ={COLBSDHWNHPF,COLBSDHWORDE,COLBSDHWPERI,COLBSDHWCONS,COLBSDHWIMPT,COLBSDHWSTAD};
    public static String CTBSDHW=" create table bsdhw (  " +
            " bsdhwNhpf int not null , " +
            " bsdhwOrde int not null , " +
            " bsdhwPeri int not null , " +
            " bsdhwCons int not null , " +
            " bsdhwImpt int not null , " +
            " bsdhwStad int not null); " ;


    /*
    private static String openOrCreateDatabase(){
        //Quitar comentario para guardar la db externa

        boolean isSDPresent = android.os.Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED);
         */
    String path = DATABASE_NAME;

    /*
    if (isSDPresent) {
        path = createDbFolder();
        if (path != null) {
            path = path + "/" + DATABASE_NAME;
            SQLiteDatabase.openOrCreateDatabase(path, null);
        }
    }

    return path;
}
*/
    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CTUSUARIO);
        db.execSQL(CTEMPLEADO);
        db.execSQL(CTMEDIDOR);
        db.execSQL(CTPARAMETROS);
        db.execSQL(CTSOCIO);
        db.execSQL(CTLECTURACION);
        db.execSQL(CTCNF);
        db.execSQL(CTLTZON);
        db.execSQL(CTBSTAW);
        db.execSQL(CTBSHPW);
        db.execSQL(CTBSDPW);
        db.execSQL(CTBSENW);
        db.execSQL(CTBSOBW);
        db.execSQL(CTBSCCW);
        db.execSQL(CTBSDHW);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int OldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CTUSUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + CTEMPLEADO);
       db.execSQL("DROP TABLE IF EXISTS " + CTMEDIDOR);
        db.execSQL("DROP TABLE IF EXISTS " + CTPARAMETROS);
        db.execSQL("DROP TABLE IF EXISTS " + CTSOCIO);
       // db.execSQL("DROP TABLE IF EXISTS " + CTLECTURACION);
        db.execSQL("DROP TABLE IF EXISTS " + CTCNF);
        db.execSQL("DROP TABLE IF EXISTS " + CTLTZON);
        db.execSQL("DROP TABLE IF EXISTS " + CTBSTAW);
        db.execSQL("DROP TABLE IF EXISTS " + CTBSHPW);
        db.execSQL("DROP TABLE IF EXISTS " + CTBSDPW);
        db.execSQL("DROP TABLE IF EXISTS " + CTBSENW);
        db.execSQL("DROP TABLE IF EXISTS " + CTBSOBW);
        db.execSQL("DROP TABLE IF EXISTS " + CTBSCCW);
        db.execSQL("DROP TABLE IF EXISTS " + CTBSDHW);
        onCreate(db);
    }


}
