{consigna}
    {Un sitio de estadísticas deportivas mantiene la información de jugadores del fútbol argentino.
    Para ello, se dispone de los datos de los partidos jugados en el año 2022.
    De cada partido se conoce el estadio donde se jugó, los nombres de los 2 equipos que se enfrentaron, 
    la fecha (ej. ‘2022/03/28’) y la información de los jugadores que participaron del encuentro.
    De cada jugador se conoce su nombre y apellido, su DNI, posición (arquero, defensa, mediocampo o 
    delantero) y un puntaje otorgado por un crítico deportivo (1..10). 
    Esta información no tiene ningún orden específico. ​

    Se pide: ​
    a) Crear una nueva estructura que almacene para cada jugador, su DNI, su nombre y apellido, 
       posición, y la fecha junto al puntaje obtenido para cada partido del que participó. 
       Esta estructura debe estar ordenada por DNI, y debe ser eficiente para la búsqueda por dicho criterio. ​
    
    Al finalizar el procesamiento de a), elija las estructuras adecuadas para: ​

    b) Implementar un módulo que informe por pantalla los datos de cada jugador y su puntaje total 
        acumulado entre todos los partidos. El listado debe estar ordenado por DNI de manera descendente.​
    c) Implementar un módulo que retorne la cantidad de jugadores cuyo DNI se encuentre entre 30.000.000 
        y 40.000.000.​
    d) Implementar un módulo que, dado una posición recibida por parámetro, retorne la cantidad de 
        jugadores que hay en el sistema con dicha característica.  ​
    e) Implementar un programa principal que utilice los módulos implementados e informe lo que 
        corresponda.}
Program app; 
Uses
     sysutils;
    
const
    RangoDNI = [30000000..40000000];
    
Type
     str10= string[10];
     jugador = record
              dni: longint;
	          nombreApellido: string;
	          posicion: str10;
              puntaje: integer;
     end;

     lista = ^nodoLista;
     nodoLista = record
               dato: jugador;
               sig: lista;
     end;

     partido= record
               estadio: string;
               equipoLocal: string;
               equipoVisitante: string;
               fecha: str10;
               jugadores: lista;
     end;

     listaPartidos = ^nodoPartido;
     nodoPartido = record
               dato: partido;
               sig: listaPartidos;
     end;

/////////////////////////////////////NEW TYPES///////////////////////////////////////////////////////////

    arbol = ^nodo;
    nodo = record
        dato: jugador;
        HD: arbol;
        HI: arbol
    end;


procedure cargarFecha(var s: str10);
var
  dia, mes: integer;
begin
  dia := random(30)+1;
  mes := random(12)+1;
  if(mes = 2) and (dia > 28)then
	dia := 31;
  if((mes = 4) or (mes = 6) or (mes =9) or (mes = 11)) and (dia = 31)then
	dia := 30;
  s := Concat('2022/',IntToStr(mes),'/',IntToStr(dia));
end;

Procedure agregar(var l: listaPartidos; p: partido);
var
   aux: listaPartidos;
begin
     new(aux);
     aux^.dato := p;
     aux^.sig := l;
     l:= aux;
end;

Procedure agregarJugador(var l: lista; j: jugador);
var
   aux: lista;
begin
     new(aux);
     aux^.dato := j;
     aux^.sig := l;
     l:= aux;
end;

procedure cargarJugadores(var l: lista);
var
   j: jugador;
   cant, i, pos: integer;
begin
     cant := random(10)+22;
     for i:=1 to cant do
     begin
          with(j) do begin
              dni := random(36000000)+20000000;
	      nombreApellido:= Concat('Jugador-', IntToStr(dni));
	      pos:= random(4)+1;
              case pos of
                1: posicion:= 'arquero';
                2: posicion:= 'defensa';
                3: posicion:= 'mediocampo';
                4: posicion:= 'delantero';
              end;
              puntaje:= random(10)+1;
          end;
          agregarJugador(l, j);
     end;
end;

procedure crearLista(var l: listaPartidos);
var
   p: partido;
   cant, i: integer;
