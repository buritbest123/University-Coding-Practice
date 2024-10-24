package itcs209.labs.lab9;
import processing.core.PApplet;
    public class StandingCircle {
        private float x;
        private float y;
        private float radius;

        public StandingCircle(float x, float y, float radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public void render(PApplet context) {
            this.wrapSpace(context.width, context.height);
            // TODO: Change to your own color
            context.fill(255, 80, 80);
            context.stroke(255, 102, 153);
            context.strokeWeight(5);
            context.circle(this.x, this.y, this.radius);
        }

        public void move(float dx, float dy) {
            this.x = x + dx;
            this.y = y + dy;
        }

        public void setRadius(float radius) {
            this.radius = radius;
        }

        public void wrapSpace(int canvasWidth, int canvasHeight) {
            if (x > canvasWidth) {
                this.x = this.x % canvasWidth;
            }
            if (y > canvasHeight) {
                this.y = this.y % canvasHeight;
            }
        }
    }

