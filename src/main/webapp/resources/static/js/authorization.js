function checkRepeat() {
    if (document.getElementById("password") === document.getElementById("repeatPassword")) {
        document.getElementById("button").disabled = false;
        document.getElementById("button").pointer-events = auto;
        document.getElementById("button").opacity = 1;
        document.getElementById("button").cursor = auto;
    } else {
        document.getElementById("button").disabled = true;
        document.getElementById("button").pointer-events = none;
        document.getElementById("button").opacity = 0.6;
        document.getElementById("button").cursor = not-allowed;
    }
}