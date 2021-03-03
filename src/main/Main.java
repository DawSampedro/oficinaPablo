package main;

import java.util.Scanner;
import validarInt.*; //paquete que si un string contiente un numero entero lo devuelve, si no devulve -1

public class Main {
    public static void main(String[] args) {
        boolean cerrar = false;
        String opcionStr ="";
        int opcionInt;

        Scanner sc = new Scanner(System.in);
        //llamamos al metodo crear Dispositivos ( //TODO linea 771) que crea todos los objetos de dispositivos
        //el array misDispositivos contendra un array de dispositivos, el pimer array sera de sobremesas, el segundo de portatiles, el tercero de moviles
        Dispositivo[][] misDispositivos = Main.crearDispositivos();
        //llamamos al metodo crearEmpleados (//TODO 763) que crea todos los objetos de empleados, por parametro pasamos el numero maximo de empleados(poco util)
        //el array misEmpleados contendra todos los posible empleados de la oficina
        Empleado[] misEmpleados = Main.crearEmpelados(7);

        while (!cerrar) { //bucle que repite el menu principal
            System.out.println("1 . Empleados." + " Numero de empleados activos: " + contarEmpleadosActivos(misEmpleados)); //metodo contarEmpleadoActivos cuenta los empleados que estan activos (dados de alta) ( //TODO linea 765)
            //opcion 1 contendra everything lo relacionado con empleados, dar de alta, dar de baja, modificar empleados, listar empleados
            System.out.println("2. Equipos " + "Numero de dispositivos activos: " + contarDispositivosActivos(misDispositivos)); //metodo contarDispositivosActivos cuenta los dispositivos activos de los tres tipos (//TODO linea
            //opcion 2 contendra everything relacionado con los dispositivos, introducir nuevo equipo, modificar equipo y listar equipos
            System.out.println("3. Asignar/desasignar equipos");
            //opcion 3 contendra everything relacionado a asignar o desasignar un equiipo a un empleado;
            System.out.println("4. Reparaciones");
            //opcion 4 contendra everything relacionado a enviar un equipo a reparar o recogerlo de reparaciones
            opcionStr = sc.next(); //recogemos la opcion que elige el usuario en un string
            opcionInt = ValidarIntFromString.validarIntFromString(opcionStr); //setemos opcionInt el resultado de nuestra libreria que si opcionStr no contiene un numero entero devolvera -1
            if (opcionInt != -1) { //si opcionInt es un nuemero entero entraremos en el el menos
                switch (opcionInt) {
                    case 1 -> empleadosMenu(misEmpleados); //llamamos al submenu de empleadoss pasandole el array misEmpleados (todo
                    case 2 -> equiposMenu(misDispositivos); //llamamos al submenu de equipos pasandole el array misDispositivos(todo
                    case 3 -> asignarMenu(misDispositivos, misEmpleados); //llamamos al submenu de asingar pasandole el array de misEmpleados y misDispositivos (todo
                    case 4 -> reparacionesMenu(misDispositivos, misEmpleados); //llamamos al submenu de reparaciones pasandole el array de misEmpleados y misDispositivos (todo
                    default -> System.out.println("Introduce un numero del 1-4"); //en caso de que el valor del menu no sea del rango 1-4
                }
            } else {
                System.out.println("Opcion no valida"); //se imprimira en caso de que no se introduzca un numero entero
            }
        }
    }
    /*
    EMPLEADOS
     */
    private static void empleadosMenu(Empleado[] misEmpleados){
        boolean cerrar = false;
        String opcionStr;
        int opcionInt;
        Scanner sc = new Scanner(System.in);
        while (!cerrar){
            System.out.println("1. Introducir empleado"); //
            System.out.println("2. Dar de baja empleado");
            System.out.println("3. Modificar datos empleado");
            System.out.println("4. Listar empleados");
            System.out.println("5. Volver al menu anterior");
            opcionStr = sc.next();
            opcionInt = ValidarIntFromString.validarIntFromString(opcionStr);
            if (opcionInt != -1) { //validamos que se introduzca un numero entero en el menu

                switch (opcionInt) {
                    case 1:
                        empleadoAlta(misEmpleados); //metodo que nos permite introducir un nuevo empleado, dar de alta (todo
                        break;
                    case 2:
                        empleadoBaja(misEmpleados); //metodo que nos permite dar de bajar un empleado (todo
                        break;
                    case 3:
                        empleadoModificar(misEmpleados); //metodo que nos permite modificar un empleado (todo
                        break;
                    case 4:
                        Empleado.empleadoListar(misEmpleados); //metodo que nos permite listar todos los empleados (todo
                        break;
                    case 5:
                        System.out.println("Volviendo al menu\n");
                        cerrar = true; //cerraremos el while y volveremos al menu anterior
                        break;
                    default:
                        System.out.println("Introduce un numero del 1-4");
                        break;
                }

            } else {
                System.out.println("Opcion no valida");
            }

        }
    }
    private static void empleadoAlta(Empleado[] misEmpleados){ //este metodo dara de alta el primer empleado del array disponible (dado de baja) seteando todos sus atributos
        Scanner sc = new Scanner(System.in);
        int indiceEmpleado = empleadoPrimeroBaja(misEmpleados); //metodo que nos devuelve el indice del primer empleado disponible (todo
        if (indiceEmpleado != -1) { //si el indice no es -1 (que implicaria que no hay empleados disponibles setearemos los atributos del empleado
            System.out.println("Vas a dar de alta el empleado: " + indiceEmpleado);
            misEmpleados[indiceEmpleado].setAlta(true); //marcamos que el empleado esta dado de alta
            System.out.println("Introuce el nombre del empleado");
            misEmpleados[indiceEmpleado].setNombre(sc.next());
            System.out.println("Introduce el apellido del empleado");
            misEmpleados[indiceEmpleado].setApellidos(sc.next());
            System.out.println("Introduce el DNI del empleado");
            misEmpleados[indiceEmpleado].setDni(sc.next());
            System.out.println("\nAcabas de crear el nuevo empleado:\n");
            System.out.println(misEmpleados[indiceEmpleado]);
        }


    }
    private static void empleadoBaja(Empleado[] misEmpleados){ //metodo que nos permite dar de baja el empleado que seleccionemos
        Scanner sc = new Scanner(System.in);
        int indiceEmpleado;

        Empleado.empleadoListar(misEmpleados); //mostramos todos los empleados que estan dados de alta, el metodo esta en la clase empleado para probar como seria sin hacerlo en la clase main
        System.out.println("Vas a dar de baja un empleado. Seleccione el numero de empleado que quieres dar de baja");
        indiceEmpleado = ValidarIntFromString.validarIntFromString(sc.nextLine());
        if (indiceEmpleado != -1 && indiceEmpleado >= 0 && indiceEmpleado <=6){ //si el indice seleccionado es un numero entero y en el rango 0-6 setemos el atributo alta en false, indicando que esta de baja todo solo permitir dar de baja los empleados que ya estan de alta
            misEmpleados[indiceEmpleado].setAlta(false);
        }
        Empleado.empleadoListar(misEmpleados); //volvemos a mostrar los empleados dados de alta
    }
    private static void empleadoModificar(Empleado[] misEmpleados){ //metodo que permite modificar todos los datos de un empleado
        Scanner sc = new Scanner(System.in);
        int indiceEmpleado;

        Empleado.empleadoListar(misEmpleados); //mostramos todos los empleados dados de alta
        System.out.println("Vas a modificar los valor de uno de los empleados. Selecciona el numero de empleado a modificar");
        indiceEmpleado = ValidarIntFromString.validarIntFromString(sc.nextLine()); //recogemos el indice del empleado que queremos modificar todo solo permitir modificar los empleados dados de alta
        if (indiceEmpleado >= 0 && indiceEmpleado <=6){
            int opcion;
            System.out.println("Has seleccionado el empleado:" + misEmpleados[indiceEmpleado]);
            System.out.println("1. Modificar el nombre. Nombre actual: " + misEmpleados[indiceEmpleado].getNombre());
            System.out.println("2. Modificar el apellido. Apellido actual: " + misEmpleados[indiceEmpleado].getApellidos());
            System.out.println("3. Modificar el dni. Dni actual: " + misEmpleados[indiceEmpleado].getDni());
            opcion = ValidarIntFromString.validarIntFromString(sc.nextLine());
            if (opcion != -1){
                String modificacion ="";
                switch (opcion) { //podremos seleccionar que atributo modificar
                    case 1 -> {
                        System.out.println("Introduce el nuevo nombre");
                        misEmpleados[indiceEmpleado].setNombre(sc.nextLine());
                    }
                    case 2 -> {
                        System.out.println("Introduce el nuevo apellido");
                        misEmpleados[indiceEmpleado].setApellidos(sc.nextLine());
                    }
                    case 3 -> {
                        System.out.println("Introduce el nuevo dni");
                        misEmpleados[indiceEmpleado].setDni(sc.nextLine());
                    }
                    default -> System.out.println("Introduce un numero entre el 1-3");
                }
            }else System.out.println("Valor no valido");

        }

    }
    private static int empleadoPrimeroBaja(Empleado[] misEmpleados){ //metodo que devuelve el primer empleado disponible
        int valor = -1, contador = 0; //valor = valor del indice del empleado
        boolean condicion = true; //condicion para cerrar el bucle cuando encuentre el primer empleado disponible o no encuentre ninguno
        do {
            if (contador < 7) { //si el contador esta dentro del rango de indices de posibles empleado
                if (!misEmpleados[contador].isAlta()){ //comprobamos si ese empleado esta disponible
                    valor = misEmpleados[contador].getNumeroEmpleado(); //seteamos el valor al indice del valor disponible
                    condicion = false; //terminamos el bucle
                }
                contador++;
            } else { //si se han recorrido todas las posibles posiciones sin que halla uno disponible cerramos el bucle y devolvemos el valor -1 que implica que no hay empleados disponibles
                condicion = false;
                System.out.println("No hay puesto disponibles :(");
                valor = -1;
            }
        }while (condicion);

        return valor; //devolvemos el valor del indice del primer empleado disponible, si no hubiese disponibles se devuelve -1
    }

