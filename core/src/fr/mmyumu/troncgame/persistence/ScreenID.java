package fr.mmyumu.troncgame.persistence;

public enum ScreenID {
    OVERWORLD, FIGHT, MAIN_MENU;

    public static ScreenID getScreenID(int ordinal) {
        for (ScreenID screenID : ScreenID.values()) {
            if (screenID.ordinal() == ordinal) {
                return screenID;
            }
        }

        return null;
    }
}
