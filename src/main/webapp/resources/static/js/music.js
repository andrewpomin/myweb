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

    switcher(song);
}

function switcher(song) {
    if (song.paused) {
        States.songPlaying = song;
        song.play();
        song.classList.toggle("pause");
        song.onended = (event) => {
            song.classList.toggle("pause");
            let next = song.nextSibling;
            console.log(next);
            startElement(next);
        }
    } else {
        States.songPlaying = null;
        song.pause();
        song.classList.toggle("pause");
    }
}

function startElement(element) {
    if (States.songPlaying !== null) {
        States.songPlaying.pause();
        States.songPlaying.classList.toggle("pause");
        States.songPlaying = null;
    }

    switcher(element);
}

function getDuration(id) {
    document.getElementById("info_" + id).innerText = document.getElementById(id).duration;
    console.log(document.getElementById(id).duration);
}