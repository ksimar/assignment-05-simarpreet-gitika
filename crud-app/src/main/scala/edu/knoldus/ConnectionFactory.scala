package edu.knoldus

import java.sql.{Connection, DriverManager}

/**
  * Created by gitik on 01-02-2017.
  */
object ConnectionFactory {

  def getConnection() :Option[Connection] = {
    try{
      Class.forName("com.mysql.jdbc.Driver").newInstance
      val url = "jdbc:mysql://sql6.freesqldatabase.com:3306/sql6156536"
      val username = "sql6156536"
      val password = "eaJNhCrshF"
      val dbc :Connection = DriverManager.getConnection(url,username,password)
      println("Connection Established!")
      Some(dbc)
    }
    catch{
      case ex: Exception => println("SQL Exception"+ex.getMessage)
        None
    }

  }

}
