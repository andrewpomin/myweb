class TicTacToe {
  static num = []; //Array for check used and unused cells
  static field = ['n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n']; //Game field
  static yourTurn = true;
}

function setFigure(id) {
  let pos = TicTacToe.num.indexOf(id) //Position of chosen cell in "num" array

  //If cell wasn't chosen - write figure
  if (pos === -1 && TicTacToe.yourTurn) {
    TicTacToe.yourTurn = false
    document.getElementById(id).classList.toggle("X"); //Write figure
    TicTacToe.num.push(id); //Add figure in "num" array - used cells

    let figure = 'X'; //Which figure chosen
    let index = id.substring(4) - 1; //Index of chosen cell

    TicTacToe.field[index] = figure; //add figure in "field" array
    let answer = ""; //Create string for answer to server
    for (let i = 0; i < 9; i++) {
      answer += TicTacToe.field[i]; //Fill answer
    }

    $.ajax({
      url: "game/setFigure?array=" + answer + "&type=" + figure,
      method: "post",
      error: function() {
        alert("Houston, we have a problem - reload the page.");
      },
      success: onload = function(data) {
        TicTacToe.yourTurn = true;
        let responseString = data; //Get answer in string

        //If game is end
        if (responseString.endsWith("!")) {
          if (responseString.charAt(9) === '&') {
            for (let i = 0; i < 9; i++) {
              TicTacToe.field[i] = responseString.substring(i, i + 1); //Get answer and write it to array "field"
              if (TicTacToe.field[i] !== 'n') {
                let j = i + 1; //Number of cell = index + 1
                let cell = "cell" + j; //Name of cell
                let pos2 = TicTacToe.num.indexOf(cell); //Is cell is written already
                //If unwritten - add on field
                if (pos2 === -1) {
                  document.getElementById(cell).classList.toggle(TicTacToe.field[i]); //Write figure
                  TicTacToe.num.push(cell); //Add in "num" array
                }
              }
            }
            document.getElementById("text").innerText = responseString.substring(10);

          } else {
            document.getElementById("text").innerText = responseString;

          }
          document.getElementById("end-text").setAttribute("style", "bottom: 50%");
          document.getElementById("text").hidden = false;

          //If game is continue
        } else {
          for (let i = 0; i < 9; i++) {
            TicTacToe.field[i] = responseString.substring(i, i + 1); //Get answer and write it to array "field"
          }

          //Write unwritten figure
          for (let i = 0; i < 9; i++) {
            if (TicTacToe.field[i] !== 'n') {
              let j = i + 1; //Number of cell = index + 1
              let cell = "cell" + j; //Name of cell
              let pos2 = TicTacToe.num.indexOf(cell); //Is cell is written already
              //If unwritten - add on field
              if (pos2 === -1) {
                document.getElementById(cell).classList.toggle(TicTacToe.field[i]); //Write figure
                TicTacToe.num.push(cell); //Add in "num" array
              }
            }
          }
        }
      }
    });

  }
}

function newTicTac() {
  //Clear static content
  TicTacToe.num = [];
  TicTacToe.field = ['n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n'];
  TicTacToe.yourTurn = true;

  for (let i = 0; i < 9; i++) {
    let cell = "cell" + (i + 1);
    document.getElementById(cell).className = "cell";
    document.getElementById("text").hidden = true;
    document.getElementById("end-text").setAttribute("style", "bottom: 0");
  }
}
