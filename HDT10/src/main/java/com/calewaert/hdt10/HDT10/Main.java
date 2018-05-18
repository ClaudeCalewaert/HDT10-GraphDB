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
import java.io.File;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.shell.impl.SystemOutput;

public class Main 
{
    public static void main( String[] args )
    {
    	Scanner entradaUsuario = new Scanner(System.in);
    	File dbPath = new File("C:\\Users\\claud\\OneDrive\\Escritorio\\HDT10\\neo4j-community-3.3.5\\data\\databases\\graph.db");
    	Operaciones operacionesDB = new Operaciones();
    	
        GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
        GraphDatabaseService graphDB = dbFactory.newEmbeddedDatabase(dbPath);
        
        //------------------------------------------------ Menu principal-----------------------------------------------------
        
        //Variables
        int opcion = 0;
        int opcionEliminar = 0;
        String nombre;
        int colegiado;
        String especialidad;
        int telefono;
        
        
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
        //------- Seleccion de opciones --------
        
        switch (opcion) {
        	
        // Ingresar Medico
        case 1:
        	System.out.println("        Ingreso de medicos");
        	
        	System.out.print("\nIngrese el nombre del medico:   ");
        	nombre = entradaUsuario.nextLine();
        	
        	System.out.print("\nIngrese el no.colegiado del medico:   ");
        	colegiado = entradaUsuario.nextInt();

        	System.out.print("\nIngrese la especialidad del medico:   ");
        	especialidad = entradaUsuario.nextLine();
        	
        	System.out.print("\nIngrese el telefono del medico:   ");
        	telefono = entradaUsuario.nextInt();
        	
        	operacionesDB.ingresarDoctor(graphDB, nombre, colegiado, especialidad, telefono);
        	break;
        
       // Ingresar Paciente
        case 2:
        		
        	break;		
    
       // Ingresar Medicamento
        case 3:
        	
        		
        	break;	
        
        
        // Ingresar Visita
    	case 4:
    		
    		break;	
    		
        // Ingresar Relacion Conocido
        case 5:
        		
        	break;    	
        

        // Consultar Medico
    	case 6:
    		
    		break;
    		
       // Eliminar nodo
        case 7:
        	System.out.println("        Eliminar...");
        	System.out.print("\nIngrese la opcion que desea eliminar:   ");
        	System.out.println("1) Medico");
        	System.out.println("2) Paciente");
        	System.out.println("3) Medicamento");
        	opcionEliminar = entradaUsuario.nextInt();
        		
        		//Medico
        		if (opcionEliminar == 1) {
        			System.out.println("\n        Eliminar medico");
        			System.out.print("Ingrese el no.colegiado del medico a eliminar:   ");
        			colegiado = entradaUsuario.nextInt();
        			
        			operacionesDB.eliminarDoctor(graphDB, colegiado);
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
        Operaciones.registerShutdownHook( graphDB );
    }	
    	
 }

