/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("menu-list").classList.toggle("show");
}

function myFunction2() {
    document.getElementById("account-list").classList.toggle("show");
}

// Close the dropdown if the user clicks outside it
window.onclick = function(event) {
  if (!event.target.matches('.menu')) {

    let dropdowns = document.getElementsByClassName("menu-list");
    let i;
    for (i = 0; i < dropdowns.length; i++) {
      let openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
  if (!event.target.matches('.account')) {

    let dropdowns2 = document.getElementsByClassName("account-list");
    let j;
    for (j = 0; j < dropdowns2.length; j++) {
      let openDropdown2 = dropdowns2[j];
      if (openDropdown2.classList.contains('show')) {
        openDropdown2.classList.remove('show');
      }
    }
  }
}

function startStop(element) {
  let song = document.getElementById(element);
  if (song.paused) {
    song.play();
    document.getElementById("play_" + element).classList.toggle("pause");
    song.onended = (event) => {
      document.getElementById("play_" + element).classList.toggle("pause");
      document.getElementById("play_" + element.nextSibling).classList.toggle("pause");
      document.getElementById("play_" + element.nextSibling).click();
    }
  } else {
    song.pause();
    document.getElementById("play_" + element).classList.toggle("pause");
  }
}

// function duration() {
//  var audio = document.getElementById(element);
//  var time = Math.floor(audio.duration / 60) + ':' + Math.ceil(audio.duration % 60);
//  console.log(document.getElementById('info-music').innerHTML = time);
// }
