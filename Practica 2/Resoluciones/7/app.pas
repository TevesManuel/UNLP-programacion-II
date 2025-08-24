program app;

var 
  num, maximo: integer;

function digitoMaximo(n: integer): real;
var
  dig: integer;
begin
  if (n = 0) then
    digitoMaximo:= -1
  else
    begin
      dig:= n mod 10;
      if (dig > digitoMaximo(n div 10)) then
        digitoMaximo:= dig
      else
        digitoMaximo:= digitoMaximo(n div 10);
    end;
end;

Begin
  maximo := -1;
  writeln( 'Ingrese un entero no negativo:');
  readln (num);
  digitoMaximo (num, maximo);
  writeln ( 'El digito maximo del numero ', num, ' es: ', maximo);
  readln;
End.

