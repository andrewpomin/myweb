<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name ="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
  <meta name="MobileOptimized" content="width">
  <meta http-equiv="X-UA-Compatible" content="text/html;charset=UTF-8"/>
  <title>Home</title>
  <link rel="icon" href="../icons/icon-my.png" type="image/png" sizes="64x64">
  <link rel="stylesheet" type="text/css" href="../css/main.css"/>
  <link rel="stylesheet" type="text/css" media="screen and (max-device-width:720px)" href="../css/main-smart.css">
  <link rel="stylesheet" type="text/css" href="../css/home.css"/>
  <link rel="stylesheet" type="text/css" media="screen and (max-device-width:720px)" href="../css/home-smart.css">
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

  <div class="outer-container">
    <div class="flex-container">
      <img class="i-want" src="../icons/want.png" alt="I want">
  <%--    <div class="groups">--%>
  <%--      <input class="search-line" name="search-main" type="search" tabindex="0">--%>
  <%--      <button id="button" type="button">Go</button>--%>
  <%--    </div>--%>
      <div class="groups">
        <button class="b2" type="button" name="random-music">
          <a class="a-b2" href="${pageContext.request.contextPath}/music?sort=random">Random Music</a></button>
        <button class="b2" type="button" name="random-game">
          <a class="a-b2" href="${pageContext.request.contextPath}/games?random">Random Game</a></button>
      </div>
    </div>
  </div>

  <script src="../js/main.js"></script>
</body>
</html>
