package mx.iteso.strategy.balls;
import mx.iteso.strategy.Ball;
import mx.iteso.strategy.behaviors.BounceBehavior;
import mx.iteso.strategy.behaviors.DeflateBehavior;
import mx.iteso.strategy.behaviors.RollBehavior;
import mx.iteso.strategy.behaviors.impl.*;

public class SoccerBall extends Ball {
    public SoccerBall() {
        bounceBehavior = new NormalBounce();
        deflateBehavior = new Deflatable();
        rollBehavior = new NormalRoll();
        type = "Soccer ball";
    }

    public SoccerBall (BounceBehavior bounce, DeflateBehavior deflate, RollBehavior roll) {
        type = "Soccer ball";
        bounceBehavior = bounce;
        deflateBehavior = deflate;
        rollBehavior = roll;
    }
}
