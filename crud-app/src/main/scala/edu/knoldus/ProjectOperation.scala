package edu.knoldus

/**
  * Created by gitik on 01-02-2017.
  */
class ProjectOperation {

  val conn = ConnectionFactory.getConnection()

  case class Project(id: Int, deptId: Int, name: String, clientId: Int)

  def create(id: Int, deptId: Int, name: String):Int = {

    conn match {
      case Some(c) => {
        val statement = c.prepareStatement("insert into Project values(?,?,?)")
        statement.setInt(1,id)
        statement.setInt(2,deptId)
        statement.setString(3,name)
        val resCreate = statement.executeUpdate()
        resCreate
      }
      case None => {
        println("Connection Failed!")
        -1
      }
    }
  }
}