begin
     cant := random(10);
     for i:=1 to cant do
     begin
          with(p) do begin
               estadio:= Concat('Estadio-', IntToStr(random (500)+1));
               equipoLocal:= Concat('Equipo-', IntToStr(random (200)+1));
               equipoVisitante:= Concat('Equipo-', IntToStr(random (200)+1));
               cargarFecha(fecha);
               jugadores:= nil;
               cargarJugadores(jugadores);
          end;
          agregar(l, p);
     end;
end;



procedure imprimirJugador(j: jugador);
begin
     with (j) do begin
          writeln('Jugador: ', nombreApellido, ' con dni ',dni, ' en posicion: ', posicion, ' y puntaje: ', puntaje);
     end;
end;

procedure imprimirJugadores(l: lista);
begin
     while (l <> nil) do begin
          imprimirJugador(l^.dato);
          l:= l^.sig;
     end;
end;

procedure imprimir(p: partido);
begin
     with (p) do begin
          writeln('');
          writeln('Partido en el ', estadio, ' entre ',equipoLocal, ' y ', equipoVisitante, ' jugado el: ', fecha, ' por los siguientes jugadores: ');
          imprimirJugadores(jugadores);
     end;
end;

procedure imprimirLista(l: listaPartidos);
begin
     while (l <> nil) do begin
          imprimir(l^.dato);
          l:= l^.sig;
     end;
end;

////////////////////////////////////////NEW MODULES///////////////////////////////////////////////////////
procedure generarArbol(var a:arbol; j: jugador);
    var
    nue:arbol;
    begin
        if a = nil then
        begin
            new(nue);
            nue.dato := j;
            nue.HD := nil;
            nue.HI := nil;
            a := nue
        end
        else if (a.dato.dni < j.dni) then
                generarArbol(a^.HD, j)
            else if (a.dato.dni > j.dni) then
                    generarArbol(a^.HI, j)
                else
                    a.dato.puntaje := a.dato.puntaje + j.puntaje
    end;

procedure recorrerListaJugadores(l:lista; var a:arbol)
    begin
        if l <> nil then
            begin
                generarArbol(a, l.dato);
                recorrerListaJugadores(l^.sig, a)
            end;
    end;

procedure recorrerListaPartidos(l:listaPartidos; var a:arbol);
    begin
        if l <> nil then
            begin
                recorrerListaJugadores(l.dato.jugadores);
                recorrerListaPartidos(l^.sig, a)
            end;
    end;

procedure imprimirArbol(a:arbol);
    begin
        if a<>nil then
            begin
                imprimirArbol(a^.HD);
                imprimirJugador(a.dato);
                imprimirArbol(a^.HI);
            end;
    end;

procedure recorrerArbol(a:arbol; p:str10; var cP:integer ; var c30:integer);
    begin
        if a<>nil then
            begin
                recorrerArbol(a^.HD, p, cP, c30);
                if p = a.dato.posicion then
                    cP := cP + 1;
                if a.dato.dni in RangoDNI then
                    c30 := c30 + 1;
                recorrerArbol(a^.HI, p, cP, c30);
            end;
    end;

procedure cantidad(a: arbol);
    var
        posicion: str10;
        cantPociocion, cantDni: Integer;
    begin
        WriteLn('ingrese la posicion: ');   ReadLn(posicion);
        recorrerArbol(a,posicion, cantPociocion, cantDni);
        WriteLn('la cantidad de jugadores con la pocicion ', posicion, 'es: ', cantPociocion);
        WriteLn('la cantidad de jugadores con un DNI entre 30000000 y 40000000 es: ', cantDni)
    end;

var
   l: listaPartidos;
   a: arbol;
begin
     Randomize;

     l:= nil;
     crearLista(l); {carga automÃ¡tica de la estructura disponible}
     writeln ('Lista generada: ');
     imprimirLista(l);

     {Completar el programa}
     a = nil;
     recorrerListaPartidos(l,a);
     imprimirArbol(a);
     cantidad(a);
     writeln('Fin del programa');
     readln;
end.