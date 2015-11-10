//https://github.com/captainkesty/imagebutton
package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ImageButtons extends Game {
    SpriteBatch batch;
    Stage stage;
    Image img;
    ImageButton.ImageButtonStyle imgButtonStyle;
    ImageButton imgButton;
    TextureAtlas atlasTest;
    Skin skin;

    @Override
    public void create() {
        atlasTest = new TextureAtlas("test.pack");
        skin = new Skin(atlasTest);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        // static image (no change in state visually)
        batch = new SpriteBatch();
        img = new Image(new Texture(Gdx.files.internal("badlogic.jpg")));
        img.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y) {
                System.out.println("test");
            }
        });

        // dynamic image (changes when clicked)
        imgButtonStyle = new ImageButton.ImageButtonStyle();
        imgButtonStyle.up = skin.getDrawable("FIGHTOFF");
        // imgbuttonstyle.over exists, it changes based on when you hover over the button
        imgButtonStyle.down = skin.getDrawable("FIGHTON");

        imgButton = new ImageButton(imgButtonStyle);
        imgButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("test");
            }
        });

        stage.addActor(imgButton);
        //stage.addActor(img);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
}
