package aliberti.framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.SimpleTheme;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.BorderLayout;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Menu {
	private String pathConfig;
	private List<Accion> acciones;

	public Menu(String pathConfig) {
		this.acciones = new ArrayList<Accion>();
		this.pathConfig = pathConfig;
		this.acciones = leerAccionesDelProperties();
	}

	public void run() {
		imprimirMenu();
	}

	private List<Accion> leerAccionesDelProperties() {
		Properties prop = new Properties();
		ArrayList<Accion> listaDeAcciones = new ArrayList<Accion>();
		try (InputStream configFile = getClass().getResourceAsStream(this.pathConfig);) {
			prop.load(configFile);
			String clase = prop.getProperty("clase");

			String[] clases = clase.split(";");

			for (int i = 0; i < clases.length; i++) {
				Accion accionTemp = (Accion) Class.forName(clases[i]).getDeclaredConstructor().newInstance();
				listaDeAcciones.add(accionTemp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Se Produjo un Error al Instanciar una Clase del Config: " + e.getMessage());
		}

		return listaDeAcciones;
	}

	private void imprimirMenu() {
		try {
			Terminal terminal = new DefaultTerminalFactory().createTerminal();
			Screen screen = new TerminalScreen(terminal);
			screen.startScreen();

			Panel titlePanel = new Panel();
			titlePanel.addComponent(new Label(" "));
			titlePanel.addComponent(new Label(" Aliberti's Lanterna Framework").addStyle(SGR.BOLD));
			Panel buttonsPanel = new Panel(new GridLayout(3).setHorizontalSpacing(1));

			buttonsPanel.addComponent(new Button("Exit", () -> System.exit(0)));
			buttonsPanel.setLayoutData(
					GridLayout.createLayoutData(GridLayout.Alignment.BEGINNING, GridLayout.Alignment.END, true, true));
			Panel contentPanel = new Panel(new GridLayout(1).setLeftMarginSize(1).setRightMarginSize(1));
			int i = 1;
			contentPanel.addComponent(new Label(
					"Bienvenido al framework ejecutor de acciones.\nEste framework muestra las acciones disponibles y te permite seleccionar la acción a ejecutar"));
			contentPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
			for (Accion a : acciones) {
				contentPanel
						.addComponent(new Label(i + ". " + a.nombreItemMenu() + " (" + a.descripcionItemMenu() + ")")
								.setForegroundColor(TextColor.ANSI.RED));
				contentPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
				final Integer contadorInterno = new Integer(i);
				buttonsPanel.addComponent(
						new Button(a.nombreItemMenu(), () -> this.acciones.get((contadorInterno - 1)).ejecutar()));
				i++;
			}
			contentPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
			buttonsPanel.setLayoutData(
					GridLayout.createLayoutData(GridLayout.Alignment.BEGINNING, GridLayout.Alignment.END, true, true))
					.addTo(contentPanel);

			Panel mainPanel = new Panel(new BorderLayout());
			mainPanel.addComponent(titlePanel, BorderLayout.Location.TOP);

			BasicWindow mainWindow = new BasicWindow();
			mainWindow.setHints(Arrays.asList(Window.Hint.FULL_SCREEN, Window.Hint.NO_DECORATIONS));
			mainWindow.setTheme(new SimpleTheme(TextColor.ANSI.WHITE, TextColor.ANSI.BLUE));
			mainWindow.setComponent(mainPanel);

			BasicWindow window = new BasicWindow("Framework Ejecutor de Acciones");
			window.setHints(Arrays.asList(Window.Hint.CENTERED));
			window.setComponent(contentPanel);

			MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(),
					new EmptySpace(TextColor.ANSI.BLUE));
			gui.addWindow(mainWindow);
			gui.addWindow(window);
			gui.waitForWindowToClose(mainWindow);
			gui.setActiveWindow(window);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e.getCause());
		}

	}
}
