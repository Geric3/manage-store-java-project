/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_de_donnée;

/**
 *
 * @author Roger
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


import java.io.FileOutputStream;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import com.mysql.jdbc.Driver;

public class NewClass {

    public static void main(String[] args) {

        // - Paramètres de connexion à la base de données
        String url = "jdbc:mysql://localhost/gestion_de_stock";
        String login = "root";
        String password = "";
        Connection connection = null;

        try {
            // - Connexion à la base
            Driver monDriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(monDriver);
            connection = DriverManager.getConnection(url, login, password);

            // - Chargement et compilation du rapport
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Roger\\Documents\\RAPPORT_progra\\classik.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            // - Paramètres à envoyer au rapport
            Map parameters = new HashMap();
            parameters.put("Titre", "Titre");

            // - Execution du rapport
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

            // - Création du rapport au format PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "E:\\classik.pdf");
        } catch (JRException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            try {
                 connection.close();
                } catch (SQLException e) {

                        e.printStackTrace();
                }
        }

    }
}
