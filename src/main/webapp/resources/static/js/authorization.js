function checkRepeat() {
    if (document.getElementById("password") === document.getElementById("repeatPassword")) {
        document.getElementById("button").disabled = false;
        document.getElementById("button").setAttribute("style", "opacity: 1");
        document.getElementById("button").setAttribute("style", "cursor: auto");
    } else {
        document.getElementById("button").disabled = true;
        document.getElementById("button").setAttribute("style", "opacity: 0.6");
        document.getElementById("button").setAttribute("style", "cursor: not-allowed");
    }
}