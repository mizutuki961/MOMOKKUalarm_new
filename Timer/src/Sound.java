
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
		//指定されたURLのオーディオ入力ストリームを取得
		try (AudioInputStream ais = AudioSystem.getAudioInputStream(path)){
			
			//ファイルの形式取得
			AudioFormat af = ais.getFormat();
			
			//単一のオーディオ形式を含む指定した情報からデータラインの情報オブジェクトを構築
			DataLine.Info dataLine = new DataLine.Info(Clip.class,af);
			
			//指定された Line.Info オブジェクトの記述に一致するラインを取得
			Clip c = (Clip)AudioSystem.getLine(dataLine);
			
			//再生準備完了
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