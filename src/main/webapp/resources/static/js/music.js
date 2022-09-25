class States {
    static songPlaying = null;
}

function startStop(element) {
    let song = document.getElementById(element);
    if (States.songPlaying !== null) {
        States.songPlaying.pause();
        States.songPlaying.classList.toggle("pause");
        States.songPlaying = null;
    }

    if (song.paused) {
        States.songPlaying = song;
        song.play();
        document.getElementById("play_" + element).classList.toggle("pause");
        song.onended = (event) => {
            document.getElementById("play_" + element).classList.toggle("pause");
            let next = document.getElementById("play_" + element.nextSibling);
            startStop(next);
        }
    } else {
        States.songPlaying = null;
        song.pause();
        document.getElementById("play_" + element).classList.toggle("pause");
    }
}

function getDuration(id) {
    document.getElementById("info_" + id).innerText = document.getElementById("play_" + id).duration;
}