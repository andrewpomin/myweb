package myprojects.generators;

public class Body {
    public String getNavigation() {
        return "<nav class=\"top-nav\">" +
                "<div class=\"menu-home\">" +
                "<div class=\"menu-box\" onclick=\"myFunction()\"> " +
                "<button class=\"menu\" type=\"button\" name=\"menu\"> " +
                "<div id=\"menu-list\" class=\"menu-list\"> " +
                "<a href=\"/music\">Music</a> " +
                "<a href=\"/movies\">Movies</a> " +
                "<a href=\"/tvseries\">TV Series</a> " +
                "<a href=\"/games\">Games</a> " +
                "<a href=\"/gallery\">Gallery</a> " +
                "</div> " +
                "</button> " +
                "<img class=\"menu\" src=\"../icons/menu.png\"> " +
                "</div> " +
                "<a class=\"home-box\" href=\"/\"> " +
                "<img class=\"home\" src=\"../icons/home.png\"> " +
                "</a> " +
                "</div> " +
                "<div class=\"account-box\" onclick=\"myFunction2()\"> " +
                "<button class=\"account\" type=\"button\" name=\"account\"> " +
                "<div id=\"account-list\" class=\"account-list\"> " +
                "<a href=\"/user/logout\">Quit</a> " +
                "</div> " +
                "</button> " +
                "<img class=\"account\" src=\"../icons/account.png\"> " +
                "</div> " +
                "</nav>";
    }
}
