package com.everythingisreally;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by fen on 2/24/16.
 */
public class Whale extends Rectangle {

    private double Health = 100;
    private Texture whaleImage;
    private int Score = 0;

    private Texture whale_1 = new Texture(Gdx.files.internal("star_whale.png"));
    private Texture whale_2 = new Texture(Gdx.files.internal("star_whale_20.png"));
    private Texture whale_3 = new Texture(Gdx.files.internal("star_whale_40.png"));
    private Texture whale_4 = new Texture(Gdx.files.internal("star_whale_70.png"));
    private double whale_w_2 = 32 * 1.2;
    private double whale_w_3 = 32 * 1.4;
    private double whale_w_4 = 32 * 1.7;

    public Whale(float x, float y, float width, float height, Texture whaleImage) {
        super(x, y, width, height);
        this.whaleImage = whaleImage;
    }


    public int getHealth() {
        return ((int) Math.round(Health));
    }

    public void setHealth(double health) {
        Health = health;
    }
    public void addHealth(double x){
        if(Health + (1* x) <= 100){
            Health += 1 * x;
        } else Health = 100;
    }

    public void drainHealth(){
        if((Health -= .2) <= 0){
            whaleImage.dispose();
            Health = 0;
        } else Health -= .2;
    }

    public Texture getWhaleImage() {
        return whaleImage;
    }

    public void setWhaleImage(Texture whaleImage) {
        this.whaleImage = whaleImage;
    }

    // Texture
    public int getScore() {
        return Score;
    }

    public void addScore(int x) {
        Score += 1 * x;
    }

    public void refreshWhale(){
        if(Score < 50) {
            setWhaleImage(whale_1);
        }
        if(Score >= 50 && Score < 100) {
            setWhaleImage(whale_2);
            this.setWidth(((float) whale_w_2));
        }
        if(Score >= 100 && Score < 200) {
            setWhaleImage(whale_3);
            this.setWidth(((float) whale_w_3));
        }
        if(Score >= 200) {
            setWhaleImage(whale_4);
            this.setWidth(((float) whale_w_4));
        }
    }

}
