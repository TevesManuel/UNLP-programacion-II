program app;

type

    TPaciente = record
        dni: LongInt;
        cp: integer;
        ciudad: string;
    end;

    listaPacientes = ^nodoPaciente;
    nodoPaciente = record
        dato: TPaciente;
        sig: listaPacientes;
    end;

    arbol = ^TNodoArbol;
    TNodoArbol = record
        cp: integer;
        ciudad: string;
        cantInfec: integer;
        HI: arbol;
        HD: arbol;
    end;

Procedure agregarAdelante(var l: listaPacientes; p: TPaciente);
var
   aux: listaPacientes;
begin
    new(aux);
    aux^.dato := p;
    aux^.sig := l;
    l:= aux;
end;

procedure crearLista(var l: listaPacientes);
var
    p: TPaciente;
    v : array [1..10] of string;
    i: integer;
begin
    v[1] := 'Madrid';
    v[2] := 'Buenos Aires';
    v[3] := 'Londres';
    v[4] := 'Roma';
    v[5] := 'Tokio';
    v[6] := 'París';
    v[7] := 'Berlín';
    v[8] := 'Lisboa';
    v[9] := 'Montevideo';
    v[10] := 'Nueva York';

    for i := 1 to 10 do begin
        p.dni := 47020963 + random(100);
        p.cp := 1700 + random(300);
        p.ciudad := v[random(9)+1];
        agregarAdelante(l, p);
    end;
end;

procedure imprimirLista(l: listaPacientes);
begin
    while( l <> Nil ) do begin
        writeln('DNI: ' , l^.dato.dni, ' CP: ', l^.dato.cp, ' CIUDAD: ', l^.dato.ciudad);
        l := l^.sig;
    end;
end;

procedure agregarAAB(var a: arbol; d: TPaciente);
var
    nue: arbol;
begin
    if ( a = Nil ) then begin
        new(nue);
        nue^.cp := d.cp;
        nue^.ciudad := d.ciudad;
        nue^.cantInfec := 1;
        nue^.HI := Nil;
        nue^.HD := Nil;
        a := nue;
    end
    else if ( d.cp > a^.cp ) then begin
        agregarAAB(a^.HD, d);
    end
    else if ( d.cp < a^.cp ) then begin
        agregarAAB(a^.HI, d);
    end
    else begin
        a^.cantInfec := a^.cantInfec + 1;
    end;
end;

procedure cargarAAB(var a: arbol; l: listaPacientes);
begin
    while( l <> Nil ) do begin
        agregarAAB(a, l^.dato);
        l := l^.sig;
    end;
end;

procedure imprimirAAB(a: arbol);
begin
    if ( a <> Nil) then begin
        imprimirAAB(a^.HI);
        writeln('CP: ', a^.cp, ' C: ', a^.cantInfec);
        imprimirAAB(a^.HD);
    end;
end;

procedure contarEntre(a: arbol; var out: integer; min: integer; max: integer);
begin
    if ( a <> Nil) then begin
        if ( a^.cp > min ) then begin
            if ( a^.cp < max ) then begin
                out := out + a^.cantInfec;
                contarEntre(a^.HI, out, min, max);
                contarEntre(a^.HD, out, min, max);
            end else begin
                contarEntre(a^.HI, out, min, max);
            end;
        end else begin
            contarEntre(a^.HD, out, min, max);
        end;
    end;
end;

var
    pacientes: listaPacientes;
    l: listaPacientes;
    a: arbol;
    salida: integer;
begin
    crearLista(l);
    imprimirLista(l);
    cargarAAB(a, l);
    imprimirAAB(a);
    salida := 0;
    contarEntre(a, salida, 1800, 1900);
    writeln('infectados e/ 1800 y 1900: ', salida);
end.