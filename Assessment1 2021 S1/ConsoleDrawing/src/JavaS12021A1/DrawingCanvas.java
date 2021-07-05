package JavaS12021A1;

/**
 * 告诉我这个class是什么
 */
public class DrawingCanvas {
    /**
     * 代表画布的宽度
     */
    private int width;
    private int height;
    // char String
    private String unit;

    /**
     * 这个method是干什么
     * @param args 解释参数
     */
    public DrawingCanvas(String[] args){
        this.width = Integer.parseInt(args[0]);
        this.height = Integer.parseInt(args[1]);
        this.unit = args[2];
    }

    /**
     *
     * @return 解释return
     */
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getUnit() {
        return unit;
    }

    public void printDetail(){
        System.out.println("Current drawing canvas settings:");
        System.out.println("- Width: " + this.width);
        System.out.println("- Height: " + this.height);
        System.out.println("- Background character: " + this.unit);
        System.out.println();
    }

    public void update(){
        System.out.print("Canvas width: ");
        width = Integer.parseInt(ConsoleDrawing.sc.nextLine());
        System.out.print("Canvas height: ");
        height = Integer.parseInt(ConsoleDrawing.sc.nextLine());
        System.out.print("Background character: ");
        unit = ConsoleDrawing.sc.nextLine();
        System.out.println("Drawing canvas has been updated!");
        System.out.println();
    }
}
