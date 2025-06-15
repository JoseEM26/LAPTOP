import mysql.connector
from mysql.connector import Error


class DAO():

    def __init__(self):
        try:
            self.conexion = mysql.connector.connect(
                host='localhost',
                port=3306,
                user='root',
                password='mysql',
                db='Customer_database'
            )
        except Error as ex:
            print("Error al intentar la conexión: {0}".format(ex))

    def listarCursos(self):
        if self.conexion.is_connected():
            try:
                cursor = self.conexion.cursor()
                cursor.execute("SELECT * FROM curso ORDER BY nombre ASC")
                resultados = cursor.fetchall()
                return resultados
            except Error as ex:
                print("Error al intentar la conexión: {0}".format(ex))

    def registrarCurso(self, curso):
        if self.conexion.is_connected():
            try:
                cursor = self.conexion.cursor()
                cursor.execute("INSERT INTO curso (codigo, nombre, creditos) VALUES (%s, %s, %s)", curso)
                self.conexion.commit()
                print("¡Curso registrado!\n")
            except Error as ex:
                print("Error al intentar la conexión: {0}".format(ex))

    def actualizarCurso(self, curso):
        if self.conexion.is_connected():
            try:
                cursor = self.conexion.cursor()
                cursor.execute("UPDATE curso SET nombre = %s, creditos = %s WHERE codigo = %s", (curso[1], curso[2], curso[0]))

                self.conexion.commit()
                print("¡Curso actualizado!\n")
            except Error as ex:
                print("Error al intentar la conexión: {0}".format(ex))

    def eliminarCurso(self, codigoCursoEliminar):
        if self.conexion.is_connected():
            try:
                cursor = self.conexion.cursor()
                cursor.execute("DELETE FROM curso WHERE codigo = %s", (codigoCursoEliminar,))

                self.conexion.commit()
                print("¡Curso eliminado!\n")
            except Error as ex:
                print("Error al intentar la conexión: {0}".format(ex))