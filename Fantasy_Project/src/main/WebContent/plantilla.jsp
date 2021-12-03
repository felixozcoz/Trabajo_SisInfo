<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import= "model.JugadorVO" %>
<%@ page import= "model.PlantillaVO" %>
<%@ page import= "java.util.Vector" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mi plantilla</title>
    <link rel="stylesheet" type="text/css" href="assets/dist/css/plantillaStyle.css" />
</head>
<body>
    <div id="container">
        <div id="myLineupContainer">
            <h2>Mi plantilla</h2>
            <div id="field">
                <div id="myLineup">
                	<% Vector<PlantillaVO> team = (Vector<PlantillaVO>) session.getAttribute("myteam"); %>
                    <div id="player1" class="player">1
                        	<img class="player-img" id="player-img1" src="<%=team.get(0).getCamiseta()%>" id="imagen-player1" />
                        	<div class="player-info" id="info-player1"><%=team.get(1).getNombre()%></div>
                    </div>
                    <div id="player2" class="player">2
                        <img class="player-img" id="player-img2" src="<%=team.get(1).getCamiseta()%>">
                        <div class="player-info" id="info-player2"><%=team.get(1).getNombre()%></div>
                    </div>
                    <div id="player3" class="player">3
                        <img class="player-img" id="player-img3" src="<%=team.get(2).getCamiseta()%>">
                        <div class="player-info" id="info-player3"><%=team.get(2).getNombre()%></div>
                    </div>
                    <div id="player4" class="player">4
                        <img class="player-img" id="player-img4" src="<%=team.get(3).getCamiseta()%>">
                        <div class="player-info" id="info-player4"><%=team.get(3).getNombre()%></div>
                    </div>
                    <div id="player5" class="player">5
                        <img class="player-img" id="player-img5" src="<%=team.get(4).getCamiseta()%>">
                        <div class="player-info" id="info-player5"><%=team.get(4).getNombre()%></div>
                    </div>
                    <div id="player6" class="player">6
                        <img class="player-img" id="player-img6" src="<%=team.get(5).getCamiseta()%>">
                        <div class="player-info" id="info-player6"><%=team.get(5).getNombre()%></div>
                    </div>
                    <div id="player7" class="player">7
                        <img class="player-img" id="player-img7" src="<%=team.get(6).getCamiseta()%>">
                        <div class="player-info" id="info-player7"><%=team.get(6).getNombre()%></div>
                    </div>
                    <div id="player8" class="player">8
                        <img class="player-img" id="player-img8" src="<%=team.get(7).getCamiseta()%>">
                        <div class="player-info" id="info-player8"><%=team.get(7).getNombre()%></div>
                    </div>
                    <div id="player9" class="player">9
                        <img class="player-img" id="player-img9" src="<%=team.get(8).getCamiseta()%>">
                        <div class="player-info" id="info-player9"><%=team.get(8).getNombre()%></div>
                    </div>
                    <div id="player10" class="player">10
                        <img class="player-img" id="player-img10" src="<%=team.get(9).getCamiseta()%>">
                        <div class="player-info" id="info-player10" value=""><%=team.get(9).getNombre()%></div>
                    </div>
                </div>
            </div>  
        </div>
        <div id="myLineupStats">
            <div class="myLineupInfo">
                <div class="myLineupInfoHeader">
                    <p>Puntos generados</p>
                </div>
                <div class="myLineupInfoContent">
                    <p>173 pts</p>
                </div>
            </div>
            <div class="myLineupInfo">
                <div class="myLineupInfoHeader">
                    <p>Precio de mi equipo</p>
                </div>
                <div class="myLineupInfoContent">
                    <p>27.5M $</p>
                </div>
            </div>
            <div class="myLineupInfo">
                <div class="myLineupInfoHeader">
                    <p>Mi mejor jugador</p>
                </div>
                <div class="myLineupInfoContent">
                    <p>27.5M $</p>
                </div>
            </div>
        </div>
    </div>  
  	<div id="overlayChangePlayers">
        <div id="modalChangePlayers">
            <div id="modalChangePlayersHeader">
                <h3>Choose your player</h3>
                <input id="playerFilter" type="text" inputmode="search" placeholder="Search...">
            </div>
            <div id="modalChangePlayersBody">
                <div id="modalChangePlayersBodyMyPlayer" class="modalChangePlayersBodyPlayer">
                    <div class="modalChangePlayersBodyMyPlayerDiv1">
                        <img class="teamLogo" id="teamLogo1" src="">
                        <p class="playerPosition" id="playerPosition1"></p>
                    </div>
                    <img class="playerImg" id="playerImg1" src="">
                    <div class="modalChangePlayersBodyMyPlayerDiv2">
                        <p class="playerName" id="playerName1"></p>
                        <p class="playerPrice">Precio: </p>
                        <p class="playerPoints">Puntos: </p>
                    </div>
                </div>
                <div class="modalChangePlayersBodyPlayer">
                    <div class="modalChangePlayersBodyMyPlayerDiv1">
                        <img class="teamLogo" src="https://cdn.biwenger.com/i/t/207.png">
                        <p class="playerPosition">F</p>
                    </div>
                    <img class="playerImg" src="https://cdn.biwenger.com/i/j/185.png">
                    <div class="modalChangePlayersBodyMyPlayerDiv2">
                        <p class="playerName">Nombre: Stephen Curry</p>
                        <p class="playerPrice">Precio: </p>
                        <p class="playerPoints">Puntos: </p>
                    </div>
                </div>
                <div class="modalChangePlayersBodyPlayer">

                </div>
                <div class="modalChangePlayersBodyPlayer">
                </div>
            </div>
        </div>
    </div>
    <div id="backgroundOverlay"></div>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="assets/dist/js/plantilla.js"></script>
</body>
</html>