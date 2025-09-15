program app;

type
    venta = record
        codigo: Integer;
        cantidad: Integer;
        fecha: String[10];
        numeroCliente: Integer;
    end;

arbol = ^nodo;
nodo = record
    dato: venta;
    HI: arbol;
    HD: arbol;
end;

//////////////////////////////////////////MODULES///////////////////////////////////////////////////////////////
//inicializa y agragar al arbol//
    function inicializarArbol(a:arbol): arbol;
        begin
            inicializarArbol := nil;
        end;

    function crearNodo(a:arbol; v: venta): arbol;
        begin
            if a = nil then
                begin
                    new(a);
                    a^.dato := v;
                    a^.HI := nil;
                    a^.HD := nil;
                    crearNodo := a;
                end
            else if v.codigo < a^.dato.codigo then
                    a^.HI := crearNodo(a^.HI, v)
                else
                    if v.codigo > a^.dato.codigo then
                    a^.HD := crearNodo(a^.HD, v);
        end;

    function insertarVenta(a: arbol): arbol;
        var
            v: venta;
        begin
            writeln('ingrese codigo de venta: '); read(v.codigo);
            writeln('ingrese cantidad vendida(en Kg): '); read(v.cantidad);
            writeln('ingrese fecha de venta(dd/mm/aaaa): '); read(v.fecha);
            writeln('ingrese numero de cliente: '); read(v.numeroCliente);
            insertarVenta := crearNodo(a,v);
        end;

//imprimir//
    procedure imprimirVentas(a: arbol);
        begin
            if a <> nil then
                begin
                    imprimirVentas(a^.HI);
                    writeln('codigo: ', a^.dato.codigo);
                    writeln('cantidad vendida(en Kg): ', a^.dato.cantidad);
                    writeln('fecha de venta(dd/mm/aaaa): ', a^.dato.fecha);
                    writeln('numero de cliente: ', a^.dato.numeroCliente);
                    writeln('------------------------------');
                    imprimirVentas(a^.HD);
                end;
        end;

    procedure imprimirVentasArbol(a: arbol);
        begin
            if a = nil then
                writeln('el arbol esta vacio')
            else
                imprimirVentas(a);
        end;

//busqueda//
    function buscarVenta(a: arbol; codigo: Integer): arbol;
        begin
            if a = nil then
                begin
                    writeln('el codigo no se encuentra en el arbol');
                    buscarVenta := nil;
                end
            else if codigo = a^.dato.codigo then
                    begin
                        writeln('codigo: ', a^.dato.codigo);
                        writeln('cantidad vendida(en Kg): ', a^.dato.cantidad);
                        writeln('fecha de venta(dd/mm/aaaa): ', a^.dato.fecha);
                        writeln('numero de cliente: ', a^.dato.numeroCliente);
                        buscarVenta := a;
                    end
                else if codigo < a^.dato.codigo then
                        buscarVenta := buscarVenta(a^.HI, codigo)
                    else
                        buscarVenta := buscarVenta(a^.HD, codigo);
        end;

    procedure recibirCodigo(a:arbol);
        var 
            codigo: Integer;
        begin
            writeln('ingrese codigo a buscar: '); read(codigo);
            buscarVenta(a,codigo);
        end;

//mas de 100kg vendidos//
    function masDe100kgVendidos(a: arbol; cant:integer): Integer;
        begin
            if a <> nil then
                if a^.dato.cantidad > 100 then
                    begin
                        cant := cant + 1;
                        masDe100kgVendidos(a^.HI, cant);
                        WriteLn('El codigo ', a^.dato.codigo, ' tiene mas de 100kg vendidos.');
                        masDe100kgVendidos(a^.HD, cant);
                    end;
        end;
    procedure analizarCantidad(a: arbol);
        var
            cant: Integer;
        begin
            cant := 0;
            if a = nil then
                writeln('el arbol esta vacio')
            else
                masDe100kgVendidos(a,cant);
                if masDe100kgVendidos(a,cant) = 0 then
                    writeln('no hay ventas con mas de 100kg vendidos');
        end;

//menu//
    procedure menu();
        var
            a: arbol;
            opcion: Integer;
        begin
            a := nil;
            opcion := 0;
            while (opcion <> 6) do
                begin
                    writeln('Menu de opciones:');
                    writeln('1.inicializar arbol');
                    writeln('2.insertar venta');
                    writeln('3.imprimir ventas');
                    WriteLn('4.buscar venta por codigo');
                    Writeln('5.mas de 100kg vendidos');
                    Writeln('6.salir');
                    writeln('ingrese una opcion: ');    read(opcion);
                    case opcion of
                        1: inicializarArbol(a);
                        2: insertarVenta(a);
                        3: imprimirVentas(a);
                        4: recibirCodigo(a);
                        5: analizarCantidad(a);
                        6: writeln('saliendo del programa...');
                        else writeln('opcion invalida, ingrese nuevamente');
                    end;
                end;
        end;

//////////////////////////////////////////MAIN CODE///////////////////////////////////////////////////////////////

begin
    menu();
end.