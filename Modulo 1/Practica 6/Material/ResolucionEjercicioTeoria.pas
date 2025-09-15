program NexusOrganigrama;

type
    empleado = record
        idEmpleado: integer;
        nombreCompleto: string;
        puesto: string;
        idManager: integer;
    end;

    listaEmpleados = ^nodoLista;
    nodoLista = record
        dato: empleado;
        sig: listaEmpleados;
    end;
    
    infoNodoArbol = record
        salario: real;
        empleados: listaEmpleados;
    end;

    arbolSalarios = ^nodoArbol;
    nodoArbol = record
        dato: infoNodoArbol;
        HI: arbolSalarios;
        HD: arbolSalarios;
    end;

procedure AgregarAdelante(var L: listaEmpleados; emp: empleado);
var
    nuevo: listaEmpleados;
begin
    new(nuevo);
    nuevo^.dato := emp;
    nuevo^.sig := L;
    L := nuevo;
end;

procedure ImprimirListaEmpleados(L: listaEmpleados);
begin
    if (L = nil) then
        writeln('No hay empleados para este salario.')
    else
        while (L <> nil) do
        begin
            writeln('  - ID: ', L^.dato.idEmpleado, ' | Nombre: ', L^.dato.nombreCompleto, ' | Puesto: ', L^.dato.puesto);
            L := L^.sig;
        end;
end;

procedure IngresarEmpleado(var a: arbolSalarios; emp: empleado; salario:real);
begin
    if (a = nil) then
    begin
        new(a);
        a^.dato.salario := salario;
        a^.dato.empleados := nil;
        AgregarAdelante(a^.dato.empleados, emp);
        a^.HI := nil;
        a^.HD := nil;
    end
    else if (salario = a^.dato.salario) then
        AgregarAdelante(a^.dato.empleados, emp)
    else if (salario < a^.dato.salario) then
        IngresarEmpleado(a^.HI, emp, salario)
    else
        IngresarEmpleado(a^.HD, emp, salario);
end;

procedure BuscarPorSalario(a: arbolSalarios; salarioBuscado: real);
begin
    if (a = nil) then
        writeln('No se encontraron empleados con el salario ', salarioBuscado:2:2)
    else if (salarioBuscado = a^.dato.salario) then
    begin
        writeln('Empleados encontrados con salario ', salarioBuscado:2:2, ':');
        ImprimirListaEmpleados(a^.dato.empleados);
    end
    else if (salarioBuscado < a^.dato.salario) then
        BuscarPorSalario(a^.HI, salarioBuscado)
    else
        BuscarPorSalario(a^.HD, salarioBuscado);
end;

procedure InformeDeSalarios(a: arbolSalarios);
begin
    if (a <> nil) then
    begin
        InformeDeSalarios(a^.HI);
        writeln('- ', a^.dato.salario:2:2);
	    ImprimirListaEmpleados(a^.dato.empleados);
        InformeDeSalarios(a^.HD);
    end;
end;

procedure BuscarMinimo(var a: arbolSalarios; var sucesor: arbolSalarios);
begin
    if (a^.HI = nil) then
    begin
        sucesor := a;
        a := a^.HD;
    end
    else
        BuscarMinimo(a^.HI, sucesor);
end;

procedure BorrarNodoArbol(var a: arbolSalarios; salarioAEliminar: real);
var
    nodoAEliminar: arbolSalarios;
begin
    if (a <> nil) then begin
        if (salarioAEliminar < a^.dato.salario) then
            BorrarNodoArbol(a^.HI, salarioAEliminar)
        else if (salarioAEliminar > a^.dato.salario) then
            BorrarNodoArbol(a^.HD, salarioAEliminar)
        else begin
            if (a^.HI = nil) then 
            begin
                nodoAEliminar := a;
                a := a^.HD;
                dispose(nodoAEliminar);
            end
            else if (a^.HD = nil) then
            begin
                nodoAEliminar := a;
                a := a^.HI;
                dispose(nodoAEliminar);
            end
            else
            begin
                BuscarMinimo(a^.HD, nodoAEliminar);
                a^.dato := nodoAEliminar^.dato;
                dispose(nodoAEliminar);
            end;
        end;
    end;
end;

procedure BuscarEnLista(var L: listaEmpleados; var emp: empleado; id: integer; var encontrado: boolean);
var
    actual, anterior: listaEmpleados;
begin
    actual := L;
    anterior := L;
    encontrado := false;
    while (actual <> nil) and (actual^.dato.idEmpleado <> id) do
    begin
        anterior := actual;
        actual := actual^.sig;
    end;
    if (actual <> nil) then
    begin
    	encontrado := true;
        emp := actual^.dato;
        if (actual = L) then
            L := actual^.sig
        else
            anterior^.sig := actual^.sig;
        dispose(actual);
    end;
