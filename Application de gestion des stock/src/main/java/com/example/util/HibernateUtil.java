package com.example.util;

import com.example.classes.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration cfg = new Configuration();
            Properties props = new Properties();
            props.load(new FileInputStream("src/main/resources/application.properties"));
            cfg.setProperties(props);

            // register annotated classes
            cfg.addAnnotatedClass(Produit.class);
            cfg.addAnnotatedClass(Categorie.class);
            cfg.addAnnotatedClass(Commande.class);
            cfg.addAnnotatedClass(LigneCommande.class);

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(cfg.getProperties());
            return cfg.buildSessionFactory(builder.build());
        } catch (Exception ex) {
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}

