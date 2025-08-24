program app;

Function potencia1(x, n: integer): real;
begin
    if (n = 1) then
        potencia1 := x
    else
        potencia1 := x * potencia1(x, n-1);
end;

begin
    writeln('5^3: ', potencia1(5, 3):2:2);
end.