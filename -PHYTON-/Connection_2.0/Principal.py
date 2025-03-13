from MySQLConnection import DAO
import Service

def MenuPrincipal():
    
    

    continuar=True
    while (continuar) :
        print("\n>>>>>>>>>>   MENU   <<<<<<<<<<<<")
        print("1.- Listar Cursos")
        print("2.- Registrar")
        print("3.- Actualizar")
        print("4.- Eliminar")
        print("5.- Salir del sistema")
        print("--------------------------------")
        
        try:
            
            opcion=int(input("Ingrese su opcion: "))
            
            if opcion==5 :
                print("Gracias por su visita :3")
                continuar=False
                break
            elif opcion > 5 or opcion < 1 :
                print("debe ingresar un dato valido")
            else:
                continuar=False
                EjecutarOpcion(opcion)
        except ValueError as e:
            print(f"debe ingresar un numero entero {e}")
            

    
def EjecutarOpcion(opcion):
    
    if opcion == 1 :
        try:
            # print(f"EJECUTANDO............................. {opcion}")
            personas= DAO().ListarCustomer()
            if len(personas) > 0 :
              Service.ImprimirPersonas(personas)
            else :
                print("La tabla se encuentra vacia")
        except :
            pass
    elif opcion ==2 :
        try:
            newPersona=Service.PedirDatosPersona()
            DAO().RegistrarCustomer(newPersona)
            # print("Se registro un nueva persona")
        except:
            print("Error al momneto de ejecitar en principal")
    elif opcion ==3 :
            try:
                ActualizarPersona= Service.PedirDatosActualizar()
                DAO().ActualizarCustomer(ActualizarPersona)
                print("SE ACTUALIZO CORRECTAMENTE!!!")
            except Exception as e:
                print(f"Erroe en el principal actualizar {e}")
    elif opcion ==4 :
        try:
            dao=DAO()
            dni= Service.PedirDNIEliminar()
            dao.EliminarCustomer(dni)
            print(f"NUMERO DNI : {dni} ELIMINADO")
        except :
            print("Error en elimianrprincipal")
        
    
    
    
    
    
    
MenuPrincipal()