    /*
    EQUIPOS
     */

    private static void equiposMenu(Dispositivo[][] misDispositivos){
        boolean cerrar = false;
        String opcionStr;
        int opcionInt;
        Scanner sc = new Scanner(System.in);
        while (!cerrar){
            System.out.println("1. Introducir dispositivo");
            System.out.println("2. Modificar datos dispositivo");
            System.out.println("3. Listar dispositivos");
            System.out.println("4. Volver al menu anterior");
            opcionStr = sc.next();
            if (ValidarIntFromString.validarIntFromString(opcionStr) != -1) {
                opcionInt = Integer.parseInt(opcionStr);
                switch (opcionInt) {
                    case 1:
                        dispositivoIntroducir(misDispositivos); //metodo que permite introducir un dispositivo en el primer hueco libre en el array de su tipo
                        break;
                    case 2:
                        dispositivoModificar(misDispositivos); //metodo que permite modificar el dispositivo seleccionado
                        break;
                    case 3:
                        dispositivoListar(misDispositivos); //metodo para listar los dispositivos con detalle o sin el
                        break;
                    case 4:
                        System.out.println("Volviendo al menu\n");
                        cerrar = true;
                        break;
                    default:
                        System.out.println("Introduce un numero del 1-4");
                        break;
                }

            } else {
                System.out.println("Opcion no valida");
            }

        }
    }
    private static void dispositivoIntroducir(Dispositivo[][] misDispositivos){ //indicamos el tipo de dispositivo que queremos introducir y setea sus atributos
        Scanner sc = new Scanner(System.in);
        String opcionStr;
        int opcionInt;
        System.out.println("1. Introducir un sobremesa");
        System.out.println("2. Introducir un portatil");
        System.out.println("3. Introducir un movil");
        opcionStr = sc.nextLine(); //seleccionamos el tipo de dispositivo que queremos introducir
        opcionInt = ValidarIntFromString.validarIntFromString(opcionStr);
        if (opcionInt == 1 || opcionInt == 2 || opcionInt == 3){
            int indiceTipo = opcionInt - 1;
            boolean repetido;
            int indiceDispositvo = primerDispositivo(misDispositivos, indiceTipo); //llamamos al metodo primerDispositivo para obtener el indice del primer dispositivo libre del tipo que le pasemos por el parametro (todo
            if (indiceTipo == 0){ //seteamos el dispositivo seleccionado dependiente de su tipo
                Sobremesa sobremesa = (Sobremesa) misDispositivos[indiceTipo][indiceDispositvo];
                System.out.println("Introduce la capacidad del disco duro (HDD)");
                sobremesa.setCapacidadHDD(sc.nextInt());
                System.out.println("Introduce la capacidad de la RAM");
                sobremesa.setCapacidadRAM(sc.nextInt());
                System.out.println("Introduce la marca del teclado");
                sobremesa.setMarcaTeclado(sc.nextLine());
                System.out.println("Introduce la marca del raton");
                sobremesa.setMarcaRaton(sc.nextLine());
                System.out.println("Introduce la marca del monitor");
                sobremesa.setMarcaMonitor(sc.nextLine());
                do { //para setear el numero de serie comprobaremos que no esta ya asignado repitiendo el seteo hasta que no coincida con otro numero de serie
                    System.out.println("Introduce el numero de serie");
                    repetido = comprobarNumSerie(sc.next(), misDispositivos, sobremesa); //llamamos al metodo comprobarNumeroSerie al que le pasamos el numero de serie nuevo, el array todos los dispositivos y el dispositivo que estamos seteando
                    if (repetido) System.out.println("El numero de serie esta repetido, introduzca otro");
                } while (repetido); //se repetira hasta que no este repetido el numero de serie
                System.out.println("Introduce la marca");
                sobremesa.setMarca(sc.nextLine());
                System.out.println("Introduce el modelo");
                sobremesa.setModelo(sc.nextLine());
                System.out.println("Introduce las pulgadas de la pantalla");
                sobremesa.setPulgadasPantalla(sc.nextDouble());
                sobremesa.setActivo(true);
                misDispositivos[indiceTipo][indiceDispositvo] = sobremesa;
            }
            if (indiceTipo == 1){
                Portatil portatil = (Portatil) misDispositivos[indiceTipo][indiceDispositvo];
                System.out.println("Introduce el tipo de disco (ssd/hdd)");
                String tipoDisco = sc.nextLine();
                if (tipoDisco.equalsIgnoreCase("ssd")){ //TODO mejorar restriccion
                    portatil.setTipoDisco(true);
                }else if (tipoDisco.equalsIgnoreCase("hdd")){
                    portatil.setTipoDisco(false);
                }else System.out.println("Valor no valido");
                System.out.println("Introduce la capacidad del disco duro");
                portatil.setCapacidadDisco(sc.nextInt());
                System.out.println("Introducir la capacidad de RAM");
                portatil.setCapacidadRAM(sc.nextInt());
                do {
                    System.out.println("Introduce el numero de serie");
                    repetido = comprobarNumSerie(sc.next(), misDispositivos, portatil);
                    if (repetido) System.out.println("El numero de serie esta repetido, introduzca otro");
                } while (repetido);
                System.out.println("Introduce la marca");
                portatil.setMarca(sc.nextLine());
                System.out.println("Introduce el modelo");
                portatil.setModelo(sc.nextLine());
                System.out.println("Introduce las pulgadas de la pantalla");
                portatil.setPulgadasPantalla(sc.nextDouble());
                portatil.setActivo(true);
                misDispositivos[indiceTipo][indiceDispositvo] = portatil;

            }
            if (indiceTipo == 2){
                Movil movil = (Movil) misDispositivos[indiceTipo][indiceDispositvo];
                System.out.println("Introduce los megapixeles de la camara");
                movil.setResolucionCamara(sc.nextInt());
                do {
                    System.out.println("Introduce el numero de serie");
                    repetido = comprobarNumSerie(sc.next(), misDispositivos, movil);
                    if (repetido) System.out.println("El numero de serie esta repetido, introduzca otro");
                } while (repetido);
                System.out.println("Introduce la marca");
                movil.setMarca(sc.nextLine());
                System.out.println("Introduce el modelo");
                movil.setModelo(sc.nextLine());
                System.out.println("Introduce las pulgadas de la pantalla");
                movil.setPulgadasPantalla(sc.nextDouble());
                movil.setActivo(true);
                misDispositivos[indiceTipo][indiceDispositvo] = movil;
            }
        }else System.out.println("Valor no valido");

    }
    private static void dispositivoModificar(Dispositivo[][] misDispositivos){ //metodo que permite modificar los dispositivos

        Scanner sc = new Scanner(System.in);
        String opcionStr;
        int opcionInt;
        boolean repetido;
        System.out.println("1. Modificar un sobremesa");
        System.out.println("2. Modificar un portatil");
        System.out.println("3. Modificar un movil");
        opcionStr = sc.nextLine(); //indicamos el tipo de dispositivo que queremos modificar
        opcionInt = ValidarIntFromString.validarIntFromString(opcionStr);
        if (opcionInt == 1 || opcionInt == 2 || opcionInt == 3){
            int indiceTipo = opcionInt - 1, indiceMaximo = 0, seleccionInt;
            String seleccionStr = "", nuevoDato = "";
            if (indiceTipo == 0) indiceMaximo = 4; //para recorrer todos los dipositivos de un tipo seteamos su indice maximo por tipo
            if (indiceTipo == 1) indiceMaximo = 5;
            if (indiceTipo == 2) indiceMaximo = 7;
            if (indiceTipo == 0){
                for (int i = 0; i < indiceMaximo; i++) { //mostramos todos los dispositivos activos del tipo seleccionado
                    if (misDispositivos[indiceTipo][i].isActivo()){
                        Sobremesa sobremesa = (Sobremesa) misDispositivos[indiceTipo][i];
                        System.out.println(sobremesa.getNumeroDispositivo() + ". Dispositivo: " + sobremesa.getNumSerie() + sobremesa.getMarca() + sobremesa.getModelo());
                    }
                }
                System.out.println("Selecciones el dispositivo que quieres modificar");
                seleccionStr = sc.nextLine();
                seleccionInt = ValidarIntFromString.validarIntFromString(seleccionStr); //seleccionamos el dispositivo que queremos modificar del tipo ya indicado

                if (seleccionInt != -1){ //seteamos los nuevos valores del dispositivo seleccionado
                    Sobremesa sobremesa =(Sobremesa) misDispositivos[indiceTipo][seleccionInt];
                    System.out.println("Introduce la capacidad del disco duro (HDD)");
                    sobremesa.setCapacidadHDD(sc.nextInt());
                    System.out.println("Introduce la capacidad de la RAM");
                    sobremesa.setCapacidadRAM(sc.nextInt());
                    System.out.println("Introduce la marca del teclado");
                    sobremesa.setMarcaTeclado(sc.nextLine());
                    System.out.println("Introduce la marca del raton");
                    sobremesa.setMarcaRaton(sc.nextLine());
                    System.out.println("Introduce la marca del monitor");
                    sobremesa.setMarcaMonitor(sc.nextLine());
                    do { //bucle que comprueba que el nuevo numero de serie no esta repetido en otro dispositivo
                        System.out.println("Introduce el numero de serie");
                        repetido = comprobarNumSerie(sc.next(), misDispositivos, sobremesa);
                        if (repetido) System.out.println("El numero de serie esta repetido, introduzca otro");
                    } while (repetido);
                    System.out.println("Introduce la marca");
                    sobremesa.setMarca(sc.nextLine());
                    System.out.println("Introduce el modelo");
                    sobremesa.setModelo(sc.nextLine());
                    System.out.println("Introduce las pulgadas de la pantalla");
                    sobremesa.setPulgadasPantalla(sc.nextDouble());
                    misDispositivos[indiceTipo][seleccionInt] = sobremesa;
                }
            }
            if (indiceTipo == 1){
                for (int i = 0; i < indiceMaximo; i++) {
                    if (misDispositivos[indiceTipo][i].isActivo()){
                        Portatil portatil = (Portatil) misDispositivos[indiceTipo][i];
                        System.out.println(portatil.getNumeroDispositivo() + ". Dispositivo: " + portatil.getNumSerie() + portatil.getMarca() + portatil.getModelo());
                    }
                }
                System.out.println("Selecciones el dispositivo que quieres modificar");
                seleccionStr = sc.nextLine();
                seleccionInt = ValidarIntFromString.validarIntFromString(seleccionStr);

                if (seleccionInt != -1){
                    Portatil portatil = (Portatil) misDispositivos[indiceTipo][seleccionInt];
                    System.out.println("Introduce el tipo de disco (ssd/hdd)");
                    String tipoDisco = sc.nextLine();
                    if (tipoDisco.equalsIgnoreCase("ssd")){ //TODO mejorar restriccion
                        portatil.setTipoDisco(true);
                    }else if (tipoDisco.equalsIgnoreCase("hdd")){
                        portatil.setTipoDisco(false);
                    }else System.out.println("Valor no valido");
                    System.out.println("Introduce la capacidad del disco duro");
                    portatil.setCapacidadDisco(sc.nextInt());
                    System.out.println("Introducir la capacidad de RAM");
                    portatil.setCapacidadRAM(sc.nextInt());
                    do {
                        System.out.println("Introduce el numero de serie");
                        repetido = comprobarNumSerie(sc.next(), misDispositivos, portatil);
                        if (repetido) System.out.println("El numero de serie esta repetido, introduzca otro");
                    } while (repetido);
                    System.out.println("Introduce la marca");
                    portatil.setMarca(sc.nextLine());
                    System.out.println("Introduce el modelo");
                    portatil.setModelo(sc.nextLine());
                    System.out.println("Introduce las pulgadas de la pantalla");
                    portatil.setPulgadasPantalla(sc.nextDouble());
                    portatil.setActivo(true);
                    misDispositivos[indiceTipo][seleccionInt] = portatil;
                }
            }
            if (indiceTipo == 2){
                for (int i = 0; i < indiceMaximo; i++) {
                    if (misDispositivos[indiceTipo][i].isActivo()){
                        Movil movil = (Movil) misDispositivos[indiceTipo][i];
                        System.out.println(movil.getNumeroDispositivo() + ". Dispositivo: " + movil.getNumSerie() + movil.getMarca() + movil.getModelo());
                    }
                }
                System.out.println("Selecciones el dispositivo que quieres modificar");
                seleccionStr = sc.nextLine();
                seleccionInt = ValidarIntFromString.validarIntFromString(seleccionStr);

                if (seleccionInt != -1){
                    Movil movil = (Movil) misDispositivos[indiceTipo][seleccionInt];
                    System.out.println("Introduce los megapixeles de la camara");
                    movil.setResolucionCamara(sc.nextInt());
                    do {
                        System.out.println("Introduce el numero de serie");
                        repetido = comprobarNumSerie(sc.next(), misDispositivos, movil);
                        if (repetido) System.out.println("El numero de serie esta repetido, introduzca otro");
                    } while (repetido);
                    System.out.println("Introduce la marca");
                    movil.setMarca(sc.nextLine());
                    System.out.println("Introduce el modelo");
                    movil.setModelo(sc.nextLine());
                    System.out.println("Introduce las pulgadas de la pantalla");
                    movil.setPulgadasPantalla(sc.nextDouble());
                    movil.setActivo(true);
                    misDispositivos[indiceTipo][seleccionInt] = movil;
                }
            }
        }
    }
    private static void dispositivoListar(Dispositivo[][] misDispositivos){ //metodo que permite mostrar todos los dispositivos con mas o menos informacion
        Scanner sc = new Scanner(System.in);
        String opcionStr, detalles = "";
        int opcionInt;
        System.out.println("1. Mostrar sobremesas");
        System.out.println("2. Mostrar portatiles");
        System.out.println("3. Mostrar moviles");
        opcionStr = sc.nextLine(); //elegimos el tipo de dispositivos que queremos mostrar
        opcionInt = ValidarIntFromString.validarIntFromString(opcionStr);
        if (opcionInt == 1 || opcionInt == 2 || opcionInt == 3){
            int indiceTipo = opcionInt - 1, indiceMaximo = 0;
            if (indiceTipo == 0) indiceMaximo = 4;
            if (indiceTipo == 1) indiceMaximo = 5;
            if (indiceTipo == 2) indiceMaximo = 7;
            if (indiceTipo == 0){
                for (int i = 0; i < indiceMaximo; i++) { //si el dispositivo esta activo mostramos informacion de el recorriendo hasta el indice maximo de su tipo
                    if (misDispositivos[indiceTipo][i].isActivo()){
                        System.out.println("Dispositivo: " + misDispositivos[indiceTipo][i].getNumSerie() + misDispositivos[indiceTipo][i].getMarca() + misDispositivos[indiceTipo][i].getModelo());
                    }
                }
                System.out.println("Quieres ver mas informacion? (s/n)");
                detalles = sc.nextLine();
                if (detalles.equalsIgnoreCase("s")){ //si queremos mostrar mas informacion sobre los dispositivos...
                    for (int i = 0; i < indiceMaximo; i++) {
                        if (misDispositivos[indiceTipo][i].isActivo()){
                            if (indiceTipo == 0){
                                Sobremesa sobremesa = (Sobremesa) misDispositivos[indiceTipo][i]; //casteamos el dispositivoa un objeto de la clase depediente del tipo que hallamos seleccionado
                                System.out.println(sobremesa); //imprimimos ese objeto con el toString de la subclase
                            }
                            if (indiceTipo == 1){
                                Portatil portatil = (Portatil) misDispositivos[indiceTipo][i];
                                System.out.println(portatil);

                            }
                            if (indiceTipo == 2){
                                Movil movil = (Movil) misDispositivos[indiceTipo][i];
                                System.out.println(movil);
                            }
                        }
                    }
                }
            }
            if (indiceTipo == 1){
                for (int i = 0; i < indiceMaximo; i++) {
                    if (misDispositivos[indiceTipo][i].isActivo()){
                        System.out.println("Dispositivo: " + misDispositivos[indiceTipo][i].getNumSerie() + misDispositivos[indiceTipo][i].getMarca() + misDispositivos[indiceTipo][i].getModelo());
                    }
                }
                System.out.println("Quieres ver mas informacion? (s/n)");
                detalles = sc.nextLine();
                if (detalles.equalsIgnoreCase("s")){
                    for (int i = 0; i < indiceMaximo; i++) {
                        if (misDispositivos[indiceTipo][i].isActivo()){
                            if (indiceTipo == 0){
                                Sobremesa sobremesa = (Sobremesa) misDispositivos[indiceTipo][i];
                                System.out.println(sobremesa);
                            }
                            if (indiceTipo == 1){
                                Portatil portatil = (Portatil) misDispositivos[indiceTipo][i];
                                System.out.println(portatil);

                            }
                            if (indiceTipo == 2){
                                Movil movil = (Movil) misDispositivos[indiceTipo][i];
                                System.out.println(movil);
                            }
                        }
                    }
                }

            }
            if (indiceTipo == 2){
                for (int i = 0; i < indiceMaximo; i++) {
                    if (misDispositivos[indiceTipo][i].isActivo()){
                        System.out.println("Dispositivo: " + misDispositivos[indiceTipo][i].getNumSerie() + misDispositivos[indiceTipo][i].getMarca() + misDispositivos[indiceTipo][i].getModelo());
                    }
                }
                System.out.println("Quieres ver mas informacion? (s/n)");
                detalles = sc.nextLine();
                if (detalles.equalsIgnoreCase("s")){
                    for (int i = 0; i < indiceMaximo; i++) {
                        if (misDispositivos[indiceTipo][i].isActivo()){
                            if (indiceTipo == 0){
                                Sobremesa sobremesa = (Sobremesa) misDispositivos[indiceTipo][i];
                                System.out.println(sobremesa);
                            }
                            if (indiceTipo == 1){
                                Portatil portatil = (Portatil) misDispositivos[indiceTipo][i];
                                System.out.println(portatil);

                            }
                            if (indiceTipo == 2){
                                Movil movil = (Movil) misDispositivos[indiceTipo][i];
                                System.out.println(movil);
                            }
                        }
                    }
                }

            }
        }else System.out.println("Valor no valido");
    }
    private static int primerDispositivo(Dispositivo[][] misDispositivos, int indiceDispositivo){  //metodo que devuelve el indice del primer dispositivo libre dependiente del tipo indicado por el parametro
        int valor = -1, contador = 0, indiceMaximo = 0;
        boolean condicion = true;
        if (indiceDispositivo == 0) indiceMaximo = 4; //usaremos esta variable para recorrer el array de cada tipo ya que tienen longitudes distintas depndeientes del tipo
        if (indiceDispositivo == 1) indiceMaximo = 5;
        if (indiceDispositivo == 2) indiceMaximo = 7;
        do {
            if (contador < indiceMaximo) { //si el dispositivo que observamos tiene un indice menor al indice maximo de su tipo...
                if (!misDispositivos[indiceDispositivo][contador].isActivo()){ //si no esta activo devolveremos su indice dentro del array de su tipo
                    if (misDispositivos[indiceDispositivo][contador] instanceof Sobremesa){
                        Sobremesa sobremesa =(Sobremesa) misDispositivos[indiceDispositivo][contador]; //necesitamos el caste de la clase dispositivo a su subclase para acceder a su numero de dispositivo
                        valor = sobremesa.getNumeroDispositivo();
                    }
                    if (misDispositivos[indiceDispositivo][contador] instanceof Portatil){
                        Portatil sobremesa =(Portatil) misDispositivos[indiceDispositivo][contador];
                        valor = sobremesa.getNumeroDispositivo();
                    }
                    if (misDispositivos[indiceDispositivo][contador] instanceof Movil){
                        Movil sobremesa =(Movil) misDispositivos[indiceDispositivo][contador];
                        valor = sobremesa.getNumeroDispositivo();
                    }
                    condicion = false; //cerramos el bucle
                }

                contador++;
            } else { //si pasamos el indice maximo cerraremos el bucle ya que no hay dispositivos libres para ser dado de alta
                condicion = false;
                System.out.println("No hay puesto disponibles :(");
            }
        }while (condicion);

        return valor; //devolvemos el indice dentro del array del primer dispositivo aun dado de alta
    }
    private static boolean comprobarNumSerie(String numSerie, Dispositivo[][] misDispositivos, Dispositivo dispositivo) { //metodo para comprobar si el numero de serie que queremos setear no esta reetido en otro dispositivo
        int indiceMaximo = 0;
        int contador = 0;
        boolean repetido = false;

        for (int i = 0; i < 3; i++) { //recorreremos todos los dispositivos
            if (i == 0) indiceMaximo = 4;
            if (i == 1) indiceMaximo = 5;
            if (i == 2) indiceMaximo = 7;
            for (int j = 0; j < indiceMaximo; j++) {
                if (numSerie.equalsIgnoreCase(misDispositivos[i][j].getNumSerie())){ //comprobamos que el numero de serie que queremos setear no coincide con ninguno de los dispositivos ya seteados
                    contador++;
                }
            }
        }
        if (contador != 0) repetido = true; //si se ha repetido alguna vez devolvemos true para que se repita el proceso
        if (contador == 0) dispositivo.setNumSerie(numSerie); //si no se ha repetido seteamos el numero de serie del dispositivo
        return repetido;
    }

