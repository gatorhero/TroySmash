package game;

import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author joseph
 */
public class HowToPlay extends BasicGameState
{
    
    private int state;
    private Font font;
    private TrueTypeFont ttf;
    
    public HowToPlay(int s)
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
        font = new Font("Showcard Gothic", Font.BOLD, 20);
        ttf = new TrueTypeFont(font, true);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        ttf.drawString(50, 100, "Use the movement keys (WASD by default) to move around. ");
        ttf.drawString(50, 200,"By combining your attack (T by default) or special moves (Y by default) ");
        ttf.drawString(50, 300, "with movement commands, your character will execute unique special abilities. ");
        ttf.drawString(50,400, "If you manage to destroy the TROY Ball, holding down your special key will ");
        ttf.drawString(50,500, "consume the ball to use your characters Final, a super strong, game changing ability. ");
        ttf.drawString(50,600, "Your goal is to knock off the other players to be the last one standing!");
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
