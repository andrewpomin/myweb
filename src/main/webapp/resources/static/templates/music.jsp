<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*" %>
<%@ page import="myprojects.generators.Music" %>
<%
  Music music = new Music();
  PrintWriter pw = response.getWriter();
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name ="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
  <meta name="MobileOptimized" content="width">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Music</title>
  <link rel="icon" href="../icons/icon-my.png" type="image/png" sizes="64x64">
  <link rel="stylesheet" type="text/css" href="../css/main.css">
  <link rel="stylesheet" type="text/css" media="screen and (max-device-width:720px)" href="../css/main-smart.css">
  <link rel="stylesheet" type="text/css" media="screen" href="../css/music.css">
  <link rel="stylesheet" type="text/css" media="screen and (max-device-width:720px)" href="../css/music-smart.css">
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

  <%
    if (request.getParameter("sort") == null) {
      pw.write(music.printMusic());
    } else if (request.getParameter("sort").equals("random")) {
      pw.write(music.printRandomMusic());
    } else {
      pw.write(music.printMusic());
    }
  %>

<script src="../js/main.js"></script>
</body>
</html>
