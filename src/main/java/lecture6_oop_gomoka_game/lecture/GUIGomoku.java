package lecture6_oop_gomoka_game.lecture;


import lecture6_oop_gomoka_game.lecture.conteiner.DataSet;
import lecture6_oop_gomoka_game.lecture.impl.DefaultComputerTurn;
import lecture6_oop_gomoka_game.lecture.impl.DefaultGameTable;
import lecture6_oop_gomoka_game.lecture.impl.DefaultHumanTurn;
import lecture6_oop_gomoka_game.lecture.impl.DefaultWinnerChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIGomoku extends JFrame {
    private final JLabel cells[][];
    private final GameTable gameTable;
    private final HumanTurn humanTurn;
    private final ComputerTurn computerTurn;
    private final WinnerChecker winnerChecker;
    private boolean isHumanFirstTurn;

    public GUIGomoku() throws HeadlessException {
        super("Gomoku");
        //config section
        gameTable = new DefaultGameTable();
        humanTurn = new DefaultHumanTurn();
        computerTurn = new DefaultComputerTurn();
        winnerChecker = new DefaultWinnerChecker();
        //end config section
        initGameComponents();
        cells = new JLabel[gameTable.getSize()][gameTable.getSize()];
        isHumanFirstTurn = true;
        createGameUITable();
    }

    protected void initGameComponents(){
        humanTurn.setGameTable(gameTable);
        computerTurn.setGameTable(gameTable);
        winnerChecker.setGameTable(gameTable);
    }

    protected void drawCellValue(Cell cell) {
        CellValue cellValue = gameTable.getValue(cell.getRowIndex(), cell.getColIndex());
        cells[cell.getRowIndex()][cell.getColIndex()].setText(cellValue.getValue());
        if(cellValue == CellValue.COMPUTER) {
            cells[cell.getRowIndex()][cell.getColIndex()].setForeground(Color.RED);
        } else  {
            //human
            cells[cell.getRowIndex()][cell.getColIndex()].setForeground(Color.BLUE);
        }

    }

    protected void markWinnerCells(DataSet<Cell> winnerCells) {
        for (int i = 0; i < winnerCells.size(); i++) {
            Cell cell = winnerCells.get(i);
            cells[cell.getRowIndex()][cell.getColIndex()].setForeground(Color.CYAN);
            cells[cell.getRowIndex()][cell.getColIndex()].setFont(new Font(Font.SERIF, Font.BOLD, 35));
        }
    }

    protected void createGameUITable() {
        setLayout(new GridLayout(gameTable.getSize(), gameTable.getSize()));
        for (int i = 0; i < gameTable.getSize(); i++) {
            for (int j = 0; j < gameTable.getSize(); j++) {
                final int row = i;
                final int col = j;
                cells[i][j] = new JLabel();
                cells[i][j].setPreferredSize(new Dimension(45, 45));
                cells[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                cells[i][j].setVerticalAlignment(SwingConstants.CENTER);
                cells[i][j].setFont(new Font(Font.SERIF, Font.PLAIN, 35));
                cells[i][j].setForeground(Color.BLACK);
                cells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(cells[i][j]);
                cells[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        handleHumanTurn(row, col);
                    }
                });
            }
        }
    }

    protected void startNewGame() {
        isHumanFirstTurn = !isHumanFirstTurn;
        gameTable.reInit();
        for (int i = 0; i < gameTable.getSize(); i++) {
            for (int j = 0; j < gameTable.getSize(); j++) {
                cells[i][j].setText(gameTable.getValue(i, j).getValue());
                cells[i][j].setFont(new Font(Font.SERIF, Font.PLAIN, 35));
                cells[i][j].setForeground(Color.BLACK);
            }
        }
        if (!isHumanFirstTurn) {
            Cell compCell = computerTurn.makeFirstTurn();
            drawCellValue(compCell);
        }
    }

    protected void stopGame() {
        for (int i = 0; i < gameTable.getSize(); i++) {
            for (int j = 0; j < gameTable.getSize(); j++) {
                cells[i][j].removeMouseListener(cells[i][j].getMouseListeners()[0]);
            }
        }
    }

    protected void handleGameOver(String message) {
        if (JOptionPane.showConfirmDialog(this, message) == JOptionPane.YES_OPTION) {
            startNewGame();
        } else {
            stopGame();
        }
    }

    protected void handleHumanTurn(int row, int col) {
        if (gameTable.isCellFree(row, col)) {
            Cell humanCell = humanTurn.makeTurn(row, col);
            drawCellValue(humanCell);
            WinnerResult winnerResult = winnerChecker.isWinnerFound(CellValue.HUMAN);
            if (winnerResult.winnerExists()) {
                markWinnerCells(winnerResult.getWinnerCells());
                handleGameOver("Game over: User win!\nNew game?");
                return;
            }
            if (!gameTable.emptyCellExists()) {
                handleGameOver("Game over: Draw!\nNew game?");
                return;
            }
            Cell compCell = computerTurn.makeTurn();
            drawCellValue(compCell);
            winnerResult = winnerChecker.isWinnerFound(CellValue.COMPUTER);
            if (winnerResult.winnerExists()) {
                markWinnerCells(winnerResult.getWinnerCells());
                handleGameOver("Game over: Computer wins!\nNew game?");
                return;
            }
            if (!gameTable.emptyCellExists()) {
                handleGameOver("Game over: Draw!\nNew game?");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Cell is not free! Click on free cell!");
        }
    }

    public static void main(String[] args) {
        GUIGomoku w = new GUIGomoku();
        w.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        w.setResizable(false);
        w.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        w.setLocation(dim.width / 2 - w.getSize().width / 2, dim.height / 2 - w.getSize().height / 2);
        w.setVisible(true);
    }
}
