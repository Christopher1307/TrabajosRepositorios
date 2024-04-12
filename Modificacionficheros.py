ruta_archivo = 'E:/Programacion ciclo superior/carpeta codigos python/usuarios.txt'
opcion=""


def busquedaDni(ruta_archivo , dni_buscado):
    with open(ruta_archivo , 'r') as file:
        for linea in file:
            if dni_buscado in linea:
                return linea.strip()  # Devuelve la línea completa si se encuentra el DNI
    return None

def agregarUsuario(ruta_archivo , Usuario):
    with open(ruta_archivo , 'a') as file:
        file.write(Usuario + '/n')

def eliminarUsuario(ruta_archivo , Usuario_eliminao):
    lineas_actualizadas = []

    # Abrir el archivo en modo lectura
    with open(ruta_archivo, 'r') as file:
        # Leer cada línea del archivo
        for linea in file:
            # Si la línea no contiene el usuario a eliminar, agregarla a la lista
            if Usuario_eliminao not in linea:
                lineas_actualizadas.append(linea)

    # Abrir el archivo en modo escritura y sobrescribir su contenido con las líneas actualizadas
    with open(ruta_archivo, 'w') as file:
        for linea in lineas_actualizadas:
            file.write(linea)

    print('Usuario eliminado correctamente.')
    



while opcion != '4':
    print("""
    ////////Bienvenido al menu de modificacion de ficheros/////////////
    
    elige la opcion que creas conveniente dependiendo tu necesidad
  
        1) Buscar el dni
        2) agregar un usuario nuevo a la lista
        3) Eliminar un usuario de la lista 😈
        4) salir del menu :(
    
""")
  
    opcion= input('elige la opcion que quieres:')

    if opcion == '1':
        dni_buscado =input('ingrese el dni que desea buscar :')
        resultado = busquedaDni(ruta_archivo , dni_buscado)
        if resultado:
            print('dni encontrado:' , resultado)
        else:
            print('dni no encontrado')
    

    elif opcion == '2':
        Usuario= input('ingrese el usuario que deseas agregar :')
        agregarUsuario(ruta_archivo , Usuario)
        print('usuario agregado sus datos son los siguientes')

    elif opcion == '3':
        Usuario_eliminao = input('ingrese el usuario que quieres eliminar :')
        eliminarUsuario(ruta_archivo , Usuario_eliminao)
        print('usuario eliminado correctamente' ,)

  

    elif opcion == '4':
        print('saliste del menu')
  

    else:
        print('opcion invalida , elige otra')

