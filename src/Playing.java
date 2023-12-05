public interface Playing {
    public void clicking();
}
interface Checking{
    public void matchEnd();
    public boolean isMatchDraw();
    public boolean isWinner();
    public boolean checkCols();
    public boolean checkRows();
    public boolean checkDiagonal();

}
