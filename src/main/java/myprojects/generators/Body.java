package myprojects.generators;

public class Body {
    public String getNavigation() {
        return "<nav class=\"top-nav\">" +
                "<div class=\"menu-home\">" +
                "<div class=\"menu-box\" onclick=\"myFunction()\"> " +
                "<button class=\"menu\" type=\"button\" name=\"menu\"> " +
                "<div id=\"menu-list\" class=\"menu-list\"> " +
                "<a href=\"${pageContext.request.contextPath}/music\">Music</a> " +
                "<a href=\"${pageContext.request.contextPath}/movies\">Movies</a> " +
                "<a href=\"${pageContext.request.contextPath}/tvseries\">TV Series</a> " +
                "<a href=\"${pageContext.request.contextPath}/games\">Games</a> " +
                "<a href=\"${pageContext.request.contextPath}/gallery\">Gallery</a> " +
                "</div> " +
                "</button> " +
                "<img class=\"menu\" src=\"../icons/menu.png\"> " +
                "</div> " +
                "<a class=\"home-box\" href=\"${pageContext.request.contextPath}/\"> " +
                "<img class=\"home\" src=\"../icons/home.png\"> " +
                "</a> " +
                "</div> " +
                "<div class=\"account-box\" onclick=\"myFunction2()\"> " +
                "<button class=\"account\" type=\"button\" name=\"account\"> " +
                "<div id=\"account-list\" class=\"account-list\"> " +
                "<a href=\"${pageContext.request.contextPath}/user/logout\">Quit</a> " +
                "</div> " +
                "</button> " +
                "<img class=\"account\" src=\"../icons/account.png\"> " +
                "</div> " +
                "</nav>";
    }
}
