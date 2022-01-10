package Application;

	/*
	import java.beans.Statement;
	import java.net.Socket;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;*/
	import java.net.Socket;
	import java.sql.*;
	
	public class StatementBd {
	    
	    //les declaration
	    
	    Connection connection;
	    Statement statement;
	    String SQL;
	    
	    String url;
	      String username;
	      String password;
	      Socket client;
	      int port;
	      String host;
	      
	    public StatementBd(String url,String username,String password,String host,int port){
	        this.url=url;
	        this.username=username;
	        this.password=password;
	        this.host=host;
	        this.port=port;
	        
	    }
	    
	    //fonction pour faire la connection de la bd
	    
	    public Connection connexionDatabase() {
	        try{
	            Class.forName("com.mysql.jdbc.Driver");
	            connection=DriverManager.getConnection(url, username, password);
	        }catch(Exception e){
	         System.err.println(e.getMessage());//e.getMessage est pour afficher o� se trouve le pb exactement
	         
	    }
	        //afficher les erreur
	        return connection;
	    }
	    
	    //fonction pour fermer la bd
	    
	    public Connection closeconnexion(){
	       try{
	          connection.close();
	       }catch(Exception e){
	          System.err.println(e);
	       }
	       return connection;
	    }
	   
	    //pour l'execution des requetes
	    
	    public ResultSet exécutionQuery(String sql){
	       connexionDatabase();
	       ResultSet resultSet=null;
	       try{
	          statement=connection.createStatement();
	          resultSet=statement.executeQuery(sql);
	          System.out.println(sql);
	       }catch(SQLException ex){
	          System.err.println(ex);
	       }
	       return resultSet;
	    }
	    
	    //pour ex�cution des requetes update
	    
	    public String exécutionUpdate(String sql){
	        connexionDatabase();
	        String result="";
	        try{
	            statement=connection.createStatement();
	            statement.executeUpdate(sql);
	            result=sql;
	        }catch(SQLException ex){
	            result=ex.toString();
	        }
	        return result;
	    }
	    
	    //fonction de requette pour afficher tout
	    
	    public ResultSet querySelectAll(String nomTable){
	        connexionDatabase();
	        SQL="SELECT * FROM "+nomTable;
	        System.out.println(SQL);
	        return this.exécutionQuery(SQL);
	    }
	    
	    
	    //fonction pour afficher avec tous les parameter("etat")
	    
	    public ResultSet querySelectAll(String nomTable,String état){
	        connexionDatabase();
	        SQL="SELECT * FROM "+nomTable+ " WHERE " +état;
	        return this.exécutionQuery(SQL);
	    }
	    
	   /* public ResultSet querySelectAll2(String nomTable, String nom){
	        connexionDatabase();
	        SQL="SELECT * FROM "+nomTable+ " WHERE " +nom;
	        return this.ex�cutionQuery(SQL);
	    }*/
	    
	    //
	    public ResultSet querySelect(String[] nomColonne,String nomTable){
	        connexionDatabase();
	        int i;
	        SQL=" SELECT ";
	        
	        for(i=0; i<=nomColonne.length-1;i++){
	            SQL +=nomColonne[i];
	            if(i<nomColonne.length-1){
	                SQL +=" , ";
	                
	            }
	        }
	        SQL +=" from "+ nomTable;
	        System.out.print(SQL);
	        return this.exécutionQuery(SQL);
	        
	    }
	    
	    //
	    public ResultSet fcSelectCommand(String[] nomColonne,String nomTable,String état){
	        connexionDatabase();
	        int  i;
	        SQL=" SELECT ";
	        
	        for(i=0; i<=nomColonne.length-1;i++){
	            SQL +=nomColonne[i];
	            if(i<nomColonne.length-1){
	                SQL +="  ,";
	                
	            }
	        }
	        SQL +=" FROM " + nomTable+ "  WHERE  " +état;
	        return this.exécutionQuery(SQL);
	    
	    }
	    //fonction d'entr�e des donn�es
	    public String queryInsert(String nomTable, String[] contenuTableau){
	        connexionDatabase();
	        int  i;
	        SQL=" INSERT INTO "+ nomTable+ " VALUES(";
	        for(i=0;i<=contenuTableau.length-1;i++){
	            SQL +=" ' " +contenuTableau[i]+ " ' ";
	            if(i<contenuTableau.length-1){
	                SQL +=" , ";
	            }
	        }
	        SQL +=")";
	        return this.exécutionUpdate(SQL);
	    }
	    
	    //
	    public String queryInsert(String nomTable,String[] nomColonne,String[] contenuTableau){
	        connexionDatabase();
	        int  i;
	        SQL=" INSERT INTO " + nomTable+ "(";
	        for(i=0; i<=nomColonne.length-1;i++){
	            SQL +=nomColonne[i];
	            if(i<nomColonne.length-1){
	               SQL +="  ,";
	                
	            }
	        }
	       SQL +=") VALUES(";
	        for(i=0;i<=contenuTableau.length-1;i++){
	            SQL +=" ' "+contenuTableau[i]+ " ' ";
	            if(i<contenuTableau.length-1){
	                SQL +=",";
	            }
	        }
	        SQL +=")";
	        return this.exécutionUpdate(SQL);
	    }
	    //
	    
	    public String queryUpdate(String nomTable,String[] nomColonne,String[] contenuTableau,String état){
	       connexionDatabase();
	        int  i;
	        SQL="UPDATE "+ nomTable+" SET ";
	        for(i=0; i<=nomColonne.length-1;i++){
	            SQL +=nomColonne[i]+" = '" + contenuTableau[i] +"'";
	            if(i<nomColonne.length-1){
	                SQL +=" , ";
	                
	            }
	    
	        }
	        SQL +=" WHERE " + état;
	        return this.exécutionUpdate(SQL);
	    }    

	    //fonction pour la requete supprimer sans parameter
	    
	    public String queryDelete(String nomtable){
	       connexionDatabase();
	       SQL= " DELETE FROM "+ nomtable;
	       return this.exécutionUpdate(SQL);
	    }
	    
	    //fonction pour requete supprimer avec parameter
	    public String queryDelete(String nomtable,String état){
	       connexionDatabase();
	       SQL= " DELETE FROM "+ nomtable+ " WHERE " +état;
	       return this.exécutionUpdate(SQL);
	    }
	}



