program app;
Type
    // Lista de enteros
    lista = ^nodoL;
    nodoL = record
        dato: integer;
        sig: lista;
    end;

    // Arbol de enteros
    arbol= ^nodoA;
    nodoA = Record
        dato: integer;
        HI: arbol;
        HD: arbol;
    End;

    // Lista de Arboles
    listaNivel = ^nodoN;
    nodoN = record
        info: arbol;
        sig: listaNivel;
    end;


procedure agregarOrdenado(var pri: lista; dato: integer);
var
   nuevo, anterior, actual: lista;
begin
     new (nuevo);
     nuevo^.dato:= dato;
     nuevo^.sig := nil;
     if (pri = nil) then
          pri := nuevo
     else
     begin
        actual := pri;
        anterior := pri;
        while ( actual <> nil ) and ( actual^.dato < nuevo^.dato ) do begin
            anterior := actual;
            actual:= actual^.sig;
        end;
        if (anterior = actual) then
            pri := nuevo
        else
            anterior^.sig := nuevo;
        nuevo^.sig := actual;
     end;
end;


{-----------------------------------------------------------------------------
CREARLISTA - Genera una lista con n�meros aleatorios }
procedure crearLista(var l: Lista);
var
    n: integer;
begin
    l:= nil;
    n := random (20);
    While (n <> 0) do Begin
        agregarOrdenado(l, n);
        n := random (20);
    End;
end;


{-----------------------------------------------------------------------------
IMPRIMIRLISTA - Muestra en pantalla la lista l }
procedure imprimirLista(l: Lista);
begin
    While (l <> nil) do begin
        write(l^.dato, ' - ');
        l:= l^.sig;
    End;
end;

{-----------------------------------------------------------------------------
CONTARELEMENTOS - Devuelve la cantidad de elementos de una lista l }
function ContarElementos (l: listaNivel): integer;
    var c: integer;
begin
    c := 0;
    While (l <> nil) do begin
        c:= c + 1;
        l:= l^.sig;
    End;
    contarElementos := c;
end;

{-----------------------------------------------------------------------------
AGREGARATRAS - Agrega un elemento atr�s en l}

Procedure AgregarAtras (var l, ult: listaNivel; a:arbol);
var
    nue:listaNivel;
begin
    new (nue);
    nue^.info := a;
    nue^.sig := nil;
    if l= nil then
        l:= nue
    else
        ult^.sig:= nue;
    ult:= nue;
end;

{-----------------------------------------------------------------------------
IMPRIMIRPORNIVEL - Muestra los datos del �rbol a por niveles }

Procedure imprimirpornivel(a: arbol);
var
   l, aux, ult: listaNivel;
   nivel, cant, i: integer;
begin
    l:= nil;
    if(a <> nil) then begin
        nivel:= 0;
        agregarAtras (l, ult, a);
        while (l <> nil) do begin
            nivel := nivel + 1;
            cant := contarElementos(l);
            write ('Nivel ', nivel, ': ');
            for i := 1 to cant do begin
                write (l^.info^.dato, ' - ');
                if (l^.info^.HI <> nil) then agregarAtras (l, ult, l^.info^.HI);
                if (l^.info^.HD <> nil) then agregarAtras (l, ult, l^.info^.HD);
                aux := l;
                l := l^.sig;
                dispose (aux);
            end;
            writeln;
        end;
    end;
end;

procedure insertarDato(var a: arbol; dato: integer);
var
    nue: arbol;
begin
    new(nue);
    nue^.dato := dato;
    nue^.HI := Nil;
    nue^.HD := Nil;
    a := nue
end;

procedure insertarAAB(var a: arbol; dato: integer);
begin
    if ( a = Nil ) then
        insertarDato(a, dato)
    else begin
        if ( dato < a^.dato ) then begin
            if ( a^.HI = Nil ) then begin
                insertarDato(a^.HI, dato);
            end
            else begin
                insertarAAB(a^.HI, dato);
            end;
        end
        else if ( dato > a^.dato ) then begin
            if ( a^.HD = Nil ) then begin
                insertarDato(a^.HD, dato);
            end
            else begin
                insertarAAB(a^.HD, dato);
            end;
        end;
    end;
end;

procedure cargarListaEnAAB(var a: arbol; l: lista);
begin
    a := Nil;
    while ( l <> Nil ) do begin
        insertarAAB(a, l^.dato);
        l := l^.sig;
    end;
end;

Var
    l: lista;
    a: arbol;
begin
    Randomize;

    crearLista(l);
    writeln ('Lista generada: ');
    imprimirLista(l);
    writeln;
    cargarListaEnAAB(a, l);
    imprimirpornivel(a);
    readln;
end.
