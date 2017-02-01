package edu.knoldus

import java.sql._

/**
  * Created by gitik on 01-02-2017.
  */
class DepartmentOperation {

  val conn = ConnectionFactory.getConnection()

  def create(id: Int, name: String): Int = {

    conn match {
      case Some(c) => {
        try {
          val statement = c.prepareStatement("insert into Department values(?,?)")
          statement.setInt(1, id)
          statement.setString(2, name)
          val resCreate = statement.executeUpdate()
          resCreate
        }
        catch {
          case ex: SQLException => {
            println("SQL Exception " + ex.getMessage)
            -2
          }
        }
      }
      case None => {
        println("Connection Failed!")
        -1
      }
    }
  }

  case class Department(id: Int, name: String)

}
