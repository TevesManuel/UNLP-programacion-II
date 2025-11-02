programa ejemplo
procesos
  proceso nivelador(E ID:numero)
  variables
    ACK: boolean
  comenzar
    si (ID = 1)
      EnviarMensaje(V,bot2)
      EnviarMensaje(V,bot3)
      RecibirMensaje(ACK,bot2)
      RecibirMensaje(ACK,bot3)
    
    si (ID = 2)
      EnviarMensaje(V,bot1)
      EnviarMensaje(V,bot3)
      RecibirMensaje(ACK,bot1)
      RecibirMensaje(ACK,bot3)
      
    si (ID = 3)
      EnviarMensaje(V,bot1)
      EnviarMensaje(V,bot2)
      RecibirMensaje(ACK,bot1)
      RecibirMensaje(ACK,bot2)
  fin
  proceso limpiarEsquina
  comenzar
    mientras HayPapelEnLaEsquina
      tomarPapel
  fin
  proceso etapa(E cant:numero)
  comenzar
    repetir cant
      limpiarEsquina
      mover
  fin
areas
  HQ: AreaP (100,100,100,100)
  area1: AreaP(1,1,1,100)
  area2: AreaP(2,1,2,100)
  area3: AreaP(3,1,3,100)
robots
  robot robot1
  variables
    ID:numero
  comenzar
    RecibirMensaje(ID,admin)
    mientras(PosCa <= 95)
      etapa(5)
      nivelador(ID)
    etapa(4)
    limpiarEsquina
  fin
  robot coordinador
  comenzar
    EnviarMensaje(1,bot1)
    EnviarMensaje(2,bot2)
    EnviarMensaje(3,bot3)
  fin
variables
  bot1: robot1
  bot2: robot1
  bot3: robot1
  admin:coordinador
comenzar
  AsignarArea(bot1, area1)
  AsignarArea(bot2, area2)
  AsignarArea(bot3, area3)
  AsignarArea(admin, HQ)
  Iniciar(bot1, 1,1)
  Iniciar(bot2, 2,1)
  Iniciar(bot3, 3,1)
  Iniciar(admin, 100,100)
fin