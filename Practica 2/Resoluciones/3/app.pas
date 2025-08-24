program app;
Function potencia2 (x,n: integer): real;
  begin
    if (n = 0) then
      potencia2 := 1
    else
      potencia2 := x * potencia2(x,n)
  end;

{PROGRAMA PRINCIPAL}
var
   n, x: integer;

begin

     writeln('base');
     Readln(n);
     Writeln('Ingrese exponente: ');
     Readln(x);
     writeln(potencia2(x,n):0:2);


     readln;
end.