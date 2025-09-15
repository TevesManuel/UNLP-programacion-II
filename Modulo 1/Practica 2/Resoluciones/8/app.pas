program VectorOrdenado;

const
    dimF = 8;  {Dimensi�n f�sica del vector}
type
    vector = array [1..dimF] of integer;
    dim = 0..dimF;

{-----------------------------------------------------------------------------
CARGARVECTORORDENADO - Carga ordenadamente nros aleatorios entre 0 y 100 en el
vector hasta que llegue el nro 99 o hasta que se complete el vector}
Procedure cargarVectorOrdenado ( var vec: vector; var dimL: dim);
var
    d, pos, j: integer;
begin
    Randomize;  { Inicializa la secuencia de random a partir de una semilla}
    dimL := 0;
    d:= random(100);
    while (d <> 99)  and ( dimL < dimF ) do begin
        pos:= 1;
        while (pos <= dimL) and (vec[pos]< d) do pos:= pos + 1;
        for  j:= dimL downto pos do vec[j+1]:= vec[j] ;
        vec[pos]:= d;
        dimL := dimL + 1;
        d:= random(100)
    end;
end;

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

procedure buscarInterno(vec: vector; valor: integer; min: integer; max: integer);
var
    i: integer;
begin
    i := min + (( max - min ) div 2);

    // writeln('min: ', min, ' max: ', max);
    // writeln('i: ', i, ' vec[i]: ', vec[i]);

    if ( vec[i] = valor ) then begin
        writeln('[i] Valor encontrado en ', i);
    end
    else begin
        if ( ( max - min ) <> 0 ) then begin
            if ( valor < vec[i] ) then
                buscarInterno(vec, valor, min, i)
            else
                buscarInterno(vec, valor, i + 1, max);
        end
        else begin
            writeln('[!] El valor no existe en el vector');
        end;
    end;
end;

procedure buscar(vec: vector; valor: integer);
begin
    buscarInterno(vec, valor, 0, dimF);
end;

{PROGRAMA PRINCIPAL}
var
    v: vector;
    dimL : dim;
    input: integer;
begin
    cargarVectorOrdenado(v,dimL);

    writeln('Nros almacenados: ');
    imprimirVector(v, dimL);
    write('Ingresar un valor:');
    readln(input);
    buscar(v, input);
    readln;
end.
