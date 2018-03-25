package game;

import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.FontUtils;

/**
 *
 * @author joseph
 */
public class MainMenu extends BasicGameState
{
    
    //state of MainMenu
    private int state;
    
    //number of options
    private int numChoices;

    public MainMenu() {
    }
    
    //text font
    private Font font;
    private TrueTypeFont ttf;
    
    //list of choices for the player
    private Image[] options;
    
    //colors
    private Color c1;
    private Color c2;
    
    //screen to go into
    private int playerChoice;
    
    //buttons
    private Image JoinButton1;
    private Image JoinButton2;
    private Image SettingsButton1;
    private Image SettingsButton2;
    private Image HowToPlayButton1; 
    private Image HowToPlayButton2;
    private Image ExitButton1;
    private Image ExitButton2;
    
    //logo
    private Image logo;
    
    
    //hehe its daddy kim
    private Image kim;
    
    //width and height
    private final int width = 1000;
    private final int height = 800;
    
    public MainMenu(int s)
    {
        state = s;
    }
    
    @Override
    public int getID() {
        return state;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
    {
        font = new Font("Showcard Gothic", Font.BOLD, 50);
        ttf = new TrueTypeFont(font, true);
        
        playerChoice = 0;
        //c1 = new Color(255, 0, 0);
        c2 = new Color(255, 255, 255);
        
        JoinButton1 = new Image("res/JoinServerButton1.png");
        JoinButton2 = new Image("res/JoinServerButton2.png");
        HowToPlayButton1 = new Image("res/HowToPlayButton1.png");
        HowToPlayButton2 = new Image("res/HowToPlayButton2.png");
        SettingsButton1 = new Image("res/SettingsButton1.png");
        SettingsButton2 = new Image("res/SettingsButton2.png");
        ExitButton1 = new Image("res/ExitButton1.png");
        ExitButton2 = new Image("res/ExitButton2.png");
        
        logo = new Image("res/logo.png");
        
        kim = new Image("res/kim.PNG");
        
        options = new Image[]{JoinButton1, JoinButton2, HowToPlayButton1 ,HowToPlayButton2, SettingsButton1, SettingsButton2, ExitButton1, ExitButton2};
        numChoices = options.length/2;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
    {
        //ttf.drawString(100, 100, "TROY SMASH", c2);
        logo.draw(15, 0, .42f);
        renderOptions();
        kim.draw(400, 200, .5f);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException 
    {
        Input input = gc.getInput();
        
        if(input.isKeyPressed(Input.KEY_UP))
        {
            if(playerChoice == 0)
            {
                playerChoice = numChoices - 1;
            }
            else
            {
                playerChoice--;
            }
            System.out.println(playerChoice);
        }
        if(input.isKeyPressed(Input.KEY_DOWN))
        {
            if(playerChoice == numChoices - 1)
            {
                playerChoice = 0;
            }
            else
            {
                playerChoice++;
            }
            System.out.println(playerChoice);
        }
        if(input.isKeyPressed(Input.KEY_ENTER))
        {
            if(playerChoice < numChoices)
            {
                sbg.enterState(playerChoice + 1);
            }
            else
            {
                gc.exit();
            }
        }
    }
    
    public void renderOptions()
    {
        for(int i = 0; i < numChoices; i++)
        {
            if (playerChoice == i)
            {
                options[i*2+1].draw(93, i*150 + 193, .48f);
            }
            else
            {
                options[i * 2].draw(100, i *150 + 200, .45f);
            }
        }
    }
}
