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

function sleep(milliseconds) {
  const date = Date.now();
  let currentDate = null;
  do {
    currentDate = Date.now();
  } while (currentDate - date < milliseconds);
}

function getDuration() {
    sleep(3000);
    Array.from(document.getElementsByClassName("audio")).forEach(
        function(element) {
        let id = element.id;
        let temp = element.duration;
        let min = String(Math.floor(temp / 60));
        let sec = String(Math.floor(temp % 60));
        let time = min + ":" + sec;
        document.getElementById("info_" + id).innerText = time;
        }
    );
}