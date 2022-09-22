package myprojects.helpers;

public class LowerNames {

    public String rename(String songName) {
        return songName.toLowerCase().replace(' ', '_');
    }
}
