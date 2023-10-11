import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Sprite {
protected BufferedImage mSpriteSheet = null;

public BufferedImage GetSprite() {
	return mSpriteSheet;
}
}
public final class SpriteComponent extends Component implements Renderable{
	private Sprite mSprite;
	 public SpriteComponent(Sprite sprite) {
	        this.mSprite = sprite;
	    }
	public void Render(Graphics2D g) {
		g.drawImage(
				mSprite.GetSprite(),
				(int) (float) getParent().getScale().getX(),
                (int) (float) getParent().getScale().getY(),
                null
				);
	}
}
