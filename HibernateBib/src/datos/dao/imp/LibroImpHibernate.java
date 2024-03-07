package datos.dao.imp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import controlador.HibernateUtil;
import datos.Libro;
import datos.dao.LibroDAO;

public class LibroImpHibernate implements LibroDAO{

	private Session sesion;

	public LibroImpHibernate() {
		//obtener la fábrica de la conexión actual para crear una sesión
		sesion = HibernateUtil.getSessionFactory().openSession();
	}

	@Override
	public void insertar(Libro l) {
		Transaction tx = null;
		try {
			tx = sesion.beginTransaction();
			sesion.save(l);
			tx.commit();
		}
		catch (Exception e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public Libro leer(int id) {
		Libro l = sesion.get(Libro.class, id);
		return l;
	}

	@Override
	public void modificar(int id, Libro l2) {
		Transaction tx = null;
		try {
			tx = sesion.beginTransaction();
			Libro l = this.leer(id);
			// ....
			l.setAutor(l2.getAutor());
			// ....
			sesion.update(l);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
	}

	@Override
	public void eliminar(int id) {
		Transaction tx = null;
		try {
			tx = sesion.beginTransaction();
			Libro l = this.leer(id);
			sesion.delete(l);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
	}

}
