package music;
import riding.Roller;
import aircraft.Zetwing;
/*
�߻�Ŭ������ ��ӹްԵǴ� �ڽ��� �θ� �ҿ����ϰ� ���ܳ��� �ҿ��� �޼ҵ带 �ϼ��� �ǹ��� ����.
��ȯ���� �޼ҵ带 ���������� �������.(�θ� �ϼ� ���ϸ� �ڽ��� ��ӹ޾� �ϼ� �ؾ���)
���: �߻� Ŭ������ ��ӹ��� �ڽ��� �θ� �ϼ����� ���� �߻�޼ҵ带 �������̵��ؾ� ��.

java������ ���� ����� ����. �� �ڽ� Ŭ������ .class�� �θ�� �дٸ� ���̻� �ٸ� Ŭ������ �߰���
�θ�� ���� �� �� ����.
*/
public class MP3Player extends MusicPlayer implements Roller, ZetWing{
	public void setVolume(){
		System.out.println("MP3�÷��̾��� ������ �����մϴ�.");
	}
	public void openMP3(){
		System.out.println("MP3������ �����մϴ�.");
	}
	public void roll(){
		System.out.println("�ѷ����̵带 �����մϴ�.");
	}
	public void fly(){
		System.out.println("�ϴ��� �� �� �ֽ��ϴ�.");
	}
}