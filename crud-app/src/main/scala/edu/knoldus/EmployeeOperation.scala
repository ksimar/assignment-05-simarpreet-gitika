package edu.knoldus

import java.sql.SQLException

/**
  * Created by gitik on 01-02-2017.
  */
class EmployeeOperation {

  def create(id: Int, name: String, address: String, phone: String, deptId: Int, projectId: Int): Int = {
    val conn = ConnectionFactory.getConnection()
    conn match {
      case Some(c) => {
        try {
          val statement = c.prepareStatement("insert into Employee values(?,?,?,?,?,?)")
          statement.setInt(1, id)
          statement.setString(2, name)
          statement.setString(3, address)
          statement.setString(4, phone)
          statement.setInt(5, deptId)
          statement.setInt(6, projectId)
          val resCreate = statement.executeUpdate()
          resCreate
        }
        catch {
          case ex: SQLException => println("SQL Exception " + ex.getMessage)
            -2
        }
      }
      case None => {
        println("Connection Failed!")
        -1
      }
    }
  }


  def update(id: Int, name: String, address: String, phone: String, deptId: Int, projectId: Int): Int = {
    val conn = ConnectionFactory.getConnection()
    conn match {
      case Some(c) => {
        try {

          val statement = c.prepareStatement("update Employee SET name=?, phone= ?, deptId=?, projectId=? where id=?")
          statement.setString(1, name)
          statement.setString(2, address)
          statement.setString(3, phone)
          statement.setInt(4, deptId)
          statement.setInt(5, projectId)
          statement.setInt(6, id)
          val resUpdate = statement.executeUpdate()
          resUpdate
        }
        catch {
          case ex: SQLException => println("SQL Exception " + ex.getMessage)
            -2
        }
      }
      case None => {
        println("Connection Failed!")
        -1
      }
    }
  }

  def delete(id: Int): Int = {
    val conn = ConnectionFactory.getConnection()
    conn match {
      case Some(c) => {
        try {
          val statement = c.prepareStatement("delete Employee where id=?")
          statement.setInt(1, id)
          val resDelete = statement.executeUpdate()
          resDelete
        }
        catch {
          case ex: SQLException => println("SQL Exception " + ex.getMessage)
            -2
        }
      }
      case None => {
        println("Connection Failed!")
        -1
      }
    }
  }

  def read(): List[Employee] = {
    val conn = ConnectionFactory.getConnection()
    conn match {
      case Some(c) => {
        try {
          val statement = c.createStatement()
          val EmpResultSet = statement.executeQuery("select * from Emloyee")
          val employeeList = List[Employee]()

          while (EmpResultSet.next()) {
            val id = EmpResultSet.getInt(1)
            val name = EmpResultSet.getString(2)
            val address = EmpResultSet.getString(3)
            val phone = EmpResultSet.getString(4)
            val deptId = EmpResultSet.getInt(5)
            val projId = EmpResultSet.getInt(6)
            employeeList.+:(Employee(id, name, address, phone, deptId, projId))
          }
          employeeList
        }
        catch {
          case ex: SQLException => {
            println("SQLException " + ex.getMessage)
            List[Employee]()
          }
        }
      }
      case None => {
        println("Connection Failed!")
        List[Employee]()
      }
    }
  }

  case class Employee(id: Int, name: String, address: String, phone: String, deptId: Int, projectId: Int)

}