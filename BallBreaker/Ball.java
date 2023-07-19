import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int dy =5;
    int dx =0;
    int count = 0;
    public Player player;
    public World myWorld;
    public Ball (Player player, World world)
    {
        myWorld = world;
        this.player = player;
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
    }
    public void act()
    {
        moveArround();
        bounce();
        bounceOffEdge();
        hitBlock();
        youLose();
        youWin();
    }
    public void moveArround()
    {
        setLocation(getX() + dx, getY() + dy);
    }
    public void bounce()
    {
        if (isTouching (Player.class) && this.player.getX() > getX() +50)
        {
            dy = -dy;
            dx -= 6;
            Greenfoot.playSound("hit.wav");
        }
        else if (isTouching (Player.class)&& this.player.getX() < getX() -50)
        {
            dy = -dy;
            dx += 6;
            Greenfoot.playSound("hit.wav");
        }
        else if (isTouching (Player.class)&& this.player.getX() > getX() +40)
        {
            dy = -dy;
            dx -= 5;
            Greenfoot.playSound("hit.wav");
        }
        else if (isTouching (Player.class)&& this.player.getX() < getX() -40)
        {
            dy = -dy;
            dx += 5;
            Greenfoot.playSound("hit.wav");
        }
        else if (isTouching (Player.class)&& this.player.getX() > getX() +30)
        {
            dy = -dy;
            dx -= 4;
            Greenfoot.playSound("hit.wav");
        }
        else if (isTouching (Player.class)&& this.player.getX() < getX() -30)
        {
            dy = -dy;
            dx += 4;
            Greenfoot.playSound("hit.wav");
        }
        else if (isTouching (Player.class)&& this.player.getX() > getX() +20)
        {
            dy = -dy;
            dx -= 3;
            Greenfoot.playSound("hit.wav");
        }
        else if (isTouching (Player.class)&& this.player.getX() < getX() -20)
        {
            dy = -dy;
            dx += 3;
            Greenfoot.playSound("hit.wav");
        }
        else if (isTouching (Player.class)&& this.player.getX() > getX() +10)
        {
            dy = -dy;
            dx -= 2;
            Greenfoot.playSound("hit.wav");
        }
        else if (isTouching (Player.class)&& this.player.getX() < getX() -10)
        {
            dy = -dy;
            dx += 2;
            Greenfoot.playSound("hit.wav");
        }
        else if ((isTouching (Player.class)|| isTouching(Block.class)))
        {
            dy = -dy;
            Greenfoot.playSound("hit.wav");
            
        }
    }
    public void bounceOffEdge()
    {
        if (getX()>= getWorld().getWidth()-1)
        {
            dx = -dx;
            Greenfoot.playSound("hit.wav");
        }
        if (getX()<= 0)
        {
            dx = -dx;
            Greenfoot.playSound("hit.wav");
        }
        if (getY() <=0)
        {
            dy =-dy;
            Greenfoot.playSound("hit.wav");
        }
    }
    public void hitBlock()
    {
        Actor block = getOneIntersectingObject(Block.class);
        if (block != null && block.getX() > getX()+30)
        {
            getWorld().removeObject(block);
            dx = -dx;
            count++;
            getWorld().showText("MANTAPP  !!!", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.playSound("blast.wav");
        }
        else if (block != null && block.getX() < getX()-30)
        {
            getWorld().removeObject(block);
            dx = -dx;
            count++;
            getWorld().showText("LANJUTKAN !!!", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.playSound("blast.wav");
        }
        
        else if (block != null)
        {
            getWorld().removeObject(block);
            count++;
            getWorld().showText("KERENN !!!", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.playSound("blast.wav");
        
        }
    }
    public void youLose()
    {
        if (getY()>= getWorld().getHeight() -1)
        {
            Greenfoot.playSound("kalah.mp3");
            getWorld().showText("YOU LOSE :( ", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
    public void youWin()
    {
        if (count == 32)
        {
            
            Greenfoot.playSound("yay.mp3");
            getWorld().showText("YOU WIN !!!", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}