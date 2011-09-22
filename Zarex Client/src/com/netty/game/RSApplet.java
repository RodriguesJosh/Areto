package com.netty.game;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.netty.game.graphics.image.GraphicsBuffer;

public class RSApplet extends Applet implements Runnable, MouseListener, MouseMotionListener, KeyListener, FocusListener, WindowListener {

	private static final long serialVersionUID = -46265696220563451L;
	private int gameState;
	private int delayTime;
	int minDelay;
	private long[] otim;
	int fps;
	boolean shouldDebug;
	int myWidth;
	int myHeight;
	Graphics graphics;
	GraphicsBuffer fullGameScreen;
	RSFrame gameFrame;
	private boolean shouldClearScreen;
	boolean awtFocus;
	int idleTime;
	int mouseButtonDown;
	public int mouseX;
	public int mouseY;
	private int eventMouseButtonPressed;
	private int clickX;
	private int clickY;
	private long eventTime;
	int mouseButtonPressed;
	int saveClickX;
	int saveClickY;
	long clickTime;
	int[] keyStatus;
	private int[] inputBuffer;
	private int readIndex;
	private int writeIndex;

	public RSApplet() {
		this.delayTime = 20;
		this.minDelay = 1;
		this.otim = new long[10];
		this.shouldDebug = false;
		this.shouldClearScreen = true;
		this.awtFocus = true;
		this.keyStatus = new int[128];
		this.inputBuffer = new int[128];
	}

	void initializeApplication(int width, int height) {
		this.myWidth = width;
		this.myHeight = height;
		this.gameFrame = new RSFrame(this, this.myWidth, this.myHeight);
		this.graphics = this.getGameComponent().getGraphics();
		this.fullGameScreen = new GraphicsBuffer(this.myWidth, this.myHeight, this.getGameComponent());
		this.startRunnable(this, 1);
	}

	void initializeApplet(int width, int height) {
		this.myWidth = width;
		this.myHeight = height;
		this.graphics = this.getGameComponent().getGraphics();
		this.fullGameScreen = new GraphicsBuffer(this.myWidth, this.myHeight, this.getGameComponent());
		this.startRunnable(this, 1);
	}

	@Override
	public void run() {
		this.getGameComponent().addMouseListener(this);
		this.getGameComponent().addMouseMotionListener(this);
		this.getGameComponent().addKeyListener(this);
		this.getGameComponent().addFocusListener(this);
		if (this.gameFrame != null) {
			this.gameFrame.addWindowListener(this);
		}
		this.drawLoadingText(0, "Loading...");
		this.startUp();
		int i = 0;
		int j = 256;
		int k = 1;
		int i1 = 0;
		int j1 = 0;
		for (int k1 = 0; k1 < 10; k1++) {
			this.otim[k1] = System.currentTimeMillis();
		}
		while (this.gameState >= 0) {
			if (this.gameState > 0) {
				this.gameState--;
				if (this.gameState == 0) {
					this.exit();
					return;
				}
			}
			int i2 = j;
			int j2 = k;
			j = 300;
			k = 1;
			long l1 = System.currentTimeMillis();
			if (this.otim[i] == 0L) {
				j = i2;
				k = j2;
			} else if (l1 > this.otim[i]) {
				j = (int)((2560 * this.delayTime) / (l1 - this.otim[i]));
			}
			if (j < 25) {
				j = 25;
			}
			if (j > 256) {
				j = 256;
				k = (int)(this.delayTime - ((l1 - this.otim[i]) / 10L));
			}
			if (k > this.delayTime) {
				k = this.delayTime;
			}
			this.otim[i] = l1;
			i = (i + 1) % 10;
			if (k > 1) {
				for (int k2 = 0; k2 < 10; k2++) {
					if (this.otim[k2] != 0L) {
						this.otim[k2] += k;
					}
				}
			}
			if (k < this.minDelay) {
				k = this.minDelay;
			}
			try {
				Thread.sleep(k);
			} catch (InterruptedException _ex) {
				j1++;
			}
			for (; i1 < 256; i1 += j) {
				this.mouseButtonPressed = this.eventMouseButtonPressed;
				this.saveClickX = this.clickX;
				this.saveClickY = this.clickY;
				this.clickTime = this.eventTime;
				this.eventMouseButtonPressed = 0;
				this.processGameLoop();
				this.readIndex = this.writeIndex;
			}
			i1 &= 0xff;
			if (this.delayTime > 0) {
				this.fps = (1000 * j) / (this.delayTime * 256);
			}
			this.processDrawing();
			if (this.shouldDebug) {
				System.out.println("ntime:" + l1);
				for (int l2 = 0; l2 < 10; l2++) {
					int i3 = ((i - l2 - 1) + 20) % 10;
					System.out.println("otim" + i3 + ":" + this.otim[i3]);
				}
				System.out.println("fps:" + this.fps + " ratio:" + j + " count:" + i1);
				System.out.println("del:" + k + " deltime:" + this.delayTime + " mindel:" + this.minDelay);
				System.out.println("intex:" + j1 + " opos:" + i);
				this.shouldDebug = false;
				j1 = 0;
			}
		}
		if (this.gameState == -1) {
			this.exit();
		}
	}

