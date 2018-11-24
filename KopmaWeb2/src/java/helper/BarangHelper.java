/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Barang;
import util.KopmaHibernateUtil;

/**
 *
 * @author basisd10
 */
public class BarangHelper {

    public List<Barang> getAllBarang() {
        List<Barang> result = null;
        Session session = KopmaHibernateUtil.getSessionFactory().openSession();
        String query = "from Barang b";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }

    public void addNewBarang(String ID_Barang, String nama, int stok, double harga) {
        Session session = KopmaHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Barang Barang = new Barang( ID_Barang,  nama, stok, harga);
        session.saveOrUpdate(Barang);
        transaction.commit();
        session.close();
    }
    
}
