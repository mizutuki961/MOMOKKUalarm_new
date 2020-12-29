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
        // MIDIデータを再生するハードウェア/ソフトウェア・デバイスのインスタンス。
        Sequencer sequencer = null;

        try {
            // デバイスに接続されたデフォルトのSequencerを取得する。
            sequencer = MidiSystem.getSequencer();

            // デバイスを開き、リソースを獲得する。
            sequencer.open();
        }
        catch (MidiUnavailableException e) {
            e.printStackTrace();
        }

        // コンソール入力からMIDIファイルのパスを取得する。
        Scanner scanner = new Scanner(System.in);
        System.out.print("MIDIファイルのパス >> ");
        String path = scanner.next();

        try {
            // MIDIファイルからMIDIデータ(Sequenceオブジェクト)を取得。
            File file = new File(path);
            Sequence sequence = MidiSystem.getSequence(file);

            // 取得したMIDIデータをシーケンサに設定する。
            sequencer.setSequence(sequence);
        }
        catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // シーケンサー再生
        sequencer.start();

        // キー入力待ち
        System.out.println("適当に文字列を入力すると終了します。");
        System.out.print(">>");
        scanner.next();
        scanner.close();

        // シーケンサー停止
        sequencer.stop();

        // シーケンサーを閉じ、使用していたリソース解放する。
        sequencer.close();
    }
}