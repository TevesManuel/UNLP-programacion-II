Program productos;
Uses
    sysutils;
Type
    producto = record
        codigo: integer;
        nombre: string;
        marca: string;
        anio: 2000..2022;
        precio: real;
    end;

    listaProductos = ^nodoLista;
    nodoLista = record
        dato: producto;
        sig: listaProductos;
    end;
{Implementaciones para el inciso (a) ->}
Type
    Marca = record
        nombre: string;
        productos: listaProductos;
    end;
    ListaMarcas = ^NodoMarca;
    NodoMarca = record
        dato: Marca;
        sig: ListaMarcas;
    end;


Procedure agregarFinalMarca(var l: ListaMarcas; m: marca);
var
    nue: ListaMarcas;
    ant: ListaMarcas;
    act: ListaMarcas;
begin
    new(nue);
    nue^.dato := m;
    nue^.sig := Nil;
    
    act := l;
    ant := Nil;
    while act <> Nil do begin
        ant := act;
        act := act^.sig;
    end;

    if ant = Nil then begin
        l := nue;
    end
    else begin
        ant^.sig := nue;
    end;
end;

Procedure agregarFinal(var l: listaProductos; p: producto);
var
    nue: listaProductos;
    ant: listaProductos;
    act: listaProductos;
begin
    new(nue);
    nue^.dato := p;
    nue^.sig := Nil;
    
    act := l;
    ant := Nil;
    while act <> Nil do begin
        ant := act;
        act := act^.sig;
    end;

    if ant = Nil then begin
        l := nue;
    end
    else begin
        ant^.sig := nue;
    end;
end;
{<- Implementaciones para el inciso (a)}


Procedure agregarAdelante(var l: listaProductos; p: producto);
var
   aux: listaProductos;
begin
    new(aux);
    aux^.dato := p;
    aux^.sig := l;
    l:= aux;
end;

{crearLista - Genera una lista con productos aleatorios}
procedure crearLista(var l: listaProductos);
var
    i,j:integer;
    p: producto;

    v : array [1..10] of string;
begin
    v[1]:= 'Abercom';
    v[2]:= 'Aluminium';
    v[3]:= 'ClearWindows';
    v[4]:= 'IndArg';
    v[5]:= 'La Foret';
    v[6]:= 'Open';
    v[7]:= 'Portal';
    v[8]:= 'Puertamania';
    v[9]:= 'PVCPremium';
    v[10]:= 'Ventalum';

    for i:=random(10) downto 1 do {for de marca}
    begin
        p.marca:= v[i];
        for j:=random(5) downto 1 do {for de anio}
        begin
        p.anio:= 2016+j;
        p.codigo:= random(10);
        while (p.codigo <> 0) do Begin
            p.nombre:= Concat('Producto-', IntToStr(random (200)));
            p.precio := random(1000000);
            agregarAdelante(l, p);
            p.codigo:= random(10);
        end;
        end;
    end;
end;

procedure imprimirV(p: producto);
begin
    with (p) do begin
        writeln(#9, 'Producto', nombre, ' con codigo ',codigo, ': ', marca, ' Anio:', anio, ' Precio: ', precio:2:2);
    end;
end;

{imprimir - Muestra en pantalla el producto}
procedure imprimir(p: producto);
begin
    with (p) do begin
        writeln(#9, #9, codigo, ' ', nombre, ' ', precio:2:2);
    end;
end;

{imprimirLista - Muestra en pantalla la lista l}
procedure imprimirListaV(l: listaProductos);
begin
    while (l <> nil) do begin
        imprimirV(l^.dato);
        l := l^.sig;
    end;
end;

{imprimirLista - Muestra en pantalla la lista l}
procedure imprimirLista(l: listaProductos; var cantProductos: integer);
var
    anioActual: integer;
    cantProductosAnio: integer;
begin
    while (l <> nil) do begin
        anioActual := l^.dato.anio;
        cantProductosAnio := 0;
        writeln(#9, 'Anio: ', anioActual);
        while (l <> nil) and (l^.dato.anio = anioActual) do begin
            imprimir(l^.dato);
            l := l^.sig;
            cantProductos := cantProductos + 1;
            cantProductosAnio := cantProductosAnio + 1;
        end;
        WriteLn(#9, 'Total productos anio ', anioActual, ': ', cantProductosAnio);
    end;
end;

procedure imprimirListaMarcas(l: ListaMarcas);
var
    cantProductos: integer;
begin
    while (l <> Nil) do begin
        cantProductos := 0;
        WriteLn('Marca: ', l^.dato.nombre);
        imprimirLista(l^.dato.productos, cantProductos);
        WriteLn('Total productos ', l^.dato.nombre, ': ', cantProductos);
        l := l^.sig;
    end;
end;

procedure convertirLista(l: listaProductos; var lm: ListaMarcas);
var
    nuevaMarca: Marca;
begin
    while l <> Nil do begin
        nuevaMarca.nombre := l^.dato.marca;
        nuevaMarca.productos := Nil;
        while (l <> Nil) and (l^.dato.marca = nuevaMarca.nombre) do begin
            agregarFinal(nuevaMarca.productos, l^.dato);
            l := l^.sig;
        end;
        agregarFinalMarca(lm, nuevaMarca);
    end;
end;

procedure decorador();
begin
    writeln('-------------------------------------------------------------------------------------------------------');
end;

{Implementaciones para el inciso b ->}
procedure calcularMarca(lm: ListaMarcas; nombreMarca: string; anioMin: integer; anioMax: integer; precioMin: real);
var
    contador: integer;
    productoActual: listaProductos;
begin
    contador := 0;
    while(lm <> Nil) and (lm^.dato.nombre <> nombreMarca) do begin
        lm := lm^.sig;
    end;
    if (lm <> Nil) then begin // Encontro la marca
        productoActual := lm^.dato.productos;
        while (productoActual <> Nil) do begin
            writeln('A', (productoActual^.dato.anio >= anioMin));
            writeln('B', (productoActual^.dato.anio <= anioMax));
            writeln('C', (productoActual^.dato.precio >= precioMin));
            if (productoActual^.dato.anio >= anioMin) and (productoActual^.dato.anio <= anioMax) and (productoActual^.dato.precio >= precioMin) then begin
                contador := contador + 1;
            end;
            productoActual := productoActual^.sig;
        end;
        writeln('La marca ', nombreMarca, ' tiene ', contador, ' productos fabricados e/ ', anioMin, ' y ', anioMax, ' cuyos precios superan los ', precioMin:2:2);
    end;
end;
{<- Implementaciones para el inciso b}

procedure esperarParaSalir();
begin
    Write('Presionar enter para salir.');
    readln;
end;

var
    l: listaProductos;
    lm: ListaMarcas;
begin
    Randomize;
    l:= Nil;
    lm := Nil;
    crearLista(l);
    writeln ('Lista generada: ');
    imprimirListaV(l);
    convertirLista(l, lm);
    decorador();
    calcularMarca(lm, 'Abercom', 2020, 2023, 100000.0);
    decorador();
    imprimirListaMarcas(lm);
    decorador();
    esperarParaSalir();
end.
