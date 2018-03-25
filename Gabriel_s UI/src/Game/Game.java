package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame
{
    private final int menu = 0;
    private final int start = 1;
    private final int howToPlay = 2;
    private final int options = 3;
    
    
    public Game(String name) 
    {
        super(name);
        this.addState(new MainMenu(menu));
        this.addState(new Start(start));
        this.addState(new HowToPlay(howToPlay));
        this.addState(new Options(options));
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException 
    {
        this.getState(menu).init(gc, this);
        this.getState(start).init(gc, this);
        this.getState(howToPlay).init(gc, this);
        this.getState(options).init(gc, this);
        
        this.enterState(menu);
    }
    
    public static void main(String[] args) throws SlickException
    {
        AppGameContainer app = new AppGameContainer(new Game("THS"));
        
        int width = app.getWidth();
        int height = app.getHeight();
        app.setDisplayMode(1000, 800, false);
        app.start();
    }
    
}