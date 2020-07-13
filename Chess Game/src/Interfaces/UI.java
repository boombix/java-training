package Interfaces;
import Chess.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class UI {
    private static ChessBoard board;

    public UI()
    {
        board = new ChessBoard(InitBoard.INIT_BOARD);
    }

    public static ChessBoard getBoard()
    {
        return board;
    }

    public static void readMove()
    {
        List<Character> columns = Arrays.asList('A','B','C','D','E','F','G','H');
        List<Integer> rows = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int startRow = -1, endRow = -1;
        char startColumn = 'Z', endColumn = 'Z';
        Scanner keyboard = new Scanner(System.in);
        System.out.println("From:");
        while(!rows.contains(startRow))
        {
            System.out.print("     row:");
            startRow = keyboard.nextInt();
            keyboard.nextLine();
        }
        while(!columns.contains(startColumn))
        {
            System.out.print("     column:");
            startColumn = keyboard.nextLine().charAt(0);
        }
        System.out.println("To:");
        while(!rows.contains(endRow))
        {
            System.out.print("     row:");
            endRow = keyboard.nextInt();
            keyboard.nextLine();
        }
        while(!columns.contains(endColumn))
        {
            System.out.print("     column:");
            endColumn = keyboard.nextLine().charAt(0);
        }
        try{
            board.movePiece(8-startRow , startColumn - 'A' , 8-endRow , endColumn - 'A');
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
