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
import service.PegawaiResource;
import util.KopmaHibernateUtil;

/**
 *
 * @author basisd10
 */
public class PegawaiHelper {
    
    public List<Pegawai> getAllPegawai() {
        List<Pegawai> result = null;
        Session session = KopmaHibernateUtil.getSessionFactory().openSession();
        String query = "from Pegawai pg";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
    
    public void addNewPegawai(String idPegawai,String nama,String noTelp,String alamat,String username,String password) {
        Session session = KopmaHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Pegawai pegawai = new Pegawai(idPegawai,nama,noTelp,alamat,username,password);
        session.saveOrUpdate(pegawai);
        transaction.commit();
        session.close();
    }
    
    public Pegawai login(String username, String password) {
        Session session = KopmaHibernateUtil.getSessionFactory().openSession();
        String q = "From Pegawai a where a.username=:username AND a.password =:password";

        Query query = session.createQuery(q);
        query.setParameter("username", username);
        query.setParameter("password", password);

        return (Pegawai) query.uniqueResult();
    }
}
