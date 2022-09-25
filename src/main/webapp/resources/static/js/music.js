class States {
    static songPlaying = null;
}

function startStop(element) {
    let song = document.getElementById(element);
    if (States.songPlaying !== null && !States.songPlaying.paused) {
        States.songPlaying.pause();
        let templateId = States.songPlaying.id;
        document.getElementById(templateId).classList.toggle("pause");
    }

    if (song.paused) {
        States.songPlaying = song;
        song.play();
        document.getElementById(element).classList.toggle("pause");
        song.onended = (event) => {
            document.getElementById(element).classList.toggle("pause");
            let next = song.nextSibling;
            console.log(next)
            let id = next.id;
            console.log(id);
            startStop(id);
        }
    } else {
        song.pause();
        document.getElementById(element).classList.toggle("pause");
    }

    // switcher(song);
}

// function switcher(song) {
//     if (song.paused) {
//         States.songPlaying = song;
//         song.play();
//         song.classList.toggle("pause");
//         song.onended = (event) => {
//             song.classList.toggle("pause");
//             let next = song.nextSibling.id;
//             console.log(next);
//             startElement(next);
//         }
//     } else {
//         song.pause();
//         song.classList.toggle("pause");
//     }
// }
//
// function startElement(element) {
//     if (States.songPlaying !== null && !States.songPlaying.paused) {
//         States.songPlaying.pause();
//         States.songPlaying.classList.toggle("pause");
//     }
//
//     switcher(element);
// }

function getDuration(id) {
    document.getElementById("info_" + id).innerText = document.getElementById(id).duration;
    console.log(document.getElementById(id).duration);
}