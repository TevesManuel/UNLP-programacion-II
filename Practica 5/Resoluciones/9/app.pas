Program app;
Type
    encomienda = record
        codigo: integer;
        peso: integer;
    end;

    // Lista de encomiendas
    lista = ^nodoL;
    nodoL = record
        dato: encomienda;
        sig: lista;
    end;

    arbolEncomienda = ^nodoArbolEncomienda; // Arbol de encomiendas
    nodoArbolEncomienda = record
        codigo: integer;
        hi, hd: arbolEncomienda;
    end;
    arbol = ^nodoArbol; // Arbol de pesos
    nodoArbol = record
        peso: integer;
        encomiendas: arbolEncomienda;
        hi, hd: arbol;
    end;

{-----------------------------------------------------------------------------
AgregarAdelante - Agrega una encomienda adelante en l}
procedure agregarAdelante(var l: Lista; enc: encomienda);
var
    aux: lista;
begin
    new(aux);
    aux^.dato := enc;
    aux^.sig := l;
    l:= aux;
end;

{-----------------------------------------------------------------------------
CREARLISTA - Genera una lista con datos de las encomiendas }
procedure crearLista(var l: Lista);
var
    e: encomienda;
    i: integer;
begin
    l:= nil;
    for i:= 1 to 20 do begin
        e.codigo := i;
        e.peso:= random (10);
        while (e.peso = 0) do
            e.peso:= random (10);
        agregarAdelante(L, e);
    end;
end;


{-----------------------------------------------------------------------------
IMPRIMIRLISTA - Muestra en pantalla la lista l }
procedure imprimirLista(l: Lista);
begin
    While (l <> nil) do begin
        writeln('Codigo: ', l^.dato.codigo, '    Peso: ', l^.dato.peso);
        l:= l^.sig;
    End;
end;

procedure agregarAABE(var a: arbolEncomienda; d: integer);
var
    nue: arbolEncomienda;
begin
    if( a = Nil ) then begin
        new(nue);
        nue^.codigo := d;
        nue^.HI := Nil;
        nue^.HD := Nil;
        a := nue;
    end
    else begin
        if ( d < a^.codigo ) then
            agregarAABE(a^.HI, d)
        else
            agregarAABE(a^.HD, d);
    end;
end;

procedure agregarAAB(var a: arbol; d: encomienda);
var
    nue: arbol;
begin
    if ( a = Nil ) then begin
        new(nue);
        nue^.HI := Nil;
        nue^.HD := Nil;
        nue^.peso := d.peso;
        agregarAABE(nue^.encomiendas, d.codigo);
        a := nue;
    end
    else begin
        if ( d.peso > a^.peso ) then
            agregarAAB(a^.HD, d)
        else if ( d.peso < a^.peso ) then
            agregarAAB(a^.HI, d)
        else
            agregarAABE(a^.encomiendas, d.codigo);
    end;
end;

procedure cargarListaEnAAB(var a: arbol; l: Lista);
begin
    While (l <> nil) do begin
        agregarAAB(a, l^.dato);
        l := l^.sig;
    End;
end;

procedure imprimirAABE(a: arbolEncomienda);
begin
    if ( a <> Nil ) then begin
        imprimirAABE(a^.HI);
        writeln(#9, 'Codigo: ', a^.codigo, ': ');
        imprimirAABE(a^.HD);
    end;
end;
procedure imprimirAAB(a: arbol);
begin
    if ( a <> Nil ) then begin
        imprimirAAB(a^.HI);
        writeln('Peso ', a^.peso, ': ');
        imprimirAABE(a^.encomiendas);
        imprimirAAB(a^.HD);
    end;
end;

Var
    l: lista;
    a: arbol;
begin
    Randomize;

    crearLista(l);
    writeln ('Lista de encomiendas generada: ');
    imprimirLista(l);
    cargarListaEnAAB(a, l);
    imprimirAAB(a);
    readln;
end.
