package client.mainpage;

import javafx.animation.Transition;
import javafx.scene.layout.Region;
import javafx.util.Duration;

public class CustomAnimation extends Transition {

    protected double newHeight;
    private Region region;
    private double startHeight;
    private double heightDiff;

    CustomAnimation(Duration duration, Region region, double newHeight) {
        setCycleDuration(duration);
        this.region = region;
        this.newHeight = newHeight;
        this.startHeight = region.getHeight();
        this.heightDiff = newHeight - startHeight;
    }

    @Override
    protected void interpolate(double fraction) {
        region.setMinHeight( startHeight + (heightDiff * fraction));
    }
}
