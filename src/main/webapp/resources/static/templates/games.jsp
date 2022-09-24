<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*" %>
<%@ page import="myprojects.generators.Games" %>
<%
  Games games = new Games();
  PrintWriter pw = response.getWriter();
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name ="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
  <meta name="MobileOptimized" content="width">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Games</title>
  <link rel="icon" href="../icons/icon-my.png" type="image/png" sizes="64x64">
  <link rel="stylesheet" href="../css/main.css">
  <link rel="stylesheet" type="text/css" media="screen and (max-device-width:720px)" href="../css/main-smart.css">
  <link rel="stylesheet" type="text/css" media="screen" href="../css/games.css">
  <link rel="stylesheet" type="text/css" media="screen and (max-device-width:720px)" href="../css/games-smart.css">
</head>
<body>
  <nav class="top-nav">
    <div class="menu-home">
    <div class="menu-box" onclick="myFunction()">
    <button class="menu" type="button" name="menu">
      <div id="menu-list" class="menu-list">
        <a href="${pageContext.request.contextPath}/music">Music</a>
        <a href="${pageContext.request.contextPath}/movies">Movies</a>
        <a href="${pageContext.request.contextPath}/tvseries">TV Series</a>
        <a href="${pageContext.request.contextPath}/games">Games</a>
        <a href="${pageContext.request.contextPath}/gallery">Gallery</a>
      </div>
    </button>
    <img class="menu" src="../icons/menu.png">
  </div>
  <a class="home-box" href="${pageContext.request.contextPath}/">
    <img class="home" src="../icons/home.png">
  </a>
  </div>
  <div class="account-box" onclick="myFunction2()">
    <button class="account" type="button" name="account">
      <div id="account-list" class="account-list">
        <%--        <a href="saves.HTML">Saves</a>--%>
        <%--        <a href="settings.HTML">Settings</a>--%>
        <a href="${pageContext.request.contextPath}/user/logout">Quit</a>
      </div>
    </button>
    <img class="account" src="../icons/account.png">
  </div>
  </nav>

  <div class="box">
    <div class="zone">
      <div class="line" id="line1">
        <div class="cell" id="cell1" onclick="setFigure(id)"></div>
        <div class="cell" id="cell2" onclick="setFigure(id)"></div>
        <div class="cell" id="cell3" onclick="setFigure(id)"></div>
      </div>
      <div class="line2">
        <div class="line" id="line2">
          <div class="cell" id="cell4" onclick="setFigure(id)"></div>
          <div class="cell" id="cell5" onclick="setFigure(id)"></div>
          <div class="cell" id="cell6" onclick="setFigure(id)"></div>
        </div>
      </div>
      <div class="line" id="line3">
        <div class="cell" id="cell7" onclick="setFigure(id)"></div>
        <div class="cell" id="cell8" onclick="setFigure(id)"></div>
        <div class="cell" id="cell9" onclick="setFigure(id)"></div>
      </div>
      <h1 class="text"></h1>
    </div>
    <button class="b" type="button" name="new-tic-tac" onclick="newTicTac()">New Game</button>
  </div>
</body>
  <script src="../js/main.js" type="text/javascript"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
  <script src="../js/games.js" type="text/javascript"></script>

</html>
