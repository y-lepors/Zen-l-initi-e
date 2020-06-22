package consoleView.listener;

import consoleView.frame.GameFrame;
import zenGame.GameManager;
import zenGame.Pawn;
import zenGame.Square;
import zenGame.Type;

import javax.security.auth.callback.TextInputCallback;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

/**
 * The gameFrame listener
 */
public class GameFrameListener implements ActionListener, Serializable {

    private GameFrame gameFrame;
    private JButton[][] jButtons;
    private GameManager gameManager;
    private Square[][] grid;

    /**
     * The constructor that initialize every attribute
     * @param gameFrame The gameFrame
     * @param gameManager The gameManager
     * @param grid The grid to display
     */
    public GameFrameListener(GameFrame gameFrame, GameManager gameManager, Square[][] grid){
        this.grid = grid;
        this.gameManager = gameManager;
        this.gameFrame = gameFrame;
        gameFrame.setActionListener(this);
        jButtons = gameFrame.getjButtons();
    }

    /**
     * This method is used to react to the action from the user
     * @param e The captured action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == gameFrame.getSaveButton()){
            String s =  (JOptionPane.showInputDialog("Nommez votre sauvegarde"));
            gameManager.saveGame("./data/saves/"+s+".bin");
            exit(0);
        }

        for(int i = 0 ; i < 11 ; i++){
            for(int j = 0 ; j < 11 ; j++){
                if (e.getSource() == jButtons[i][j]){
                    ArrayList<int[]> possibleMove = whichMove(i, j);
                    for (int[] k : possibleMove) {
                        jButtons[k[0]][k[1]].setBackground(Color.BLUE);
                    }
                }
            }
        }
    }

    /**
     * Verif every possible move and return an ArrayList with every move
     * @param posX The posX
     * @param posY The posY
     * @return An arrayList of every possible move
     */
    public ArrayList<int[]> whichMove(int posX, int posY){
        ArrayList<int[]> ret = new ArrayList<int[]>();
        Type colorPawn = this.grid[posX][posY].getPawn().getType();

        int horizontalMove = this.countPawnHorizontal(posX, posY) + 1;
        int verticalMove = this.countPawnVertical(posX, posY) + 1;
        int diagonalRightMove = this.countPawnRightDiagonal(posX, posY) + 1;
        int diagonalLeftMove = this.countPawnLeftDiagonal(posX, posY) + 1;

        // 8 different possibilities

        // UP
        if(upVerticalIsNotBlocked(posX, posY,verticalMove)){
            int[] coordinate = new int[2];
            coordinate[0] = posX;
            coordinate[1] = posY+verticalMove;
            ret.add(coordinate);
        }

        // UP RIGHT DIAGONAL
        if(upRightIsNotBlocked(posX, posY, diagonalRightMove)){
            int[] coordinate = new int[2];
            coordinate[0] = posX+diagonalRightMove;
            coordinate[1] = posY+diagonalRightMove;
            ret.add(coordinate);
        }

        // UP LEFT DIAGONAL
        if(upLeftIsNotBlocked(posX, posY, diagonalLeftMove)){
            int[] coordinate = new int[2];
            coordinate[0] = posX - diagonalLeftMove;
            coordinate[1] = posY + diagonalLeftMove;
            ret.add(coordinate);
        }

        // LEFT
        if(leftHorizontalIsNotBlocked(posX, posY, horizontalMove)){
            int[] coordinate = new int[2];
            coordinate[0] = posX - horizontalMove;
            coordinate[1] = posY;
            ret.add(coordinate);
        }

        // RIGHT
        if(rightHorizontalIsNotBlocked(posX, posY, horizontalMove)) {
            int[] coordinate = new int[2];
            coordinate[0] = posX + horizontalMove;
            coordinate[1] = posY;
            ret.add(coordinate);
        }
        // DOWN
        if(downVerticalIsNotBlocked(posX, posY,verticalMove)){
            int[] coordinate = new int[2];
            coordinate[0] = posX;
            coordinate[1] = posY-verticalMove;
            ret.add(coordinate);
        }

        // DOWN RIGHT DIAGONAL
        if(downRightIsNotBlocked(posX, posY, diagonalRightMove)){
            int[] coordinate = new int[2];
            coordinate[0] = posX-diagonalRightMove;
            coordinate[1] = posY-diagonalRightMove;
            ret.add(coordinate);
        }
        // DOWN LEFT DIAGONAL
        if(downLeftIsNotBlocked(posX, posY, diagonalLeftMove)){
            int[] coordinate = new int[2];
            coordinate[0] = posX + diagonalLeftMove;
            coordinate[1] = posY - diagonalLeftMove;
            ret.add(coordinate);
        }

        return ret;
    }

