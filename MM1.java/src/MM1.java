import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class MM1 {

    public static void main(String[] args) {
        // MIDI�f�[�^���Đ�����n�[�h�E�F�A/�\�t�g�E�F�A�E�f�o�C�X�̃C���X�^���X�B
        Sequencer sequencer = null;

        try {
            // �f�o�C�X�ɐڑ����ꂽ�f�t�H���g��Sequencer���擾����B
            sequencer = MidiSystem.getSequencer();

            // �f�o�C�X���J���A���\�[�X���l������B
            sequencer.open();
        }
        catch (MidiUnavailableException e) {
            e.printStackTrace();
        }

        // �R���\�[�����͂���MIDI�t�@�C���̃p�X���擾����B
        Scanner scanner = new Scanner(System.in);
        System.out.print("MIDI�t�@�C���̃p�X >> ");
        String path = scanner.next();

        try {
            // MIDI�t�@�C������MIDI�f�[�^(Sequence�I�u�W�F�N�g)���擾�B
            File file = new File(path);
            Sequence sequence = MidiSystem.getSequence(file);

            // �擾����MIDI�f�[�^���V�[�P���T�ɐݒ肷��B
            sequencer.setSequence(sequence);
        }
        catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // �V�[�P���T�[�Đ�
        sequencer.start();

        // �L�[���͑҂�
        System.out.println("�K���ɕ��������͂���ƏI�����܂��B");
        System.out.print(">>");
        scanner.next();
        scanner.close();

        // �V�[�P���T�[��~
        sequencer.stop();

        // �V�[�P���T�[����A�g�p���Ă������\�[�X�������B
        sequencer.close();
    }
}