end;

procedure ExtraerEmpleado(var a: arbolSalarios; id: integer; var empEncontrado: empleado; var exito: boolean);
var
    salarioDelNodo: real;
begin
    if (a = nil) then
        exito := false
    else
    begin
        salarioDelNodo := a^.dato.salario;
        BuscarEnLista(a^.dato.empleados,empEncontrado,id,exito);
        if (exito) then
        begin
            if (a^.dato.empleados = nil) then begin
                
                BorrarNodoArbol(a, salarioDelNodo);
            end
        end
        else
        begin
            ExtraerEmpleado(a^.HI, id, empEncontrado, exito);
            if not(exito) then
                 ExtraerEmpleado(a^.HD, id, empEncontrado, exito);
        end;
    end;
end;

procedure ActualizarSalario(var a: arbolSalarios; id: integer; nuevoSalario: real);
var
    emp: empleado;
    exito: boolean;
begin
    
    ExtraerEmpleado(a, id, emp, exito);
    if (exito) then
    begin
        IngresarEmpleado(a, emp, nuevoSalario);
        writeln('Salario del empleado ID ', id, ' actualizado correctamente.');
    end
    else
        writeln('No se encontro un empleado con ID ', id, ' para actualizar.');
end;

var
    miOrganigrama: arbolSalarios;
    emp: empleado;
    opcion: integer;
    salarioAct:real;
    salarioBuscado, nuevoSalario: real;
    idBuscado: integer;
begin
    miOrganigrama := nil;
    
    emp.idEmpleado := 101; emp.nombreCompleto := 'Ana Lopez'; emp.puesto := 'CEO'; salarioAct := 150000.0; emp.idManager := 0;
    IngresarEmpleado(miOrganigrama, emp, salarioAct);
    emp.idEmpleado := 202; emp.nombreCompleto := 'Juan Perez'; emp.puesto := 'CTO'; salarioAct := 120000.0; emp.idManager := 101;
    IngresarEmpleado(miOrganigrama, emp, salarioAct);
    emp.idEmpleado := 303; emp.nombreCompleto := 'Maria Garcia'; emp.puesto := 'Ingeniero Senior'; salarioAct := 80000.0; emp.idManager := 202;
    IngresarEmpleado(miOrganigrama, emp, salarioAct);
    emp.idEmpleado := 304; emp.nombreCompleto := 'Carlos Ruiz'; emp.puesto := 'Ingeniero Senior'; salarioAct := 80000.0; emp.idManager := 202;
    IngresarEmpleado(miOrganigrama, emp, salarioAct);
    emp.idEmpleado := 401; emp.nombreCompleto := 'Laura Fernandez'; emp.puesto := 'Disenador UX'; salarioAct := 75000.0; emp.idManager := 202;
    IngresarEmpleado(miOrganigrama, emp, salarioAct);

    repeat
        writeln;
        writeln('--- Sistema de Gestion Nexus ---');
        writeln('1. Ingresar un nuevo empleado');
        writeln('2. Buscar empleados por salario');
        writeln('3. Actualizar salario de un empleado');
        writeln('4. Generar informe de salarios (ordenado)');
        writeln('0. Salir');
        write('Seleccione una opcion: ');
        readln(opcion);
        writeln;

        case opcion of
            1: begin
                write('ID Empleado (<> -1): '); readln(emp.idEmpleado);
                if(emp.idEmpleado <> -1) then begin
                    write('Nombre Completo: '); readln(emp.nombreCompleto);
                    write('Puesto: '); readln(emp.puesto);
                    write('Salario: '); readln(salarioAct);
                    write('ID Manager: '); readln(emp.idManager);
                    IngresarEmpleado(miOrganigrama, emp, salarioAct);
                    writeln('Empleado ingresado.');
                end else writeln('NO se admite la ID -1');
               end;
            2: begin
                write('Ingrese el salario a buscar: ');
                readln(salarioBuscado);
                BuscarPorSalario(miOrganigrama, salarioBuscado);
               end;
            3: begin
                write('Ingrese el ID del empleado a actualizar: ');
                readln(idBuscado);
                write('Ingrese el nuevo salario: ');
                readln(nuevoSalario);
                ActualizarSalario(miOrganigrama, idBuscado, nuevoSalario);
               end;
            4: begin
                writeln('Informe de Salarios (de menor a mayor):');
                InformeDeSalarios(miOrganigrama);
               end;
            0: writeln('Saliendo!!');
        else
            writeln('Opcion no valida.');
        end;
    until opcion = 0;
end.