    /**
     * Return true if the vertical up is not blocked by a pawn
     * @param posX The x coordinate
     * @param posY The y coordinate
     * @param verticalMove The number of possible move
     * @return true if the move is possible
     */
    public boolean upVerticalIsNotBlocked(int posX, int posY, int verticalMove) {
        boolean ret = false;
        Type otherType = this.otherType(posX, posY);
        if ((posX) < 11 && (posY + verticalMove) < 11) {
            if (this.grid[posX][posY + verticalMove].isFree() || this.grid[posX][posY + verticalMove].getPawn().getType().equals(otherType)) {
                for (int i = 1; i < verticalMove; i++) {
                    if (this.grid[posX][posY + i].isFree()) {
                        ret = true;
                    } else {
                        if (this.grid[posX][posY + i].getPawn().getType().equals(otherType)) {
                            ret = false;
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }

    /**
     * Return true if the vertical down is not blocked by a pawn
     * @param posX The x coordinate
     * @param posY The y coordinate
     * @param verticalMove The number of possible move
     * @return true if the move is possible
     */
    public boolean downVerticalIsNotBlocked(int posX, int posY, int verticalMove){
        boolean ret = false;
        Type otherType = this.otherType(posX, posY);
        if((posX) < 11 && (posY-verticalMove) >= 0 ){
            if(this.grid[posX][posY-verticalMove].isFree() || this.grid[posX][posY-verticalMove].getPawn().getType().equals(otherType)){
                for(int i = 1 ; i < verticalMove ; i++){
                    if (this.grid[posX][posY - i].isFree()) {
                        ret = true;
                    } else {
                        if (this.grid[posX][posY - i].getPawn().getType().equals(otherType)) {
                            ret = false;
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }

    /**
     * Return true if the right up diagonal is not blocked by a pawn
     * @param posX The x coordinate
     * @param posY The y coordinate
     * @param diagonalRightMove The number of possible move
     * @return true if the move is possible
     */
    public boolean upRightIsNotBlocked(int posX, int posY, int diagonalRightMove){
        boolean ret = false;
        Type otherType = this.otherType(posX, posY);
        if((posX+diagonalRightMove) < 11 && (posY+diagonalRightMove) < 11 ){
            if(this.grid[posX+diagonalRightMove][posY+diagonalRightMove].isFree() || this.grid[posX+diagonalRightMove][posY+diagonalRightMove].getPawn().getType().equals(otherType)){
                for(int i = 1 ; i < diagonalRightMove ; i++){
                    if (this.grid[posX+ i][posY + i].isFree()) {
                        ret = true;
                    } else {
                        if (this.grid[posX + i][posY + i].getPawn().getType().equals(otherType)) {
                            ret = false;
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }

    /**
     * Return true if the right down diagonal is not blocked by a pawn
     * @param posX The x coordinate
     * @param posY The y coordinate
     * @param diagonalRightMove The number of possible move
     * @return true if the move is possible
     */
    public boolean downRightIsNotBlocked(int posX, int posY, int diagonalRightMove){
        boolean ret = false;
        Type otherType = this.otherType(posX, posY);
        if((posX-diagonalRightMove) >= 0 && (posY-diagonalRightMove) >= 0 ){
            if(this.grid[posX-diagonalRightMove][posY-diagonalRightMove].isFree() || this.grid[posX-diagonalRightMove][posY-diagonalRightMove].getPawn().getType().equals(otherType)){
                for(int i = 1 ; i < diagonalRightMove ; i++){
                    if (this.grid[posX - i][posY - i].isFree()) {
                        ret = true;
                    } else {
                        if (this.grid[posX - i][posY - i].getPawn().getType().equals(otherType)) {
                            ret = false;
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }

    /**
     * Return true if the right horizontal line is not blocked by a pawn
     * @param posX The x coordinate
     * @param posY The y coordinate
     * @param horizontalMove The number of possible move
     * @return true if the move is possible
     */
    public boolean rightHorizontalIsNotBlocked(int posX, int posY, int horizontalMove){
        boolean ret = false;
        Type otherType = this.otherType(posX, posY);
        if((posX+ horizontalMove) < 11 && (posY) < 11 ){
            if(this.grid[posX+ horizontalMove][posY].isFree() || this.grid[posX+horizontalMove][posY].getPawn().getType().equals(otherType)){
                for(int i = 1 ; i < horizontalMove ; i++){
                    if (this.grid[posX + i][posY].isFree()) {
                        ret = true;
                    } else {
                        if (this.grid[posX+i][posY].getPawn().getType().equals(otherType)) {
                            ret = false;
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }

    /**
     * Return true if the left horizontal line is not blocked by a pawn
     * @param posX The x coordinate
     * @param posY The y coordinate
     * @param horizontalMove The number of possible move
     * @return true if the move is possible
     */
    public boolean leftHorizontalIsNotBlocked(int posX, int posY, int horizontalMove){
        boolean ret = false;
        Type otherType = this.otherType(posX, posY);
        if((posX- horizontalMove) >= 0 && (posY) < 11 ){
            if(this.grid[posX- horizontalMove][posY].isFree() || this.grid[posX-horizontalMove][posY].getPawn().getType().equals(otherType)){
                for(int i = 1 ; i < horizontalMove ; i++){
                    if (this.grid[posX-i][posY].isFree()) {
                        ret = true;
                    } else {
                        if (this.grid[posX-i][posY].getPawn().getType().equals(otherType)) {
                            ret = false;
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }

    /**
     * Return true if the right up left diagonal is not blocked by a pawn
     * @param posX The x coordinate
     * @param posY The y coordinate
     * @param diagonalLeftMove The number of possible move
     * @return true if the move is possible
     */
    public boolean upLeftIsNotBlocked(int posX, int posY, int diagonalLeftMove){
        boolean ret = false;
        Type otherType = this.otherType(posX, posY);
        if((posX-diagonalLeftMove) >= 0 && (posY+diagonalLeftMove) < 11 ){
            if(this.grid[posX-diagonalLeftMove][posY+diagonalLeftMove].isFree() || this.grid[posX-diagonalLeftMove][posY+diagonalLeftMove].getPawn().getType().equals(otherType)){
                for(int i = 1 ; i < diagonalLeftMove ; i++){
                    if (this.grid[posX-i][posY + i].isFree()) {
                        ret = true;
                    } else {
                        if (this.grid[posX-i][posY + i].getPawn().getType().equals(otherType)) {
                            ret = false;
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }

    /**
     * Return true if the left down diagonal is not blocked by a pawn
     * @param posX The x coordinate
     * @param posY The y coordinate
     * @param diagonalLeftMove The number of possible move
     * @return true if the move is possible
     */
    public boolean downLeftIsNotBlocked(int posX, int posY, int diagonalLeftMove){
        boolean ret = false;
        Type otherType = this.otherType(posX, posY);
        if((posX+diagonalLeftMove) < 11 && (posY-diagonalLeftMove) >= 0 ){
            if(this.grid[posX+diagonalLeftMove][posY-diagonalLeftMove].isFree() || this.grid[posX+diagonalLeftMove][posY-diagonalLeftMove].getPawn().getType().equals(otherType)){
                for(int i = 1 ; i < diagonalLeftMove ; i++){
                    if (this.grid[posX+i][posY - i].isFree()) {
                        ret = true;
                    } else {
                        if (this.grid[posX+i][posY - i].getPawn().getType().equals(otherType)) {
                            ret = false;
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }


    /**
     * The averse type
     * @param posX The x coordinate
     * @param posY The y coordinate
     * @return The averse type
     */
    private Type otherType(int posX, int posY){
        Type ret = this.grid[posX][posY].getPawn().getType();
        if(ret.equals(Type.BLACK)){
            ret = Type.WHITE;
        } else if(ret.equals(Type.WHITE)){
            ret = Type.BLACK;
        } else if(ret.equals(Type.ZEN)){
            ret = this.grid[posX][posY].getPawn().getType();
        }

        return ret;
    }

    /**
     * Count the number of pawn from the left to right diagonal
     * @param x The x coordinate
     * @param y The y coordinate
     * @return The number of pawn on this diagonal
     */
    private int countPawnRightDiagonal(int x, int y){
        int ret = -2;

        for(int i = 0 ; i < 11 ; i++){
            if(x+i < 11 && y+i < 11){
                if(!this.grid[x+i][y+i].isFree()){
                    ret++;
                }
            }
            if(x-i >= 0 && y-i >=0){
                if(!this.grid[x-i][y-i].isFree()){
                    ret++;
                }
            }
        }
        return ret;
    }

    /***
     * Count the number of pawn from the right to left diagonal
     * @param x The x coordinate
     * @param y The y coordinate
     * @return The number of pawn on this diagonal
     */
    private int countPawnLeftDiagonal(int x, int y){
        int ret = -2;

        for(int i = 0 ; i < 11 ; i++){
            if(x+i < 11 && y-i >= 0){
                if(!this.grid[x+i][y-i].isFree()){
                    ret++;
                }
            }
            if(x-i >= 0 && y+i < 11){
                if(!this.grid[x-i][y+i].isFree()){
                    ret++;
                }
            }
        }
        return ret;
    }

    /**
     * Count number of pawn in horizontal direction
     * @param x The x coordinate
     * @param y The y coordinate
     * @return The number of pawn on this line
     */
    private int countPawnHorizontal(int x, int y){
        int ret = -2;

        for(int i = 0 ; i < 11 ; i++){
            if(x + i < 11 && y < 11){
                if(!this.grid[x+i][y].isFree()){
                    ret++;
                }
            }
            if(x - i >= 0 && y >= 0){
                if(!this.grid[x-i][y].isFree()){
                    ret++;
                }
            }
        }
        return ret;
    }

    /**
     * Count number of pawn in vertical direction
     * @param x The x coordinate
     * @param y The y coordinate
     * @return The number of pawn on this line
     */
    private int countPawnVertical(int x, int y){
        int ret = -2;

        for(int i = 0 ; i < 11 ; i++){
            if(x < 11 && y + i < 11){
                if(!this.grid[x][y+i].isFree()){
                    ret++;
                }
            }
            if(x >= 0 && y - i >= 0){
                if(!this.grid[x][y-i].isFree()){
                    ret++;
                }
            }
        }
        return ret;
    }
}
