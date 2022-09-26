function checkRepeat() {
    if (document.getElementById("password").value === document.getElementById("repeatPassword").value) {
        document.getElementById("toolText").innerText = "";
//        document.getElementById("button").disabled = false;
        document.getElementById("button").setAttribute("style", "cursor: pointer");
    } else {
        document.getElementById("toolText").innerText = "Passwords do not match";
//        document.getElementById("button").disabled = true;
        document.getElementById("button").setAttribute("style", "cursor: not-allowed");
    }
}

function toolVisible(id) {
    document.getElementById(id).setAttribute("style", "visibility: visible");
}

function toolHidden(id) {
    document.getElementById(id).setAttribute("style", "visibility: hidden");
}