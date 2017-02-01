package edu.knoldus
import org.scalatest._
/**
  * Created by gitik on 01-02-2017.
  */
class EmployeeOperationTest extends FunSuite {
  val connection = ConnectionFactory.getConnection()
  val e1 = new EmployeeOperation
  test("Check Create") {
    assert(e1.create(5,"Gitika","Paschim Vihar","9999747608",1,1)==1)
  }

}
