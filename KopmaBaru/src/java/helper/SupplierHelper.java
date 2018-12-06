package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Pegawai;
import pojos.Supplier;
import util.kopmaHibernateUtil;

/**
 *
 * @author basisd10
 */
public class SupplierHelper {
    public List<Supplier> getAllSupplier() {
        List<Supplier> result = null;
        Session session = kopmaHibernateUtil.getSessionFactory().openSession();
        String query = "from Supplier s";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
    
    public void addNewSupplier(String idSupplier, String nama, String noTelp, String alamat, String username, String password) {
        Session session = kopmaHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Supplier supplier = new Supplier(idSupplier,nama,noTelp,alamat,username,password);
        session.saveOrUpdate(supplier);
        transaction.commit();
        session.close();
    }
    
    public Supplier login(String username, String password) {
        Session session = kopmaHibernateUtil.getSessionFactory().openSession();
        String q = "From Supplier a where a.username=:username AND a.password =:password";

        Query query = session.createQuery(q);
        query.setParameter("username", username);
        query.setParameter("password", password);

        return (Supplier) query.uniqueResult();
    }
}
