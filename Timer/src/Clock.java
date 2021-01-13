import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Clock {
    private JLabel clockLabel;
    private DateFormat formatter = DateFormat.getDateTimeInstance();
    private JFrame frmMomokkutimer;
    private JButton EndButton;
    private JButton TimerButton;
    private TimerSet Dlg=new TimerSet();
    public int flag = 0;
    private JLabel TimerLabel;

    /**
     * @wbp.parser.entryPoint
     */
    public Clock() {
        JFrame frame = initFrame();
        frmMomokkutimer.getContentPane().setLayout(new BorderLayout(300, 10));
        clockLabel = initClockLabel();

        frame.getContentPane().add(clockLabel, BorderLayout.NORTH);
        
        JPanel ButtonPanel = new JPanel();
        frmMomokkutimer.getContentPane().add(ButtonPanel, BorderLayout.SOUTH);
        ButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JButton SoundStopButton = new JButton("Stop");
        SoundStopButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Sound.flag=1;
        	}
        });
        SoundStopButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
        ButtonPanel.add(SoundStopButton);
        
        TimerButton = new JButton("\u30BF\u30A4\u30DE\u30FC\u3092\u30BB\u30C3\u30C8\u3059\u308B");
        TimerButton.addActionListener(new ActionListener() {
        	//TimerSet
        	public void actionPerformed(ActionEvent e) {
        		Dlg.setVisible(true);	
        		if(Dlg.OkFlag) {	//Flag check 
        			//TODO Describe the process
        			Date sdf =(Date)Dlg.Dlgspinner.getValue();
        			TimerTask task = new TimerTask() {
						public void run() {
        	                System.out.println("OK!");
        	                try {
								Sound.main(null);
							} catch (Exception e) {
								// TODO 自動生成された catch ブロック
								e.printStackTrace();
							}
        	            }
        	        };

        	        Timer timer = new Timer();
        	        timer.schedule(task, sdf);
        		}
        	}
        });
        TimerButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
        ButtonPanel.add(TimerButton);
        
        EndButton = new JButton("\u7D42\u4E86");
        EndButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
        EndButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        ButtonPanel.add(EndButton);
        
        TimerLabel = new JLabel("ここに設定した時間を表示します");
        TimerLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 30));
        TimerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frmMomokkutimer.getContentPane().add(TimerLabel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);

        initTimer();
    }

    public Clock(String imagefile) {
        JFrame frame = initFrame();
        clockLabel = initClockLabel();

        JLabel background = initBackground(imagefile, clockLabel);
        frame.getContentPane().add(background);
        
        frame.pack();
        frame.setVisible(true);

        initTimer();
    }

    private JFrame initFrame() {
        frmMomokkutimer = new JFrame("Java Clock");
        frmMomokkutimer.setTitle("MOMOKKUTimer");
        frmMomokkutimer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return frmMomokkutimer;
    }

    private JLabel initClockLabel() {
        JLabel Timelabel = new JLabel();
        Timelabel.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = Timelabel.getFont();
        font = new Font(font.getFontName(), font.getStyle(), font.getSize() + 4);
        Timelabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 50));
        Timelabel.setText(formatter.format(new Date(System.currentTimeMillis())));

        return Timelabel;
    }

    private JLabel initBackground(String imagefile, JLabel label) {
        ImageIcon icon = new ImageIcon(imagefile);
        JLabel background = new JLabel(icon);
        background.setLayout(new FlowLayout());
        background.add(label);

        return background;
    }

    private void initTimer() {
        Timer timer = new Timer();
        
        Date start = new Date((System.currentTimeMillis() / 1000L) * 1000L + 2000L);
        timer.scheduleAtFixedRate(new ClockTask(this), start, 1000L);
    }

    public void update(long time) {
        clockLabel.setText(formatter.format(new Date(time)));
    }


    /**
     * @wbp.parser.entryPoint
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            new Clock(args[0]);
        } else {
            new Clock();
        }
    }
}
