package app;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import controlador.HibernateUtil;
import datos.Libro;

public class ConsultaLibrosPrestados {
	
	public static void main(String[] args) {
		// ------------------UTILIZAMOS LO DEFINIDO ANTES-------------
		//obtener la fábrica de la conexión actual para crear una sesi�n
		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		//------------------------------------------------------------
		// creamos la sesión
		Session sesion = fabrica.openSession();	
		// creamos la transacción de la sesión
		Transaction tx = sesion.beginTransaction();

		String consulta = "select distinct titulo, autor from Libro where codigo not in (select id.csocio from Prestamo)";
		Query<Object> q = sesion.createQuery(consulta);
		
		
		List <Object> lista = q.list();
		// Obtenemos un Iterador y recorremos la lista.
		Iterator <Object> iter = lista.iterator();
				
		while (iter.hasNext()){
		   //extraer el objeto
			Object varioscampos = (Object)iter.next();
			Object[] resultadosString = (Object[])varioscampos;
			System.out.println("titulo=" + (String)resultadosString[0] + "; autor=" + (String)resultadosString[1]);		   
		}

		
	}

	


}
