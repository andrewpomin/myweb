function checkRepeat() {
    if (document.getElementById("password").value === document.getElementById("repeatPassword").value) {
        document.getElementById("wrong").innerText = "";
        document.getElementById("wrong").hidden = true;
        document.getElementById("button").disabled = false;
        document.getElementById("button").setAttribute("style", "cursor: pointer");
    } else {
        document.getElementById("wrong").innerText = "*Passwords do not match";
        document.getElementById("wrong").hidden = false;
        document.getElementById("button").disabled = true;
        document.getElementById("button").setAttribute("style", "cursor: not-allowed");
    }
}