	private void exit() {
		this.gameState = -2;
		this.cleanUpForQuit();
		if (this.gameFrame != null) {
			try {
				Thread.sleep(1000L);
			} catch (Exception e) {}
			try {
				System.exit(0);
			} catch (Throwable t) {}
		}
	}

	void method4(int i) {
		this.delayTime = 1000 / i;
	}

	@Override
	public final void start() {
		if (this.gameState >= 0) {
			this.gameState = 0;
		}
	}

	@Override
	public final void stop() {
		if (this.gameState >= 0) {
			this.gameState = 4000 / this.delayTime;
		}
	}

	@Override
	public final void destroy() {
		this.gameState = -1;
		try {
			Thread.sleep(5000L);
		} catch (Exception e) {}
		if (this.gameState == -1) {
			this.exit();
		}
	}

	@Override
	public void update(Graphics g) {
		if (this.graphics == null) {
			this.graphics = g;
		}
		this.shouldClearScreen = true;
		this.raiseWelcomeScreen();
	}

	@Override
	public void paint(Graphics g) {
		if (this.graphics == null) {
			this.graphics = g;
		}
		this.shouldClearScreen = true;
		this.raiseWelcomeScreen();
	}

	@Override
	public void mousePressed(MouseEvent mouseevent) {
		int i = mouseevent.getX();
		int j = mouseevent.getY();
		if (this.gameFrame != null) {
			i -= 4;
			j -= 22;
		}
		this.idleTime = 0;
		this.clickX = i;
		this.clickY = j;
		this.eventTime = System.currentTimeMillis();
		if (mouseevent.isMetaDown()) {
			this.eventMouseButtonPressed = 2;
			this.mouseButtonDown = 2;
		} else {
			this.eventMouseButtonPressed = 1;
			this.mouseButtonDown = 1;
		}
	}

	@Override
	public void mouseReleased(MouseEvent mouseevent) {
		this.idleTime = 0;
		this.mouseButtonDown = 0;
	}

	@Override
	public void mouseClicked(MouseEvent mouseevent) {}
	@Override
	public void mouseEntered(MouseEvent mouseevent) {}

	@Override
	public void mouseExited(MouseEvent mouseevent) {
		this.idleTime = 0;
		this.mouseX = -1;
		this.mouseY = -1;
	}

	@Override
	public void mouseDragged(MouseEvent mouseevent) {
		int i = mouseevent.getX();
		int j = mouseevent.getY();
		if (this.gameFrame != null) {
			i -= 4;
			j -= 22;
		}
		this.idleTime = 0;
		this.mouseX = i;
		this.mouseY = j;
	}

	@Override
	public void mouseMoved(MouseEvent mouseevent) {
		int i = mouseevent.getX();
		int j = mouseevent.getY();
		if (this.gameFrame != null) {
			i -= 4;
			j -= 22;
		}
		this.idleTime = 0;
		this.mouseX = i;
		this.mouseY = j;
	}

	@Override
	public void keyPressed(KeyEvent keyevent) {
		this.idleTime = 0;
		int i = keyevent.getKeyCode();
		int j = keyevent.getKeyChar();
		if (j < 30) {
			j = 0;
		}
		if (i == KeyEvent.VK_LEFT) {
			j = 1;
		}
		if (i == KeyEvent.VK_RIGHT) {
			j = 2;
		}
		if (i == KeyEvent.VK_UP) {
			j = 3;
		}
		if (i == KeyEvent.VK_DOWN) {
			j = 4;
		}
		if (i == KeyEvent.VK_CONTROL) {
			j = 5;
		}
		if (i == 8) {
			j = 8;
		}
		if (i == KeyEvent.VK_DELETE) {
			j = 8;
		}
		if (i == 9) {
			j = 9;
		}
		if (i == 10) {
			j = 10;
		}
		if ((i >= KeyEvent.VK_F1) && (i <= KeyEvent.VK_F12)) {
			j = (1008 + i) - 112;
		}
		if (i == KeyEvent.VK_HOME) {
			j = 1000;
		}
		if (i == KeyEvent.VK_END) {
			j = 1001;
		}
		if (i == KeyEvent.VK_PAGE_UP) {
			j = 1002;
		}
		if (i == KeyEvent.VK_PAGE_DOWN) {
			j = 1003;
		}
		if ((j > 0) && (j < 128)) {
			this.keyStatus[j] = 1;
		}
		if (j > 4) {
			this.inputBuffer[this.writeIndex] = j;
			this.writeIndex = (this.writeIndex + 1) & 0x7f;
		}
	}

