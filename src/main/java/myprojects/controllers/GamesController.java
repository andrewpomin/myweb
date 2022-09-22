package myprojects.controllers;

import lombok.AllArgsConstructor;
import myprojects.games.tictactoe.Figure;
import myprojects.games.tictactoe.TicTacToe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Thread.sleep;

@AllArgsConstructor
@RestController
@RequestMapping("/game")
public class GamesController {

    @PostMapping("/setFigure")
    public void setFigure(HttpServletRequest request, HttpServletResponse response) {
        try {
            String template = request.getParameter("array");
            char[] array = template.toCharArray();
            char type = request.getParameter("type").charAt(0);

            if (TicTacToe.isEnd(array)) {
                response.getWriter().write(TicTacToe.whoIsWinner(array, type));
            } else {
                sleep(1000);
                int random = (int) (Math.random() * 7 + 1);
                int doubleCheck = 0;
                while (array[random] != 'n') {
                    if (random == 8) {
                        random = 0;
                    } else {
                        ++random;
                    }
                    if (doubleCheck > 9) {
                        break;
                    }
                    ++doubleCheck;
                }
                Figure figure = new Figure('O', random);
                TicTacToe.makeMove(figure, array);

                StringBuilder template2 = new StringBuilder();
                for (int i = 0; i < 9; i++) {
                    template2.append(array[i]);
                }
                if (TicTacToe.isEnd(array)) {
                    response.getWriter().write(template2 + "&" + TicTacToe.whoIsWinner(array, type));
                } else {
                    response.getWriter().write(template2.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
