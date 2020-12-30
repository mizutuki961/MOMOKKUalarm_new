import java.io.*;
import java.net.MalformedURLException;
 
import javax.sound.sampled.*;
 
public class MM2 {
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
		//�w�肳�ꂽURL�̃I�[�f�B�I���̓X�g���[�����擾
		try (AudioInputStream ais = AudioSystem.getAudioInputStream(path)){
			
			//�t�@�C���̌`���擾
			AudioFormat af = ais.getFormat();
			
			//�P��̃I�[�f�B�I�`�����܂ގw�肵����񂩂�f�[�^���C���̏��I�u�W�F�N�g���\�z
			DataLine.Info dataLine = new DataLine.Info(Clip.class,af);
			
			//�w�肳�ꂽ Line.Info �I�u�W�F�N�g�̋L�q�Ɉ�v���郉�C�����擾
			Clip c = (Clip)AudioSystem.getLine(dataLine);
			
			//�Đ���������
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