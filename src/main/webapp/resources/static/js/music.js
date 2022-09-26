class States {
    static songPlaying = null;
}

function startStop(element) {
    let song = document.getElementById(element);

    if (States.songPlaying !== null && !States.songPlaying.paused && States.songPlaying !== song) {
        States.songPlaying.pause();
        let templateId = "play_" + States.songPlaying.id;
        document.getElementById(templateId).classList.toggle("pause");
    }

    if (song.paused) {
        States.songPlaying = song;
        song.play();
        document.getElementById("play_" + element).classList.toggle("pause");
        song.onended = (event) => {
            States.songPlaying = null;
            document.getElementById("play_" + element).classList.toggle("pause");
            let nextContainer = document.getElementById("play_" + element).parentElement.parentElement.nextSibling;
            let next = nextContainer.firstChild.firstChild;
            let id = next.id.substring(5);
            startStop(id);
        }

    } else {
        song.pause();
        document.getElementById("play_" + element).classList.toggle("pause");
    }
}

function getDuration() {
for (element in document.getElementsByClassName("audio")) {
    let element = class.duration;
    document.getElementById("info_" + element).textContent = Math.floor(temp / 60).toString() + ":" + Math.floor(temp % 60).toString();

}
  }