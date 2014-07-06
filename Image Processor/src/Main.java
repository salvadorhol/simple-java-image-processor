import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;

public class Main {

	public static void main(String args[]) throws IOException{
		System.out.println(System.getProperty("user.dir"));
		ImgHist image1 = new ImgHist("Images/coins.bmp");

		JFrame frame = new JFrame();
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 0;
		c.gridy = 0;
		frame.getContentPane().add(new JLabel("Original Image"), c);
		
		c.gridx = 1;
		c.gridy = 0;
		frame.getContentPane().add(new JLabel("Equalized Image"), c);
		
		c.gridx = 0;
		c.gridy = 1;
		frame.getContentPane().add(new JLabel(new ImageIcon(image1.getOriginalImage())), c);
		
		c.gridx = 1;
		c.gridy = 1;
		frame.getContentPane().add(new JLabel(new ImageIcon(image1.getEqualImage())), c);
		
		c.gridx = 0;
		c.gridy = 2;
		frame.getContentPane().add(new JLabel("Optimal Binary"), c);
		
		c.gridx = 0;
		c.gridy = 3;
		frame.getContentPane().add(new JLabel(new ImageIcon(image1.getOptimalBinaryImage())), c);
		
		
		//histograms
		double[] x = new double[256]; 
		for(int i = 0; i < 256; i++){
			x[i] = i;
		}
		
		double[] x_bin = new double[2];
		for(int i = 0; i < 2; i++){
			x[i] = i;
		}
		
//		BaseLabel title1 = new BaseLabel("Original Histogram", Color.black, 0.5, 1.1);
//		title1.setFont(new Font("Cambria", Font.BOLD, 20));
//		
//		BaseLabel title2 = new BaseLabel("Equalized Histogram", Color.black, 0.5, 1.1);
//		title2.setFont(new Font("Cambria", Font.BOLD, 20));
		
		BaseLabel title3 = new BaseLabel("Binary Histogram", Color.black, 0.5, 1.1);
		title3.setFont(new Font("Cambria", Font.BOLD, 20));

//		Plot2DPanel plot1 = new Plot2DPanel();
//		plot1.addPlotable(title1);
//		plot1.addBarPlot("Original", x, ArrayHelper.intToDouble(image1.getHistogramOriginal()));
//				
//		Plot2DPanel plot2 = new Plot2DPanel();
//		plot2.addPlotable(title2);
//		plot2.addBarPlot("Equalized", x, ArrayHelper.intToDouble(image1.getHistogramEqal()));
		
		Plot2DPanel plot3 = new Plot2DPanel();
		plot3.addPlotable(title3);
		plot3.addBarPlot("Binary", x, ArrayHelper.intToDouble(image1.getHistogramBinary()));
		
//		JFrame originalPlot = new JFrame();
//		originalPlot.setSize(600, 600);
//		originalPlot.setContentPane(plot1);
//		originalPlot.setVisible(true);
//		
//		JFrame eqalPlot = new JFrame();
//		eqalPlot.setSize(600, 600);
//		eqalPlot.setContentPane(plot2);
//		eqalPlot.setVisible(true);
		
		JFrame binary = new JFrame();
		binary.setSize(600, 600);
		binary.setContentPane(plot3);
		binary.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
	}
}
