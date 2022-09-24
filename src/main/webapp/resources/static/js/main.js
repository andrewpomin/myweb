/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("menu-list").classList.toggle("show");
}

function myFunction2() {
    document.getElementById("account-list").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.menu-list')) {

    var dropdowns = document.getElementsByClassName("menu-list");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
  if (!event.target.matches('.account')) {

    var dropdowns = document.getElementsByClassName("account-list");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}

function startStop(element) {
  let song = document.getElementById(element);
  let image = document.getElementsByClassName("play");
  if (song.paused) {
    console.log(song);
    // fetch('https://drive.google.com/file/d/1LNfVddaVK8EDz8ZB_9MC2NcGFkvb3SyY/view?usp=sharing', { mode: 'no-cors'});
    song.play();
    document.getElementById("play_" + element).classList.toggle("pause");
  } else {
    console.log(song);
    song.pause();
    document.getElementById("play_" + element).classList.toggle("pause");
  }
}

// function duration() {
//  var audio = document.getElementById(element);
//  var time = Math.floor(audio.duration / 60) + ':' + Math.ceil(audio.duration % 60);
//  console.log(document.getElementById('info-music').innerHTML = time);
// }