	@Override
	public void keyReleased(KeyEvent keyevent) {
		this.idleTime = 0;
		int i = keyevent.getKeyCode();
		char c = keyevent.getKeyChar();
		if (c < '\036') {
			c = '\0';
		}
		if (i == 37) {
			c = '\001';
		}
		if (i == 39) {
			c = '\002';
		}
		if (i == 38) {
			c = '\003';
		}
		if (i == 40) {
			c = '\004';
		}
		if (i == 17) {
			c = '\005';
		}
		if (i == 8) {
			c = '\b';
		}
		if (i == 127) {
			c = '\b';
		}
		if (i == 9) {
			c = '\t';
		}
		if (i == 10) {
			c = '\n';
		}
		if ((c > 0) && (c < '\200')) {
			this.keyStatus[c] = 0;
		}
	}

	@Override
	public void keyTyped(KeyEvent keyevent) {}

	int readChar() {
		int k = -1;
		if (this.writeIndex != this.readIndex) {
			k = this.inputBuffer[this.readIndex];
			this.readIndex = (this.readIndex + 1) & 0x7f;
		}
		return k;
	}

	@Override
	public void focusGained(FocusEvent focusevent) {
		this.awtFocus = true;
		this.shouldClearScreen = true;
		this.raiseWelcomeScreen();
	}

	@Override
	public void focusLost(FocusEvent focusevent) {
		this.awtFocus = false;
		for (int i = 0; i < 128; i++) {
			this.keyStatus[i] = 0;
		}
	}

	@Override
	public final void windowActivated(WindowEvent windowevent) {}
	@Override
	public final void windowClosed(WindowEvent windowevent) {}

	@Override
	public final void windowClosing(WindowEvent windowevent) {
		this.destroy();
	}

	@Override
	public final void windowDeactivated(WindowEvent windowevent) {}
	@Override
	public final void windowDeiconified(WindowEvent windowevent) {}
	@Override
	public final void windowIconified(WindowEvent windowevent) {}
	@Override
	public final void windowOpened(WindowEvent windowevent) {}

	void startUp() {}
	void processGameLoop() {}
	void cleanUpForQuit() {}
	void processDrawing() {}
	void raiseWelcomeScreen() {}

	Component getGameComponent() {
		if (this.gameFrame != null) {
			return this.gameFrame;
		}
		return this;
	}

	public void startRunnable(Runnable runnable, int priority) {
		Thread thread = new Thread(runnable);
		thread.start();
		thread.setPriority(priority);
	}

	void drawLoadingText(int i, String s) {
		while (this.graphics == null) {
			this.graphics = this.getGameComponent().getGraphics();
			try {
				this.getGameComponent().repaint();
			} catch (Exception e) {}
			try {
				Thread.sleep(1000L);
			} catch (Exception _ex) {}
		}
		Font font = new Font("Helvetica", 1, 13);
		FontMetrics fontmetrics = this.getGameComponent().getFontMetrics(font);
		Font font1 = new Font("Helvetica", 0, 13);
		this.getGameComponent().getFontMetrics(font1);
		if (this.shouldClearScreen) {
			this.graphics.setColor(Color.black);
			this.graphics.fillRect(0, 0, this.myWidth, this.myHeight);
			this.shouldClearScreen = false;
		}
		Color color = new Color(140, 17, 17);
		int j = (this.myHeight / 2) - 18;
		this.graphics.setColor(color);
		this.graphics.drawRect((this.myWidth / 2) - 152, j, 304, 34);
		this.graphics.fillRect((this.myWidth / 2) - 150, j + 2, i * 3, 30);
		this.graphics.setColor(Color.black);
		this.graphics.fillRect(((this.myWidth / 2) - 150) + (i * 3), j + 2, 300 - (i * 3), 30);
		this.graphics.setFont(font);
		this.graphics.setColor(Color.white);
		this.graphics.drawString(s, (this.myWidth - fontmetrics.stringWidth(s)) / 2, j + 22);
	}
}