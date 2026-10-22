package ua.opnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame implements ActionListener {

    public MainFrame(String title) throws HeadlessException {
        super(title);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        JButton rockButton = new JButton("Камінь");
        rockButton.addActionListener(this);
        rockButton.setActionCommand("rock");

        JButton paperButton = new JButton("Папір");
        paperButton.addActionListener(this);
        paperButton.setActionCommand("paper");

        JButton scissorsButton = new JButton("Ножиці");
        scissorsButton.addActionListener(this);
        scissorsButton.setActionCommand("scissors");

        JButton lizardButton = new JButton("Ящірка");
        lizardButton.addActionListener(this);
        lizardButton.setActionCommand("lizard");

        JButton spockButton = new JButton("Спок");
        spockButton.addActionListener(this);
        spockButton.setActionCommand("spock");

        this.add(rockButton);
        this.add(paperButton);
        this.add(scissorsButton);
        this.add(lizardButton);
        this.add(spockButton);

        this.pack();
        this.setVisible(true);
    }

    private GameShape generateShape() {

        // написати логіку методу

        // Метод повертає об'єкт ігрової фігури (камінь, ножиці чи папір)
        // випадковим чином

        int random = new Random().nextInt(5);

        return switch (random) {
            case 0 -> new Rock();
            case 1 -> new Paper();
            case 2 -> new Scissors();
            case 3 -> new Lizard();
            case 4 -> new Spock();
            default -> new GameShape();
        };


        //return new GameShape(); // змініть на об'єкт потрібної фігури
    }

    private int checkWinner(GameShape player, GameShape computer) {

        // Метод отримує клас фігури гравця і комп'ютера за допомогою оператора instanceof
        // Метод повертає 1 якщо переміг гравець
        // Метод повертає 0 якщо нічия (обидві фігури однакові)
        // Метод повертає -1 якщо переміг комп'ютер

        // написати логіку методу

        if(player.getClass().equals(computer.getClass())) return 0;

        if(player instanceof Rock){
            if(computer instanceof Scissors || computer instanceof Lizard) return 1;
            if(computer instanceof Paper || computer instanceof Spock) return -1;
        }
        if(player instanceof Paper){
            if(computer instanceof Rock || computer instanceof Spock) return 1;
            if(computer instanceof Scissors || computer instanceof Lizard) return -1;
        }
        if(player instanceof Scissors){
            if(computer instanceof Paper || computer instanceof Lizard) return 1;
            if(computer instanceof Rock || computer instanceof Spock) return -1;
        }
        if(player instanceof Lizard){
            if(computer instanceof Paper || computer instanceof Spock) return 1;
            if(computer instanceof Rock || computer instanceof Scissors) return -1;
        }
        if(player instanceof Spock){
            if(computer instanceof Rock || computer instanceof Scissors) return 1;
            if(computer instanceof Paper || computer instanceof Lizard) return -1;
        }

        return 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Генерується ход комп'ютеру
        GameShape computerShape = generateShape();

        GameShape playerShape = new GameShape();
        // Визначаємо, на яку кнопку натиснув гравець
        switch (e.getActionCommand()) {
            case "rock":
                // присвоїти playerShape об'єкт відповідного класу
                playerShape = new Rock();
                break;
            case "paper":
                // присвоїти playerShape об'єкт відповідного класу
                playerShape = new Paper();
                break;
            case "scissors":
                // присвоїти playerShape об'єкт відповідного класу
                playerShape = new Scissors();
                break;
            case "lizard":
                playerShape = new Lizard();
                break;
            case "spock":
                playerShape = new Spock();
                break;
        }

        // Визначити результат гри
        int gameResult = checkWinner(playerShape, computerShape);

        // Сформувати повідомлення
        String message = "Player shape: " + playerShape + ". Computer shape: " + computerShape + ". ";
        switch (gameResult) {
            case -1:
                message += "Computer has won!";
                break;
            case 0:
                message += "It's a tie!";
                break;
            case 1:
                message += "Player has won!";
        }

        // Вивести діалогове вікно з повідомленням
        JOptionPane.showMessageDialog(null, message);
    }
}
