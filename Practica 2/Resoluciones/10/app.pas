Program listas;
Type
    Lista= ^Nodo;
    Nodo= Record
        Datos: integer;
        Sig: Lista;
    End;
Var
    L: Lista;
    n: integer;

Procedure AgregarAdelante (var L:lista; num:integer);
Var
    nue:Lista;
Begin
    New(nue);
    nue^.datos:=num;
    nue^.sig:=L;
    L:=nue;
End;

{ Implementacion deprecada }
// Procedure Imprimir (pri:lista);
// Begin
//     while (pri <> NIL) do begin
//         write (pri^.datos, ' ');
//         pri:= pri^.sig
//     end;
//     writeln;
// end;

Procedure Imprimir (l: lista);
Begin
    if ( l <> Nil ) then begin
        write (l^.datos, ' ');
        Imprimir(l^.sig);
    end
    else begin
        writeln;
    end;
end;

procedure minimoR(l: lista; var actMin: integer);
begin
    if ( l <> Nil) then begin
        if( l^.datos < actMin ) then begin
            actMin := l^.datos;
        end;
        minimoR(l^.sig, actMin);
    end;
end;
function minimo(l: lista): integer;
var
    salida: integer;
begin
    salida := 9999;
    minimoR(l, salida);
    minimo := salida;
end;

begin
    L:=nil;
    randomize;
    n := random (100);
    While (n<>0) do Begin
        AgregarAdelante (L, n);
        n := random (100);
    End;
    writeln ('Lista generada: ');
    imprimir (L);
    writeln(' El valor minimo es ', minimo(l));
    readln
end.
