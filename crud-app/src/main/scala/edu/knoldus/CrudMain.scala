package edu.knoldus

/**
  * Created by gitik on 01-02-2017.
  */
object CrudMain {
  def main(args: Array[String]): Unit = {
    val e = new EmployeeOperation
    val d = new DepartmentOperation
    val p = new ProjectOperation
    val c = new ClientOperation

    /*
    d.create(3,"Sales")
    p.create(2,2,"Huaweii")
    e.create(2,"Sumit","Punjabi Bagh", "9999539968",2,2)
    c.create(2,2,"Saksham","Rohini")

    d.create(4,"Development")
    p.create(3,1,"HDFS")
    e.create(3,"Aman","Paschim Vihar","9654021400",1,2)
    c.create(3,1,"Kriti","Punjabi Bagh")
    */
  }

}
