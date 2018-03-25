package game;

import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author joseph
 */
public class Options extends BasicGameState
{
    
    private int state;
    private Font font;
    private TrueTypeFont ttf;
    
    public Options(int s)
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
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
    {
        ttf.drawString(100, 100, "Settings");
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