    /*
    ASIGNAR EQUIPOS
     */
    private static void asignarMenu(Dispositivo[][] misDispositivos, Empleado[] misEmpleados){
        boolean cerrar = false;
        String opcionStr;
        int opcionInt;
        Scanner sc = new Scanner(System.in);
        while (!cerrar){
            System.out.println("1. Asignar equipo");
            System.out.println("2. Desasignar equipo");
            System.out.println("3. Volver al menu anterior");
            opcionStr = sc.next();
            if (ValidarIntFromString.validarIntFromString(opcionStr) != -1) {
                opcionInt = Integer.parseInt(opcionStr);
                //hecho en la clase para ver como funcionaria ny las ventajas y desventajas
                switch (opcionInt) {
                    case 1 -> asignarAsignar(misDispositivos, misEmpleados); //metodo para asignar un equipo a un empleado
                    case 2 -> asignarDesasignar(misDispositivos, misEmpleados); //metodo para desasignar un equipo de un empleado
                    case 3 -> cerrar = true;
                    default -> System.out.println("Introduce un numero del 1-3");
                }

            } else {
                System.out.println("Opcion no valida");
            }

        }
    }
    private static void asignarAsignar(Dispositivo[][] misDispositivos, Empleado[] misEmpleados){ //los empleados tienen tres atributos uno por cada indice del dispositivo asignado de cada tipo y el dispositivo tendra el numero de empleado al que esta asginado, -1 signficara que no esta asignado
        Scanner sc = new Scanner(System.in);
        int indiceMaximo = 0;
        System.out.println("Estos son los dispositivos disponibles");
        for (int i = 0; i < 3; i++) {
            if (i == 0) indiceMaximo = 4;
            if (i == 1) indiceMaximo = 5;
            if (i == 2) indiceMaximo = 7;
            for (int j = 0; j < indiceMaximo; j++) {
                if (misDispositivos[i][j].getNumEmpleado() == -1 && misDispositivos[i][j].isActivo() && !misDispositivos[i][j].isReparacion()) System.out.println(misDispositivos[i][j]); //Moostramos los dispositivos que aun no estas asignados
            }
        }
        System.out.println("Que tipo de dispositivo quieres asignar?");
        System.out.println("1. Sobremesa");
        System.out.println("2. Portatil");
        System.out.println("3. Movil");
        int indiceTipo = sc.nextInt() - 1; //seleccionamos el tipo de dispositivo que queremos asignar
        System.out.println("Te recordamos los dispositivos disponibles de este tipo");
        if (indiceTipo == 0) indiceMaximo = 4;
        if (indiceTipo == 1) indiceMaximo = 5;
        if (indiceTipo == 2) indiceMaximo = 7;
        for (int i = 0; i <indiceMaximo; i++) { //mostramos lo dispositivos aun no asignados, que no estan en reparacion y activos del tipo seleccionado
            if (misDispositivos[indiceTipo][i].getNumEmpleado() == -1 && misDispositivos[indiceTipo][i].isActivo() && !misDispositivos[indiceTipo][i].isReparacion())
                System.out.println(misDispositivos[indiceTipo][i]);
        }
        System.out.println("Elige el dispositivo que quieres asignar"); //seleccionamos el dispositivo que queremos asignar
        int indiceDispositivo = sc.nextInt();
        System.out.println("Estos son los empleados a los que le puedes asignar ese dispositivo");
        for (Empleado empleado:misEmpleados //mostramos lo empleados que no tienen asignados un dispositivo del tipo seleccionado
             ) {
            if (indiceTipo == 0){
                if (empleado.getNumeroSobremesa() == -1 && empleado.isAlta() ) System.out.println(empleado);
            }
            if (indiceTipo == 1){
                if (empleado.getNumeroPortatil() == -1 && empleado.isAlta()) System.out.println(empleado);
            }
            if (indiceTipo == 2){
                if (empleado.getNumeroMovil() == -1 && empleado.isAlta()) System.out.println(empleado);
            }
        }
        System.out.println("Selecciona el empleado");
        int indiceEmpleado = sc.nextInt(); //seleccionamos al empleado al que queremos asignar el dispositivo
        misDispositivos[indiceTipo][indiceDispositivo].setNumEmpleado(indiceEmpleado); //seteamos al dispositivo seleccionado el numero de empleado al que se lo asignamos
        if (indiceTipo == 0){ //dependiendo del tipo asignamos al empleado el numero del dispositivo que le emos asignado
            Sobremesa sobremesa = (Sobremesa) misDispositivos[indiceTipo][indiceDispositivo];
            misEmpleados[indiceEmpleado].setNumeroSobremesa(sobremesa.getNumeroDispositivo());
        }
        if (indiceTipo == 1){
            Portatil portatil = (Portatil) misDispositivos[indiceTipo][indiceDispositivo];
            misEmpleados[indiceEmpleado].setNumeroPortatil(portatil.getNumeroDispositivo());
        }
        if (indiceTipo == 2){
            Movil movil = (Movil) misDispositivos[indiceTipo][indiceDispositivo];
            misEmpleados[indiceEmpleado].setNumeroPortatil(movil.getNumeroDispositivo());
        }
    }
    private static void asignarDesasignar(Dispositivo[][] misDispositivos, Empleado[] misEmpleados){ //metodo que quitara la asignacion de un equipo a un empleado
        Scanner sc = new Scanner(System.in);
        int indiceMaximo =0;
        System.out.println("Estos son los dispositivos que actualmente estan asignados");
        for (int i = 0; i < 3; i++) {
            if (i == 0) indiceMaximo = 4;
            if (i == 1) indiceMaximo = 5;
            if (i == 2) indiceMaximo = 7;
            for (int j = 0; j < indiceMaximo; j++) { //mostramos todos los dipositivos ya asignados y mostramos a quien esta asignado
                if (misDispositivos[i][j].getNumEmpleado() != -1 && misDispositivos[i][j].isActivo() && !misDispositivos[i][j].isReparacion()) System.out.println(misDispositivos[i][j] + " y esta asignado a " + misEmpleados[misDispositivos[i][j].getNumEmpleado()]);
            }
        }

        System.out.println("Que tipo de dispositivo quieres desasignar?");
        System.out.println("1. Sobremesa");
        System.out.println("2. Portatil");
        System.out.println("3. Movil");
        int indiceTipo = sc.nextInt() - 1; //seleccionamos el tipo del dispositivo que queremos desasignar
        System.out.println("Te recordamos los dispositivos disponibles de este tipo");
        if (indiceTipo == 0) indiceMaximo = 4;
        if (indiceTipo == 1) indiceMaximo = 5;
        if (indiceTipo == 2) indiceMaximo = 7;
        for (int i = 0; i <indiceMaximo; i++) { //mostramos todos los dispositivos de ese tipo que pueden ser desasignados
            if (misDispositivos[indiceTipo][i].getNumEmpleado() != -1 && misDispositivos[indiceTipo][i].isActivo() && !misDispositivos[indiceTipo][i].isReparacion())
                System.out.println(misDispositivos[indiceTipo][i] + " que lo tiene asignado " + misEmpleados[misDispositivos[indiceTipo][i].getNumEmpleado()]);
        }
        System.out.println("Elige el dispositivo que quieres desasignar");
        int indiceDispositivo = sc.nextInt(); //seleccionamos el dispositivo que queremos desasignar
            if (indiceTipo == 0){ //dependeiendo el tipo seteamos el atributo correpondiende del empleado a -1 (es un poco lio lo siento
                if (misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].getNumeroSobremesa() != -1 && misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].isAlta()) misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].setNumeroSobremesa(-1);
            }
            if (indiceTipo == 1){
                if (misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].getNumeroSobremesa() != -1 && misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].isAlta()) misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].setNumeroPortatil(-1);
            }
            if (indiceTipo == 2){
                if (misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].getNumeroSobremesa() != -1 && misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].isAlta()) misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].setNumeroMovil(-1);
            }
        misDispositivos[indiceTipo][indiceDispositivo].setNumEmpleado(-1); //seteamos el numero de empleado del dispositivo en -1

    }
    /*
    REPARACIONES //entiendo que solo se envian a reparar los que ya esta asignados
     */
    private static void reparacionesMenu(Dispositivo[][] misDispositivos, Empleado[] misEmpleados){
        Scanner sc = new Scanner(System.in);
        String opcionStr;
        int opcionInt;
        boolean cerrar = false;
        while (!cerrar) {
            System.out.println("1. Enviar a reparaciones");
            System.out.println("2. Devolver equipo de reparaciones");
            System.out.println("3. Volver al menu anterior");
            opcionStr = sc.nextLine();
            opcionInt = ValidarIntFromString.validarIntFromString(opcionStr);
            switch (opcionInt){
                case 1 -> reparacionesEnviar(misDispositivos, misEmpleados); //envia a reparar un dispositivo por lo que se desasignara y dejara de estar activo hasta que se recoja
                case 2 -> reparacionesDevolver(misDispositivos, misEmpleados); //recoge el dispositivo de la reparacion y lo vuelve activo
                case 3 -> cerrar = true;
                default -> System.out.println("Por favor un valor entre 1-3");
            }
        }
    }
    private static void reparacionesEnviar(Dispositivo[][] misDispositivos, Empleado[] misEmpleados){ //entiendo que solo se envian a taller los dispositivos que estan asignados
        Scanner sc = new Scanner(System.in);
        int indiceMaximo =0;
        System.out.println("Estos son los dispositivos que actualmente estan asignados"); //mostramos los dispositivos que estan asignados y pueden ser enviados a reparar
        for (int i = 0; i < 3; i++) {
            if (i == 0) indiceMaximo = 4;
            if (i == 1) indiceMaximo = 5;
            if (i == 2) indiceMaximo = 7;
            for (int j = 0; j < indiceMaximo; j++) {
                if (misDispositivos[i][j].getNumEmpleado() != -1 && misDispositivos[i][j].isActivo()) System.out.println(misDispositivos[i][j] + " y esta asignado a " + misEmpleados[misDispositivos[i][j].getNumEmpleado()]);
            }
        }
        System.out.println("Que tipo de dispositivo quieres enviar a reparacion?");
        System.out.println("1. Sobremesa");
        System.out.println("2. Portatil");
        System.out.println("3. Movil");
        int indiceTipo = sc.nextInt() - 1; //seleccionamos el tipo de dispositivo que queremos mandara  reparar
        System.out.println("Te recordamos los dispositivos disponibles de este tipo");
        if (indiceTipo == 0) indiceMaximo = 4;
        if (indiceTipo == 1) indiceMaximo = 5;
        if (indiceTipo == 2) indiceMaximo = 7;
        for (int i = 0; i <indiceMaximo; i++) { //mostramos los dispositivos que se pueden mandar a reparar de ese tipo
            if (misDispositivos[indiceTipo][i].getNumEmpleado() != -1 && misDispositivos[indiceTipo][i].isActivo())
                System.out.println(misDispositivos[indiceTipo][i] + " que lo tiene asignado " + misEmpleados[misDispositivos[indiceTipo][i].getNumEmpleado()]);
        }
        System.out.println("Elige el dispositivo que quieres enviar a reparar");
        int indiceDispositivo = sc.nextInt(); //elegimos el dispositivo que queremos mandar a reparar
        if (indiceTipo == 0){ //dependiendo el tipo desasignamos el dispositivo al empleado
            if (misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].getNumeroSobremesa() != -1 && misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].isAlta()) misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].setNumeroSobremesa(-1);
        }
        if (indiceTipo == 1){
            if (misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].getNumeroSobremesa() != -1 && misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].isAlta()) misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].setNumeroPortatil(-1);
        }
        if (indiceTipo == 2){
            if (misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].getNumeroSobremesa() != -1 && misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].isAlta()) misEmpleados[misDispositivos[indiceTipo][indiceDispositivo].getNumEmpleado()].setNumeroMovil(-1);
        }
        misDispositivos[indiceTipo][indiceDispositivo].setNumEmpleado(-1); //desasignamos el empleado al dispositivo
        misDispositivos[indiceTipo][indiceDispositivo].setReparacion(true);//seteamos el valor reparacion a true
    }
    private static void reparacionesDevolver(Dispositivo[][] misDispositivos, Empleado[] misEmpleados){
        Scanner sc = new Scanner(System.in);
        int indiceMaximo =0;
        System.out.println("Estos son los dispositivos que actualmente en reparacion"); //mostramos todos los dispositivos que estan en reparacion
        for (int i = 0; i < 3; i++) {
            if (i == 0) indiceMaximo = 4;
            if (i == 1) indiceMaximo = 5;
            if (i == 2) indiceMaximo = 7;
            for (int j = 0; j < indiceMaximo; j++) {
                if (misDispositivos[i][j].isReparacion() && misDispositivos[i][j].isActivo()) System.out.println(misDispositivos[i][j]);
            }
        }
        System.out.println("Que tipo de dispositivo quieres devolver de reparacion?");
        System.out.println("1. Sobremesa");
        System.out.println("2. Portatil");
        System.out.println("3. Movil");
        int indiceTipo = sc.nextInt() - 1; //seleccionamos el tipo de dispositivo que queremos desasignar
        System.out.println("Te recordamos los dispositivos disponibles de este tipo");
        if (indiceTipo == 0) indiceMaximo = 4;
        if (indiceTipo == 1) indiceMaximo = 5;
        if (indiceTipo == 2) indiceMaximo = 7;
        for (int i = 0; i <indiceMaximo; i++) { //mostramos los dispositivos que pueden ser recogidos de reparaciones de este tipo
            if (misDispositivos[indiceTipo][i].isReparacion() && misDispositivos[indiceTipo][i].isActivo())
                System.out.println(misDispositivos[indiceTipo][i]);
        }
        System.out.println("Elige el dispositivo que quieres devolver de reparacion");
        int indiceDispositivo = sc.nextInt(); //seleccionamos el dispositivo
        misDispositivos[indiceTipo][indiceDispositivo].setReparacion(false); //seteamos el atributo reparacion a true
    }
    /*
     RESTO DE UTILIDADES
    */

    private static int contarEmpleadosActivos(Empleado[] misEmpleados){
        int contador = 0;
        for (Empleado empleado:misEmpleados
             ) {
            if (empleado.isAlta())contador++;
        }
        return contador;
    }
    private static int contarDispositivosActivos(Dispositivo[][] misDispositivos){
        int contador = 0, indiceMaximo = 0;
        for (int i = 0; i < 3; i++) {
            if (i == 0) indiceMaximo = 4;
            if (i == 1) indiceMaximo = 5;
            if (i == 2) indiceMaximo = 7;
            for (int j = 0; j < indiceMaximo; j++) {
                if (misDispositivos[i][j].isActivo()) contador++;
            }
        }
        return contador;
    }
    /*
    CREACCION DE OBJETOS
     */
    private static Empleado[]crearEmpelados(int numeroEmpleados){
        Empleado[] misEmpleados = new Empleado[numeroEmpleados];
        misEmpleados[0] = new Empleado("Pepe", "Botica", "123456789A", true);
        misEmpleados[1] = new Empleado("Manolo", "Kabezabolo", "234567891B", true);
        misEmpleados[2] = new Empleado("Juliana", "Martinez", "345678912C", true);
        misEmpleados[3] = new Empleado("Benito", "Camelas", "456789123D", true);
        misEmpleados[4] = new Empleado(false);
        misEmpleados[5] = new Empleado(false);
        misEmpleados[6] = new Empleado(false);
        return misEmpleados;
    }
    private static Dispositivo[][] crearDispositivos(){
        Sobremesa[] misSobremesas = new Sobremesa[4];
        Portatil[] misPortatiles = new Portatil[5];
        Movil[] misMoviles = new Movil[7];
        Dispositivo[][] misDispositivos = {misSobremesas, misPortatiles, misMoviles};
        misDispositivos[0][0] = new Sobremesa("123-abc", "dell", "ultraPower3000", 23.45, -1,true, 1000, 16, "logitech", "logitech", "benq");
        misDispositivos[0][1] = new Sobremesa("456-def", "dell", "mediumPower1000", 21, -1, true, 500, 8, "logitech", "logitech", "benq");
        misDispositivos[0][2] = new Sobremesa(false);
        misDispositivos[0][3] = new Sobremesa(false);
        misDispositivos[1][0] = new Portatil("789-ghi", "acer", "portable404", 13.2, -1, true, true, 500, 16);
        misDispositivos[1][1] = new Portatil("123-jkl", "acer", "portable404", 13.2, -1,true, true, 500, 16);
        misDispositivos[1][2] = new Portatil("456-mno", "hp", "thermomixAvanzadisima", 15.9, -1, true, false, 200, 8);
        misDispositivos[1][3] = new Portatil(false);
        misDispositivos[1][4] = new Portatil(false);
        misDispositivos[2][0] = new Movil("789-pqr", "motorola", "patataMovil", 5.4, -1, true, 16);
        misDispositivos[2][1] = new Movil("123-stu", "motorola", "patataMovil", 5.4, -1, true, 16);
        misDispositivos[2][2] = new Movil("456-vwx", "samsung", "movilCoreano503", 6.2, -1, true, 24);
        misDispositivos[2][3] = new Movil("789-yza", "samsung", "movilCoreano503", 6.2, -1, true, 24);
        misDispositivos[2][4] = new Movil(false);
        misDispositivos[2][5] = new Movil(false);
        misDispositivos[2][6] = new Movil(false);

        return misDispositivos;
    }
}
