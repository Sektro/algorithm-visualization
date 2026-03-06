package model;

public final class Constants {
    private Constants() {}

    // Frame
    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGHT = 500;

    // Panels
    public static final int DIAGRAMPANEL_WIDTH = 500;
    public static final int DIAGRAMPANEL_HEIGHT = 400;
    public static final int BUTTONPANEL_WIDTH = 500;
    public static final int BUTTONPANEL_HEIGHT = 100;

    // Sorter
    public static final int DATA_LENGTH = 10;
    public static final int STANDARD_SHUFFLE_NUMBER = 10;

    // Diagram
    public static final int BLOCK_HEIGHT = (DIAGRAMPANEL_HEIGHT -20) / DATA_LENGTH;
    public static final int BLOCK_WIDTH = (DIAGRAMPANEL_WIDTH -40) / DATA_LENGTH;
    public static final int STARTER_POS_X = 20;
    public static final int STARTER_POS_Y = DIAGRAMPANEL_HEIGHT-10;
}
