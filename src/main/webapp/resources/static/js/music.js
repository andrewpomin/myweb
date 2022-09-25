class States {
    static songPlaying = null;
}

function startStop(element) {
    let song = document.getElementById(element);
    if (States.songPlaying !== null && !States.songPlaying.paused) {
        States.songPlaying.pause();
        let templateId = "play_" + States.songPlaying.id;
        document.getElementById(templateId).classList.toggle("pause");
    } else {

        // if (song.paused) {
        States.songPlaying = song;
        song.play();
        document.getElementById("play_" + element).classList.toggle("pause");
        song.onended = (event) => {
            document.getElementById("play_" + element).classList.toggle("pause");
            let nextContainer = document.getElementById("play_" + element).parentElement.parentElement.nextSibling;
            console.log(nextContainer);
            let next = nextContainer.firstChild.firstChild;
            console.log(next);
            let id = next.id;
            console.log(id);
            startStop(id);
        }
    }
    // } else {
    //     song.pause();
    //     document.getElementById("play_" + element).classList.toggle("pause");
    // }

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
    console.log("into");
    document.getElementById("info_" + id).innerText = document.getElementById(id).duration;
    console.log(document.getElementById(id).duration);
}