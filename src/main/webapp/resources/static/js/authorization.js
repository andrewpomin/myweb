function checkRepeat() {
console.log(document.getElementById("wrong").value);
    if (document.getElementById("wrong").value !== "*User already exists") {
        if (document.getElementById("password").value === document.getElementById("repeatPassword").value) {
            document.getElementById("wrong").innerText = "";
            document.getElementById("wrong").hidden = true;
            document.getElementById("button").disabled = false;
            document.getElementById("button").setAttribute("style", "cursor: pointer");
        } else {
            document.getElementById("wrong").innerText = "*Passwords do not match";
            document.getElementById("button").setAttribute("style", "cursor: not-allowed");
        }
    }
}

button.onclick = function() {
    if (document.getElementById("password").value === document.getElementById("repeatPassword").value) {
        document.getElementById("button").click();
    } else {
    document.getElementById("wrong").innerText = "*Passwords do not match";
            document.getElementById("wrong").hidden = false;
            document.getElementById("button").disabled = true;
            document.getElementById("button").setAttribute("style", "cursor: not-allowed");
    }
}