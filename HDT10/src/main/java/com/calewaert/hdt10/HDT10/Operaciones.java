package com.calewaert.hdt10.HDT10;

import org.neo4j.cypher.internal.frontend.v2_3.ast.functions.Sum;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;

public class Operaciones {
	
	
	//---------------------------------------- INGRESAR DOCTOR -------------------------------------------------------------
	
	 public void ingresarDoctor(GraphDatabaseService graphdb, String nombre, int colegiado, String especialidad, int telefono) {
     	
     	try (Transaction tx = graphdb.beginTx()) {
     		// Operaciones de la base de datos
         	
         	Node doctor = graphdb.createNode(Denominacion.DOCTOR);
         	doctor.setProperty("Nombre", nombre);
         	doctor.setProperty("Colegiado", colegiado);
         	doctor.setProperty("Especialidad", especialidad);
         	doctor.setProperty("Telefono", telefono);
         	
         	System.out.println("Doctor ingresado con exito");
         	
     		tx.success();
     	}
	}
	 
	//---------------------------------------- ELIMINAR DOCTOR -------------------------------------------------------------
	 
	 public void eliminarDoctor(GraphDatabaseService graphdb, int colegiado) {
	     	
	     	try (Transaction tx = graphdb.beginTx()) {
	     		// Operaciones de la base de datos
	         	
	     		Node doctor = graphdb.findNode(Denominacion.DOCTOR, "Colegiado", colegiado);
	     		
	     		if (doctor != null) {
	     		doctor.delete();
	         	System.out.println("Doctor eleminado con exito");
	     		}
	     		
	     		if (doctor == null)
	     		System.out.println("No se ha encontrado ningun doctor con ese No. Colegiado");
	     		tx.success();
	     	}
		}

	//---------------------------------------- INGRESAR PACIENTE -------------------------------------------------------------
		
		 public void ingresarPaciente(GraphDatabaseService graphdb, String nombre, int telefono) {
	     	
	     	try (Transaction tx = graphdb.beginTx()) {
	     		// Operaciones de la base de datos
	         	
	         	Node paciente = graphdb.createNode(Denominacion.PACIENTE);
	         	paciente.setProperty("Nombre", nombre);
	         	paciente.setProperty("Telefono", telefono);
	         	
	         	System.out.println("Paciente ingresado con exito");
	         	
	     		tx.success();
	     	}
		}
	 
		//---------------------------------------- ELIMINAR PACIENTE -------------------------------------------------------------
			
		 public void eliminarPaciente(GraphDatabaseService graphdb, String nombre) {
	     	
	     	try (Transaction tx = graphdb.beginTx()) {
	     		// Operaciones de la base de datos
	         	
	     		Node paciente = graphdb.findNode(Denominacion.PACIENTE, "Nombre", nombre);
	     		
	     		if (paciente != null) {
	     		paciente.delete();
	         	System.out.println("Paciente eleminado con exito");
	     		}
	     		
	     		if (paciente == null)
	     		System.out.println("No se ha encontrado ningun paciente con ese nombre");
	         	
	     		tx.success();
	     	}
		}
	
		//---------------------------------------- INGRESAR MEDICAMENTO -------------------------------------------------------------
			
		 public void ingresarMedicamento(GraphDatabaseService graphdb,String nombre, String fechaInicio,  String fechaFin, String dosis) {
	     	
	     	try (Transaction tx = graphdb.beginTx()) {
	     		// Operaciones de la base de datos
	         	
	         	Node medicamento = graphdb.createNode(Denominacion.MEDICAMENTO);
	         	medicamento.setProperty("Nombre", nombre);
	         	medicamento.setProperty("Fecha de inicio", fechaInicio);
	         	medicamento.setProperty("Fecha de fin", fechaFin);
	         	medicamento.setProperty("Dosis", dosis);
	         	
	         	System.out.println("Medicamento ingresado con exito");
	         	
	     		tx.success();
	     	}
		}
		 
		//---------------------------------------- ELIMINAR MEDICAMENTO -------------------------------------------------------------
			
		 public void eliminarMedicamento(GraphDatabaseService graphdb,String nombre) {
	     	
	     	try (Transaction tx = graphdb.beginTx()) {
	     		// Operaciones de la base de datos
	         	
	     		Node medicamento = graphdb.findNode(Denominacion.MEDICAMENTO, "Nombre", nombre);
	     		
	     		if (medicamento != null) {
		     		medicamento.delete();
		         	System.out.println("Medicamento eleminado con exito");
		     		}
		     		
	     		if (medicamento == null)
		     		System.out.println("No se ha encontrado ningun Medicamento con ese nombre");
	         	
	     		tx.success();
	     	}
		}
		 
		//---------------------------------------- INGRESAR RElACION CONOCE -------------------------------------------------------------
			
		 public void ingresarConoce(GraphDatabaseService graphdb,Label denominacion, String nombrePresona1, String nombrePresona2) {
	     	
	     	try (Transaction tx = graphdb.beginTx()) {
	     		// Operaciones de la base de datos
	         	
	     		Node Persona1 = graphdb.findNode(denominacion, "Nombre", nombrePresona1);
	     		

	         	
	         	System.out.println("Medicamento ingresado con exito");
	         	
	     		tx.success();
	     	}
		}
		 
		//---------------------------------------- CERRAR DB -------------------------------------------------------------
		 
		 public static void registerShutdownHook( final GraphDatabaseService graphDb )
		 {
		     // Registers a shutdown hook for the Neo4j instance so that it
		     // shuts down nicely when the VM exits (even if you "Ctrl-C" the
		     // running application).
		     Runtime.getRuntime().addShutdownHook( new Thread()
		     {
		         @Override
		         public void run()
		         {
		             graphDb.shutdown();
		         }
		     } );
		 }
		 
		//---------------------------------------- ESPERAR DELAY -------------------------------------------------------------
		 
		 public void esperar() {
			 try {
	        		Thread.sleep(2000);
	        	}
	        	catch (Exception e){
	        	}
		 }
		 
		
		 
		 
}
