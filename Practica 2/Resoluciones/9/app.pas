program app;

const
    dimF = 8;  {Dimensión física del vector}

type

    vector = array [1..dimF] of LongInt;

    dim = 0..dimF;


{-----------------------------------------------------------------------------
CARGARVECTOR - Carga nros aleatorios entre 0 y 100 en el vector hasta que
llegue el nro 99 o hasta que se complete el vector}
Procedure cargarVector ( var vec: vector; var dimL: dim);
var
   d: integer;
begin
     Randomize;  { Inicializa la secuencia de random a partir de una semilla}
     dimL := 0;
     d:= random(100);
     while (d <> 99)  and ( dimL < dimF ) do begin
           dimL := dimL + 1;
           vec[dimL] := d;
           d:= random(100);
     end;
End;

{-----------------------------------------------------------------------------
IMPRIMIRVECTOR - Imprime todos los nros del vector }
Procedure imprimirVector ( var vec: vector; var dimL: dim );
var
   i: dim;
begin
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     write (' ');
     for i:= 1 to dimL do begin
        if(vec[i] < 9)then
            write ('0');
        write(vec[i], ' | ');
     end;
     writeln;
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     writeln;
End;

/////////////////////////////////////////NEW FUNCTIONS////////////////////////////////////////////////////////////////
function digitoMaximo(dimL: dim; vec: vector; n: integer;var max:integer): integer;
    begin
        if n <= dimL then
            begin
                if vec[n]>max then
                    max:=vec[n];
                digitoMaximo(dimL, vec, n+1, max); 
            end;

    end;

function sumaDigitos(dimL: dim; vec: vector; n: integer; var suma: integer): integer;
    begin
        if n <= dimL then
            begin
                suma:= suma + vec[n];
                sumaDigitos(dimL, vec, n+1, suma);
            end;

    end;

{PROGRAMA PRINCIPAL}
var
   v: vector;
   dimL : dim;
   maximo, num: integer;

begin

     cargarVector(v,dimL);

     writeln('Nros almacenados: ');
     imprimirVector(v, dimL);
     digitoMaximo(dimL, v, 1, maximo);
     sumaDigitos(dimL, v, 1, num);
     WriteLn('El numero maximo es: ', maximo);
     WriteLn('La suma de los digitos es: ', num);
     readln;
end.