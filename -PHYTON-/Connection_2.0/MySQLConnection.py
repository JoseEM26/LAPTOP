import mysql.connector as MySQLConnector
from mysql.connector import Error

class DAO:
    def __init__(self):
        try:
          self.connection=MySQLConnector.connect(
              host="localhost",
              port=3306,
              user="root",
              password="mysql",
              database="Customer_database"
          )
        #   print("la conexion fue un exito")
        except Error as e:
            print(f"Ocurrio un en la conexion {e}")



    def ListarCustomer(self) :
        if self.connection.is_connected :
            try:
                cursor=self.connection.cursor()
                cursor.execute("select*from persona")
                personas=cursor.fetchall()
                cursor.close()
                return personas
            except Error as e:
                print(f"ocurrio un error al listar {e}")
                
    def RegistrarCustomer(self , persona):
        if self.connection.is_connected:
            try:  
              cursor=self.connection.cursor()
              cursor.execute("insert into persona(dni,nombre,apellido)values(%s ,%s , %s)" , persona)
              self.connection.commit()
              cursor.close()
              print("!!Persona Registrada Correctamente!!")
            except Error as e:
                print(f"Ocurrio un error al registar : {e}")
                

    def ActualizarCustomer(self, newPersona):
        if self.connection.is_connected:
            try:
                cursor=self.connection.cursor()
                valores=(newPersona[1],newPersona[2],newPersona[0])
                cursor.execute("update persona set nombre= %s , apellido=%s where dni=%s" , valores)
                self.connection.commit()
                cursor.close()
                print(f"Persona con DNI {newPersona[0]} fue actualizada correctamente")
            except Error as e:
                print(f"Ocurrio un error en Actualizar Cliente : {e}")
    
    def EliminarCustomer (self,dniDeleted):
        if self.connection.is_connected():
            try:
                cursor=self.connection.cursor()
                cursor.execute("delete from persona where dni=%s" , (dniDeleted,))
                self.connection.commit()
                cursor.close()
                print("SE ELIMINO CORRECTAMENTE!!   ")
            except Error as e:
                print(f"Error en eliminar MYSQL {e}")
                
    