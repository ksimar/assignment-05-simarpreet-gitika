package edu.knoldus

/**
  * Created by gitik on 01-02-2017.
  */
class ClientOperation {

  val conn = ConnectionFactory.getConnection()

  case class Client(id: Int, projectId: Int, name: String, address: String)

  def create(id: Int, projectId: Int, name: String, address: String):Int = {

    conn match {
      case Some(c) => {
        val statement = c.prepareStatement("insert into Client values(?,?,?,?)")
        statement.setInt(1,id)
        statement.setInt(2,projectId)
        statement.setString(3,name)
        statement.setString(4,address)
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
