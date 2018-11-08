/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Pegawai;
import pojos.Supplier;
import util.KopmaHibernateUtil;

/**
 *
 * @author basisd10
 */
public class SupplierHelper {
    public List<Supplier> getAllSupplier() {
        List<Supplier> result = null;
        Session session = KopmaHibernateUtil.getSessionFactory().openSession();
        String query = "from Supplier s";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
    
    public void addNewSupplier(String idSupplier, String nama, String noTelp, String alamat, String username, String password) {
        Session session = KopmaHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Supplier supplier = new Supplier(idSupplier,nama,noTelp,alamat,username,password);
        session.saveOrUpdate(supplier);
        transaction.commit();
        session.close();
    }
}
