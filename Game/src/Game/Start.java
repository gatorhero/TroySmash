package game;

import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author joseph
 */
public class Start extends BasicGameState
{
    //state of the Start screen
    private int state;
    
    //font
    private Font font;
    private TrueTypeFont ttf;
    
    //images
    private Image BackButton1;
    private Image BackButton2;
    
    
    public Start(int s)
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
        font = new Font("Showcard Gothic", Font.BOLD, 51);
        ttf = new TrueTypeFont(font, true);
        
        BackButton1 = new Image("res/BackButton1.png");
        BackButton2 = new Image("res/BackButton2.png");
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
    {
        ttf.drawString(100, 100, "Join Server");
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException 
    {
        Input input = gc.getInput();
        if(input.isKeyPressed(Input.KEY_ESCAPE))
        {
            sbg.enterState(0);
        }
    }
    
}
