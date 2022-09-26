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
    Array.from(document.getElementsByClassName("audio")).forEach(
        function(element) {
        let temp = element.duration;
        let min = Math.floor(temp / 60);
        let minutes = String(min);
        let sec = Math.floor(temp % 60);
        let seconds = String(sec);
        let time = minutes + ":" + seconds;
        console.log(element);
        console.log("info_" + element);
        console.log(document.getElementById("info_" + element));
        document.getElementById("info_" + element).innerText = time;
        }
    );
}