
import java.io.*;
import java.net.MalformedURLException;
 
import javax.sound.sampled.*;
 
public class Sound {
	static int flag = 0;
	public static void main(String[] args) throws Exception{
		Clip clip = createClip(new File("alerm1.wav"));
		while(true) {
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			Thread.sleep(7050);
			
			if(flag != 0) {
				break;
			}
			clip.flush();
			clip.setFramePosition(0);
		}
		clip.close();
	}
 
	public static Clip createClip(File path) {
		try (AudioInputStream ais = AudioSystem.getAudioInputStream(path)){
			
			//繝輔ぃ繧､繝ｫ縺ｮ蠖｢蠑丞叙蠕�
			AudioFormat af = ais.getFormat();
			
			//蜊倅ｸ�縺ｮ繧ｪ繝ｼ繝�繧｣繧ｪ蠖｢蠑上ｒ蜷ｫ繧�謖�螳壹＠縺滓ュ蝣ｱ縺九ｉ繝�繝ｼ繧ｿ繝ｩ繧､繝ｳ縺ｮ諠�蝣ｱ繧ｪ繝悶ず繧ｧ繧ｯ繝医ｒ讒狗ｯ�
			DataLine.Info dataLine = new DataLine.Info(Clip.class,af);
			
			//謖�螳壹＆繧後◆ Line.Info 繧ｪ繝悶ず繧ｧ繧ｯ繝医�ｮ險倩ｿｰ縺ｫ荳�閾ｴ縺吶ｋ繝ｩ繧､繝ｳ繧貞叙蠕�
			Clip c = (Clip)AudioSystem.getLine(dataLine);
			
			//蜀咲函貅門ｙ螳御ｺ�
			c.open(ais);
			
			return c;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		return null;
	}
}