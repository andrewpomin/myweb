package myprojects.generators;

import myprojects.helpers.AmazonWorker;
import myprojects.helpers.LowerNames;
import software.amazon.awssdk.services.s3.model.*;

import java.util.List;

public class Music {

    public String printMusic() {
        AmazonWorker aw = new AmazonWorker();
        List<S3Object> list = aw.getObjectsList();
        StringBuilder body = new StringBuilder();

        for (int i = 0; i < aw.getListSize(list); i++) {
            S3Object object = list.get(i);
            String key = aw.getObjectKey(object);
            body.append(addSong(key));
        }
        return String.valueOf(body);
    }

    public String printRandomMusic() {
        AmazonWorker aw = new AmazonWorker();
        List<S3Object> list = aw.getObjectsList();
        StringBuilder body = new StringBuilder();

        int size = aw.getListSize(list);
        int [] randomArray = new int[size];

        for (int i = 0; i < size; i++) {
            randomArray[i] = i;
        }

        for (int i = 0; i < size; i++) {
            int random = (int) (Math.random() * (size - 1));
            while (randomArray[random] == -1) {
                if (random == size - 1) {
                    random = 0;
                } else {
                    ++random;
                }
            }
            S3Object object = list.get(random);
            String templateKey = aw.getObjectKey(object);
            StringBuilder key = new StringBuilder();
            for (char c : templateKey.toCharArray()) {
                if (c == '\'') {
                    key.append("__");
                } else {
                    key.append(c);
                }
            }
            body.append(addSong(key.toString()));
            randomArray[random] = -1;
        }
        return String.valueOf(body);
    }

    public String addSong(String key) {
        AmazonWorker aw = new AmazonWorker();
        String songName = key.substring(key.indexOf('/') + 1);
        String author = songName.substring(0, songName.indexOf('-') - 1);
        String name = songName.substring(songName.indexOf('-') + 2, songName.indexOf(".mp3"));
        LowerNames lowerNames = new LowerNames();
        songName = lowerNames.rename(songName).substring(0, songName.indexOf(".mp3"));
        return "<div class=\"music-container\">" +
                "<div class=\"box-music\">" +
                "<button id=\"play_" + songName + "\" class=\"play\" onclick=\"startStop('" + songName + "')\"></button>" +
                "<div class=\"song-name\">" +
                "<p class=\"author\">" + author + "</p>" +
                "<p class=\"song\">" + name + "</p>" +
                "<audio id=\"" + songName + "\"" +
                "src=\"" + aw.getURL(key) + "\"></audio>" +
                "</div>" +
                "<div class=\"info-add\">" +
                "<div class=\"info-music\" id=\"info_" + songName + "\" onload=\"getDuration('" + songName + "')\"></div>" +
                "<button class=\"add\"></button>" +
                "</div>" +
                "</div>" +
                "</div>";
    }
}
