function checkRepeat() {
    if (document.getElementById("wrong").innerText !== "*User already exists") {
        if (document.getElementById("password").value === document.getElementById("repeatPassword").value) {
            document.getElementById("wrong").innerText = "";
            document.getElementById("wrong").hidden = true;
            document.getElementById("button").disabled = false;
            document.getElementById("button").setAttribute("style", "cursor: pointer");
        } else {
            document.getElementById("wrong").innerText = "*Passwords do not match";
            document.getElementById("button").setAttribute("style", "cursor: not-allowed");
        }
    } else {
    document.getElementById("button").setAttribute("style", "cursor: pointer");
    }
}

function check() {
    if (document.getElementById("password").value === document.getElementById("repeatPassword").value) {
        document.getElementById("button").click();
    } else {
    document.getElementById("wrong").innerText = "*Passwords don't match";
            document.getElementById("wrong").hidden = false;
            document.getElementById("button").disabled = true;
            document.getElementById("button").setAttribute("style", "cursor: not-allowed");
    }
}