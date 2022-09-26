function checkRepeat() {
    if (document.getElementById("password").value === document.getElementById("repeatPassword").value) {
        document.getElementById("button").disabled = false;
        document.getElementById("button").setAttribute("style", "cursor: auto");
        console.log("true");
    } else {
        document.getElementById("button").disabled = true;
        document.getElementById("button").setAttribute("style", "cursor: not-allowed");
        console.log("false");
        console.log(document.getElementById("password").value);
        console.log(document.getElementById("repeatPassword").value);
    }
}