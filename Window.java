package life.main;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements Runnable {

    JFrame frame;
    Box[][] boxes;

    @Override
    public void run() {
        initFrame();
        initBox();
        initTimer();
    }

    void initFrame() {
        frame = new JFrame(); // создание окна
        frame.getContentPane().setLayout(null); // получение окна
        frame.setSize(Config.SIZE * Config.WIDTH+17, Config.SIZE * Config.HEIGHT+47); // размер окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // для закрытия программы
        frame.setLocationRelativeTo(null); // размещает окно по центу экрана
        frame.setVisible(true);
        frame.setTitle("Life Game");
    }

    void initBox() {
        boxes = new Box[Config.WIDTH][Config.HEIGHT];
        for (int x = 0; x < Config.WIDTH; x++)
            for (int y = 0; y < Config.HEIGHT; y++) {
                boxes [x][y] = new Box(x, y); // помещаем созданные ячейки в массив
                frame.add(boxes[x][y]);
            }

        for (int x = 0; x < Config.WIDTH; x++)
            for (int y = 0; y < Config.HEIGHT; y++)
                for (int sx = -1; sx <= +1; sx++)
                    for (int sy = -1; sy <= +1; sy++) {
                        if (! (sx == 0 && sy == 0)) {
                            boxes[x][y].cell.addNear(boxes[(x+sx+Config.WIDTH) % Config.WIDTH]
                                    [(y+sy+Config.HEIGHT) % Config.HEIGHT].cell);
                        }
                    }
        for (int x = 10; x < 25; x++){
            boxes[x][10].cell.status = Status.LIVE;
            boxes[x][10].setColor();
        }
    }
    private void initTimer  () {
        TimerListener t1 = new TimerListener();
        Timer timer = new Timer(Config.SLEEP, t1);
        timer.start();
    }

    private class TimerListener implements ActionListener {
        boolean flop = false;
        @Override
        public void actionPerformed(ActionEvent e) {
            flop = !flop;
            for (int x = 0; x < Config.WIDTH; x++)
                for (int y = 0; y < Config.HEIGHT; y++) {
                    if (flop)
                        boxes[x][y].step1();
                    else
                        boxes[x][y].step2();
                }
        }
    }
}
