program app;

function factorial(num:integer):integer;
  begin
      if num = 0 then
         factorial := 1
      else
          factorial := num * factorial(num - 1)
  end;

{PROGRAMA PRINCIPAL}
var 
  num: integer;
Begin

  writeln( 'Ingrese un entero no negativo:');
  readln (num);

  writeln ( num, '! = ', factorial(num));
  readln;
  readln
End.
