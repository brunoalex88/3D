package com.draw.object;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Draw3DProjecoesOther extends JComponent {
	private static final int MAX = 28;
	private static final int MAXC = 42;
	private static final long serialVersionUID = 1L;
	private double[][] m = new double[3][MAXC];
	private int Xmin, Xmax, Ymin, Ymax, tx, ty;

	public static void main(String[] args) {
		final Draw3DProjecoesOther t = new Draw3DProjecoesOther();
		t.settx(400);
		t.settY(400);
		//
		t.setXmin(-500);
		t.setYmin(-500);
		t.setXmax(500);
		t.setYmax(500);
		t.definePontos();

		t.escala(t.getM(), 5, 5, 5);
		t.projecaoXY(t.getM(), 0.353, 0.353);
		
		JFrame obj = new JFrame();
		obj.getContentPane().add(t);
		obj.setSize(400, 400);
		obj.setVisible(true);
		obj.setLayout(null);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	protected void paintComponent(Graphics g) {
		g = (Graphics2D) g;

		// Desenha os eixos
		g.drawLine(mapeiaX(Xmin), mapeiaY(0), mapeiaX(Xmax), mapeiaY(0));
		g.drawLine(mapeiaX(0), mapeiaY(Ymin), mapeiaX(0), mapeiaY(Ymax));

		// Plano 1
		for (int i = 0; i < MAX / 2 - 1; i++)
			g.drawLine(mapeiaX(m[0][i]), mapeiaY(m[1][i]),
					mapeiaX(m[0][i + 1]), mapeiaY(m[1][i + 1]));

		// Plano 2
		for (int i = MAX / 2; i < MAX - 1; i++)
			g.drawLine(mapeiaX(m[0][i]), mapeiaY(m[1][i]),
					mapeiaX(m[0][i + 1]), mapeiaY(m[1][i + 1]));

		// Conexões
		for (int i = MAX; i < MAXC; i += 2) {
			g.drawLine(mapeiaX(m[0][i]), mapeiaY(m[1][i]),
					mapeiaX(m[0][i + 1]), mapeiaY(m[1][i + 1]));
		}

	}

	public void definePontos() {
		//A
		m[0][0] = 10;
		m[1][0] = 05;
		m[2][0] = 10;
		
		//B
		m[0][1] = 20;
		m[1][1] = 05;
		m[2][1] = 10;
		
		//B
		m[0][2] = 20;
		m[1][2] = 05;
		m[2][2] = 10;
		
		//C
		m[0][3] = 20;
		m[1][3] = 30;
		m[2][3] = 10;
		
		//C
		m[0][4] = 20;
		m[1][4] = 30;
		m[2][4] = 10;
		
		//D
		m[0][5] = 25;
		m[1][5] = 30;
		m[2][5] = 10;
		
		//D
		m[0][6] = 25;
		m[1][6] = 30;
		m[2][6] = 10;
		
		//E
		m[0][7] = 15;
		m[1][7] = 40;
		m[2][7] = 10;
		

		//E
		m[0][8] = 15;
		m[1][8] = 40;
		m[2][8] = 10;
		
		//F
		m[0][9] = 05;
		m[1][9] = 30;
		m[2][9] = 10;
		
		//F
		m[0][10] = 05;
		m[1][10] = 30;
		m[2][10] = 10;
		
		//G
		m[0][11] = 10;
		m[1][11] = 30;
		m[2][11] = 10;
		
		//G
		m[0][12] = 10;
		m[1][12] = 30;
		m[2][12] = 10;
		
		//A
		m[0][13] = 10;
		m[1][13] = 05;
		m[2][13] = 10;

		//Copia os valores do plano 1 para o plano 2 alterando o valor de Z para 30 (profundidade)
		for (int i = 0; i < MAX / 2; i++) {
			m[0][i + MAX / 2] = m[0][i];
			m[1][i + MAX / 2] = m[1][i];
			m[2][i + MAX / 2] = 30;
		}

		// Conexões
		//A
		m[0][28] = 10;
		m[1][28] = 05;
		m[2][28] = 10;
		
		//H
		m[0][29] = 10;
		m[1][29] = 05;
		m[2][29] = 30;
		
		//B
		m[0][30] = 20;
		m[1][30] = 05;
		m[2][30] = 10;
		
		//I
		m[0][31] = 20;
		m[1][31] = 05;
		m[2][31] = 30;
		
		//C
		m[0][32] = 20;
		m[1][32] = 30;
		m[2][32] = 10;
		
		//J
		m[0][33] = 20;
		m[1][33] = 30;
		m[2][33] = 30;
		
		//D
		m[0][34] = 25;
		m[1][34] = 30;
		m[2][34] = 10;
		
		//K
		m[0][35] = 25;
		m[1][35] = 30;
		m[2][35] = 30;
		
		//E
		m[0][36] = 15;
		m[1][36] = 40;
		m[2][36] = 10;
		
		//L
		m[0][37] = 15;
		m[1][37] = 40;
		m[2][37] = 30;
		
		//F
		m[0][38] = 05;
		m[1][38] = 30;
		m[2][38] = 10;
		
		//M
		m[0][39] = 05;
		m[1][39] = 30;
		m[2][39] = 30;
		
		//G
		m[0][40] = 10;
		m[1][40] = 30;
		m[2][40] = 10;		

		//N
		m[0][41] = 10;
		m[1][41] = 30;
		m[2][41] = 30;		
		
	}

	public void projecaoXY(double m[][], double taxaX, double taxaY) {
		double tempX, tempY;

		for (int i = 0; i < MAXC; i++) {
			tempX = m[0][i] + taxaX * m[2][i];
			tempY = m[1][i] + taxaY * m[2][i];
			m[0][i] = tempX;
			m[1][i] = tempY;
		}

	}

	public void translacao(double m[][], int tx, int ty, int tz) {
		for (int i = 0; i < MAXC; i++) {
			m[0][i] = m[0][i] + tx;
			m[1][i] = m[1][i] + ty;
			m[2][i] = m[2][i] + tz;
		}
	}

	public void escala(double m[][], double ex, double ey, double ez) {
		for (int i = 0; i < MAXC; i++) {
			m[0][i] = m[0][i] * ex;
			m[1][i] = m[1][i] * ey;
			m[2][i] = m[2][i] * ez;
		}
	}

	public int mapeiaX(double Xmundo) {

		return (int) Math.round((Xmundo - Xmin) / (Xmax - Xmin) * tx);
	}

	public int mapeiaY(double Ymundo) {

		return (int) Math.round((1 - (Ymundo - Ymin) / (Ymax - Ymin)) * ty);
	}

	public void setYmax(int i) {
		this.Ymax = i;
	}

	public void setXmax(int i) {
		this.Xmax = i;
	}

	public void setYmin(int i) {
		this.Ymin = i;
	}

	public void setXmin(int i) {
		this.Ymin = i;
	}

	public void settx(int i) {
		this.tx = i;
	}

	public void settY(int i) {
		this.ty = i;
	}

	public double[][] getM() {
		return m;
	}

}
