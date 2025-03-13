from MySQLConnection import DAO

def ImprimirPersonas(personas):
    print("Cursos>>> \n")
    for i , persona in enumerate(personas , start=1):
        print(f"_{i}_DNI : {persona[0]} , Nombre : {persona[1]} , Apellido : {persona[2]}")
    print("  ")
          
            
def PedirDatosPersona():
    try:
        dniContinuar=True
        while(dniContinuar):
            dni=int(input("Ingresar DNI : "))
            if(dni > 10000000):
                print("DNI CORRECTO!!!")
                nombre=input("Ingresar Nombre : ")
                apellido=input("Ingresar Apellido : ")
                dniContinuar=False
            else:
                print("el DNI debe tener 8 numeros")
               
        newPersona=(dni,nombre,apellido)        
        return  newPersona       
    except:
        print("Ocurrio un probema al pedir datos register")
        
def PedirDatosActualizar():
    try:
        clientes=DAO().ListarCustomer()
        if len(clientes) > 0:
            ImprimirPersonas(clientes)
            print("\n")
             
            existeCodigo=False
            while not existeCodigo:
                dni=input("Ingresar el Cliente DNI para actualizar : ").strip()
                
                if not dni.isdigit() or len(dni) != 8:
                    print("El DNI debe contener exactamente 8 dígitos numéricos.")
                    continue
                
                for cliente in clientes :
                    if str(cliente[0]) == dni :
                        existeCodigo= True
                
                if not existeCodigo:
                    print("No existe el codigo")
                        
            
            if existeCodigo :
                nombre=  input("Ingrese el nuevo nombre : ").strip()
                apellido=input("Ingrese el numero apellido : ").strip()
                
                newPersona=(dni,nombre,apellido)
                return newPersona
            else:
                return None    
        else:
            print("la tabla esta vacia")

    except Exception as e:
        print(f"Ocurrio un error al pedir datos para actualizar {e}")
        
def PedirDNIEliminar():
    clientes=DAO().ListarCustomer()
    if len(clientes) > 0:
        ImprimirPersonas(clientes)
        print("\n")
        
        existeDNI=False
        while(not existeDNI):
            dni=input("Ingresa el DNI a eliminar : ").strip()
            
            if not dni.isdigit() or len(dni) != 8 :
                print("Debe tener el DNI 8 digitos bb")
                continue
            
            for cliente in clientes :
                if(int(cliente[0])  ==  int(dni) ):
                    existeDNI =True
                    return dni
            
            if not existeDNI :
                print("El dni no existe bb")
    else:
        print("la bd esta vacia")