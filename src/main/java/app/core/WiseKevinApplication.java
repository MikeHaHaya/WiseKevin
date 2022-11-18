package app.core;

import static app.core.statics.Globals.*;

import app.core.game.GameFrame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class WiseKevinApplication {

    public static void main(String[] args) {

        new GameFrame(); // TODO -- Check exceptions (Headless Exception) and maybe try launching GameFrame as an entity

    }

}
