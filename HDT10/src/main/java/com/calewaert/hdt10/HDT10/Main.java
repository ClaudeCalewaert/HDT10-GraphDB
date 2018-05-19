package com.calewaert.hdt10.HDT10;

/* Base de datos basada en grafos
 * Utilizando neo4j
 * Como extra:
 * Se puede acceder a este desde el navegador web por medio de http://localhost:7474
 * Primero se debe iniciar el servidor de neo4j desde el cmd
 * Usuario: neo4j
 * Password: 1234
*/

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.File;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.shell.impl.SystemOutput;

import scala.Console;

public class Main 
{
    public static void main( String[] args )
    {
    	
    	
    	Scanner entradaUsuario = new Scanner(System.in);
    	File dbPath = new File("C:\\Users\\claud\\OneDrive\\Escritorio\\HDT10\\neo4j-community-3.3.5\\data\\databases\\graph.db");
    	Operaciones operacionesDB = new Operaciones();
    	
        GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
        GraphDatabaseService graphDB = dbFactory.newEmbeddedDatabase(dbPath);
        
        //------------------------------------------------ MENU PRINCIPAL -----------------------------------------------------
        
        //Variables
        int opcion = 0;
        int opcionEliminar = 0;
        String nombre = null;
        int colegiado = 0;
        String especialidad = null;
        int telefono = 0;
        String fechaInicio = null;
        String fechaFin = null;
        String dosis = null;
        
        
        while (opcion != 8 ) {
        
        System.out.println("          Sistema de recomendacion de medicos\n");
        System.out.println("Porfavor ingrese una opcion:\n");
        
        System.out.println("1) Ingresar medico");
        System.out.println("2) Ingresar paciente");
        System.out.println("3) Ingresar medicamento");
        System.out.println("4) Ingresar visita");
        System.out.println("5) Ingresar relacion de conocido");
        System.out.println("6) Consultar medico");
        System.out.println("7) Eliminar medico/paciente/medicamento");
        System.out.println("8) Salir\n");
        
        opcion = entradaUsuario.nextInt();
        System.out.println("\n");
        entradaUsuario.nextLine();
        //------------------------------------------------ OPCIONES -----------------------------------------------------
        
        switch (opcion) {
        
        
        	
        //-------------------- INGRESO MEDICOS ---------------------
        
        case 1:
        	System.out.println("        Ingreso de Medicos");
        	
        	
        	//---- Nombre ----
        	
        	System.out.print("\nIngrese el nombre del medico:   ");
        	try { //Evita que el programa entre en conflicto si se ingresa un dato erroneo por el usuario
        	nombre = entradaUsuario.nextLine();
        	}
        	catch(Exception e){
        		System.out.println("\nVerifique que ha ingresado correctamente el dato");
        		System.out.println("Saliendo de ingreso de medico...");
        		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
        		operacionesDB.esperar();
        		break;
        	}
        	
        	
        	//---- Colegiado ----
        	
        	System.out.print("\nIngrese el no.colegiado del medico:   ");
        	try { //Evita que el programa entre en conflicto si se ingresa un dato erroneo por el usuario
        	colegiado = entradaUsuario.nextInt();
        	entradaUsuario.nextLine();
        	}
        	catch (Exception e) {
        		System.out.println("\nVerifique que ha ingresado correctamente el dato");
        		System.out.println("Saliendo de ingreso de medico...");
        		operacionesDB.esperar();
        		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
        		break;
        	}
        	
        	//---- Especialidad ----
        	
        	System.out.print("\nIngrese la especialidad del medico:   ");
        	try { //Evita que el programa entre en conflicto si se ingresa un dato erroneo por el usuario
        	especialidad = entradaUsuario.nextLine();
        	}
        	catch (Exception e) {
        		System.out.println("\nVerifique que ha ingresado correctamente el dato");
        		System.out.println("Saliendo de ingreso de medico...");
        		operacionesDB.esperar();
        		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
        		break;
        	}
        	
        	
        	//---- Telefono ----
        	
        	System.out.print("\nIngrese el telefono del medico:   ");
        	try { //Evita que el programa entre en conflicto si se ingresa un dato erroneo por el usuario
        	telefono = entradaUsuario.nextInt();
        	entradaUsuario.nextLine();
        	}
        	catch (Exception e) {
        		System.out.println("\nVerifique que ha ingresado correctamente el dato");
        		System.out.println("Saliendo de ingreso de medico...");
        		operacionesDB.esperar();
        		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
        		break;
        	}
        	
        	//---- Ingreso a BD ----
        	
        	operacionesDB.ingresarDoctor(graphDB, nombre, colegiado, especialidad, telefono);
        	operacionesDB.esperar(); //delay
        	break;
        	
        
        //-------------------- INGRESO PACIENTES ---------------------
       
        case 2:
        	System.out.println("        Ingreso de Pacientes");
        	
        	
        	//---- Nombre ----
        	
        	System.out.print("\nIngrese el nombre del paciente:   ");
        	try { //Evita que el programa entre en conflicto si se ingresa un dato erroneo por el usuario
        	nombre = entradaUsuario.nextLine();
        	}
        	catch(Exception e){
        		System.out.println("\nVerifique que ha ingresado correctamente el dato");
        		System.out.println("Saliendo de ingreso de paciente...");
        		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
        		operacionesDB.esperar();
        		break;
        	}
        	
     
        	//---- Telefono ----
        	
        	System.out.print("\nIngrese el telefono del paciente:   ");
        	try { //Evita que el programa entre en conflicto si se ingresa un dato erroneo por el usuario
        	telefono = entradaUsuario.nextInt();
        	entradaUsuario.nextLine();
        	}
        	catch (Exception e) {
        		System.out.println("\nVerifique que ha ingresado correctamente el dato");
        		System.out.println("Saliendo de ingreso de paciente...");
        		operacionesDB.esperar();
        		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
        		break;
        	}
        	
        	//---- Ingreso a BD ----
        	
        	operacionesDB.ingresarPaciente(graphDB, nombre, telefono);
        	operacionesDB.esperar(); //delay	
        	break;		
    
        //-------------------- INGRESO MEDICAMENTOS ---------------------
        	
        case 3:
        	
        	System.out.println("        Ingreso de Medicamentos");
        	
        	
        	//---- Nombre ----
        	
        	System.out.print("\nIngrese el nombre del medicamento:   ");
        	try { //Evita que el programa entre en conflicto si se ingresa un dato erroneo por el usuario
        	nombre = entradaUsuario.nextLine();
        	}
        	catch(Exception e){
        		System.out.println("\nVerifique que ha ingresado correctamente el dato");
        		System.out.println("Saliendo de ingreso de medicamento...");
        		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
        		operacionesDB.esperar();
        		break;
        	}
        	
        	
        	//---- Fecha Inicio ----
        	
        	System.out.print("\nIngrese la fecha de inicio del medicamento:   ");
        	try { //Evita que el programa entre en conflicto si se ingresa un dato erroneo por el usuario
        	fechaInicio = entradaUsuario.nextLine();
        	}
        	catch (Exception e) {
        		System.out.println("\nVerifique que ha ingresado correctamente el dato");
        		System.out.println("Saliendo de ingreso de medicamento...");
        		operacionesDB.esperar();
        		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
        		break;
        	}
        	
        	//---- Fecha de fin ----
        	
        	System.out.print("\nIngrese la fecha de fin del medicamento :   ");
        	try { //Evita que el programa entre en conflicto si se ingresa un dato erroneo por el usuario
        	fechaFin = entradaUsuario.nextLine();
        	}
        	catch (Exception e) {
        		System.out.println("\nVerifique que ha ingresado correctamente el dato");
        		System.out.println("Saliendo de ingreso de medicamento...");
        		operacionesDB.esperar();
        		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
        		break;
        	}
        	
        	
        	//---- Dosis ----
        	
        	System.out.print("\nIngrese la dosis del medicamento :   ");
        	try { //Evita que el programa entre en conflicto si se ingresa un dato erroneo por el usuario
        	dosis = entradaUsuario.nextLine();
        	}
        	catch (Exception e) {
        		System.out.println("\nVerifique que ha ingresado correctamente el dato");
        		System.out.println("Saliendo de ingreso de medicamento...");
        		operacionesDB.esperar();
        		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
        		break;
        	}
        	
        	
        	//---- Ingreso a BD ----
        	
        	operacionesDB.ingresarMedicamento(graphDB, nombre, fechaInicio, fechaFin, dosis);
        	operacionesDB.esperar(); //delay
        	break;
        		
        
        
        //---------------------- INGRESO VISITA --------------------------
    	case 4:
    		String paciente = null;
    		String medico = null;
    		String fecha = null;
    		
    		System.out.println("        Establecer Visita");
        	System.out.print("\nIngrese el nombre del paciente:   ");
        	try { //Evita que el programa entre en conflicto si se ingresa un dato erroneo por el usuario
            	paciente = entradaUsuario.nextLine();
            	}
            	catch (Exception e) {
            		System.out.println("\nVerifique que ha ingresado correctamente el dato");
            		System.out.println("Saliendo de establecer visita ...");
            		operacionesDB.esperar();
            		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
            		break;
            	}
        	
        	System.out.print("\nIngrese el nombre del medico:   ");
        	try { //Evita que el programa entre en conflicto si se ingresa un dato erroneo por el usuario
            	medico = entradaUsuario.nextLine();
            	}
            	catch (Exception e) {
            		System.out.println("\nVerifique que ha ingresado correctamente el dato");
            		System.out.println("Saliendo de establecer visita ...");
            		operacionesDB.esperar();
            		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
            		break;
            	}
        	
        	operacionesDB.ingresarVisita(graphDB, paciente, medico, fecha);
    		break;	
    		
    	//----------------- INGRESO RELACION CONOCIDO ---------------------
        case 5:
        	String nombrePersona1 = null;
        	String nombrePersona2 = null;
        	Label denominacion1 = null;
        	Label denominacion2 = null;
        	int tipoDenominacion = 0;
        	
        	System.out.println("        Establecer Relacion Conoce");
        	System.out.print("\nIngrese el nombre de la primera persona:   ");
        	
        	try { //Evita que el programa entre en conflicto si se ingresa un dato erroneo por el usuario
        	nombrePersona1 = entradaUsuario.nextLine();
        	}
        	catch (Exception e) {
        		System.out.println("\nVerifique que ha ingresado correctamente el dato");
        		System.out.println("Saliendo de establecer relacion conoce ...");
        		operacionesDB.esperar();
        		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
        		break;
        	}
        	
        	System.out.println("\nIngrese el tipo de denominacion de la persona:   ");
        	System.out.println("1) Medico");
        	System.out.println("2) Paciente");
        	
        	try {
        	tipoDenominacion = entradaUsuario.nextInt();
        	}
        	catch (Exception e) {
        		System.out.println("\nVerifique que ha ingresado correctamente el dato");
        		System.out.println("Saliendo de establecer relacion conoce ...");
        		operacionesDB.esperar();
        		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
        		break;
        	}
        	
        	if (tipoDenominacion == 1) {
        		denominacion1 = Denominacion.DOCTOR;
        	}
        	
        	else if (tipoDenominacion == 2) {
        		denominacion1 = Denominacion.PACIENTE;
        	}
        	
        	System.out.print("\nIngrese el nombre de la segunda persona:   ");
        	entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
        	
        	try {
        	nombrePersona2 = entradaUsuario.nextLine();
        	}
        	catch (Exception e) {
        		System.out.println("\nVerifique que ha ingresado correctamente el dato");
        		System.out.println("Saliendo de establecer relacion conoce ...");
        		operacionesDB.esperar();
        		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
        		break;
        	}
        	
        	System.out.println("\nIngrese el tipo de denominacion de la persona:   ");
        	System.out.println("1) Medico");
        	System.out.println("2) Paciente");
        	
        	try {
        	tipoDenominacion = entradaUsuario.nextInt();
        	}
        	catch (Exception e) {
        		System.out.println("\nVerifique que ha ingresado correctamente el dato");
        		System.out.println("Saliendo de establecer relacion conoce ...");
        		operacionesDB.esperar();
        		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
        		break;
        	}
        	
        	if (tipoDenominacion == 1) {
        		denominacion2 = Denominacion.DOCTOR;
        	}
        	
        	else if (tipoDenominacion == 2) {
        		denominacion2 = Denominacion.PACIENTE;
        	}
        	
        	// Ingreso a DB
        	operacionesDB.ingresarConoce(graphDB, denominacion1, nombrePersona1, denominacion2, nombrePersona2);
        	operacionesDB.esperar();
        	break;    	
        

        //--------------------- CONSULTAR MEDICO --------------------------
        	
    	case 6:
    		
    		break;
    		
    	//----------------------- ELIMINAR NODO ---------------------------
        case 7:
        	System.out.println("        Eliminar...");
        	System.out.println("\nIngrese la opcion que desea eliminar:   ");
        	System.out.println("1) Medico");
        	System.out.println("2) Paciente");
        	System.out.println("3) Medicamento");
        	opcionEliminar = entradaUsuario.nextInt();
        	
        		// ELIMINAR MEDICO
        	
        		if (opcionEliminar == 1) {
        			System.out.println("\n        Eliminar medico");
        			System.out.print("Ingrese el no.colegiado del medico a eliminar:   ");
        			try {
        			colegiado = entradaUsuario.nextInt();
        			}
        			catch (Exception e){
        				System.out.println("Verifique que ha ingresado correctamente el dato");
                		System.out.println("Saliendo de eliminacion de medico...");
                		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
                		break;
        			}
        			
        			operacionesDB.eliminarDoctor(graphDB, colegiado);
        			operacionesDB.esperar(); //Delay
        		}
        		
        		// ELIMINAR PACIENTE
            	
        		else if (opcionEliminar == 2) {
        			System.out.println("\n        Eliminar Paciente");
        			System.out.print("Ingrese el nombre del paciente a eliminar:   ");
        			entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
        			try {
        			nombre = entradaUsuario.nextLine();
        			}
        			catch (Exception e){
        				System.out.println("Verifique que ha ingresado correctamente el dato");
                		System.out.println("Saliendo de eliminacion de paciente...");
                		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
                		break;
        			}
        			
        			operacionesDB.eliminarPaciente(graphDB, nombre);
        			operacionesDB.esperar(); //Delay
        		}
        		
        		// ELIMINAR MEDICAMENTO
            	
        		if (opcionEliminar == 3) {
        			System.out.println("\n        Eliminar Medicamento");
        			System.out.print("Ingrese el nombre del medicamento a eliminar:   ");
        			try {
        			entradaUsuario.nextLine();
        			nombre = entradaUsuario.nextLine();
        			}
        			catch (Exception e){
        				System.out.println("Verifique que ha ingresado correctamente el dato");
                		System.out.println("Saliendo de eliminacion de medicamento...");
                		entradaUsuario.nextLine(); //Recibe entrada en caso quedara un valor en espera, evita fallos
                		break;
        			}
        			
        			operacionesDB.eliminarMedicamento(graphDB, nombre);
        			operacionesDB.esperar(); //Delay
        		}
        		
        	break;  
        	
       // Salir del menu
        case 8:
        	System.out.println("Saliendo del programa...");	
        	break; 
    }
      //------- Fin Seleccion de opciones -------- 
       
        }
        
      //------------------------------------------------ Fin Menu -----------------------------------------------------
       
        
        Operaciones.registerShutdownHook( graphDB ); //Se asegura que el servidor cierre correctamente
        System.out.println("Fin del programa");
    }	
    	
 }

