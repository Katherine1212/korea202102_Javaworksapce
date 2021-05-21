/*
GUI ���α׷����� ������ �����찡 �־�� �����ϴ�.
���� �ڹ� ���� GUI���õ� ��Ű���� awt/swing ���� ����.
javaFX-> �ȵ���̵�� ���� �����.
*/
package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.Choice;
class MyWin{
	public static void main(String[] args) {
		// �ڹٿ��� ������� Frame�� ���
		Frame frame; // ��ü�� �ν��Ͻ��� ����. frame���� �ʱ�ȭ �Ǿ����� ����.
		/*
		Frame�̶�� Ŭ������ ����϶�� ������ ��. ������ ��� ������� ��.
		Why? ���� ������ Ŭ������ �ƴϱ⶧��.
		
		Tip ������ �������� ��ü ����
		1. �ش� Ŭ������ �ľ�. �뵵�� ��������? ��� ������ ��������?
			https://docs.oracle.com/en/java/javase/11/docs/api/index.html

		2. ����Ϸ��� �޸𸮿� �÷�����. �޸𸮿� �ø����� ��ü�� �Ϲ�, �߻�, �������̽����� ����
			- �Ϲ� Ŭ����: new ����();
			- �߻� Ŭ����&�������̽�: �ڽ����� �ϼ� �� �ڽ��� new.

		3.��ü�� ������ �ľ� �Ǿ��ٸ�,
			- �Ϲ� Ŭ����: new ������ �� ������ ����.
			- �߻� Ŭ����&�������̽�:
		*/
		frame= new Frame();

		// ������ �� ������ ��ư ����
		Button bt= new Button("click");
		/*
		��ư�� �ʹ� ũ�� ������ ������?
		��� GUI���α׷��ֿ����� ȭ�� ��ġ ����� �����ڰ� �����ؾ��ϱ� ����.
		*/
		FlowLayout flow= new FlowLayout(); // ������Ʈ�� �������� ��ġ�ϴ� ���̾ƿ� ��ü(����or���� ��ġ)
		frame.setLayout(flow); // �����ӿ� ������ ���� or ���� ����

		// �Է� �ؽ�Ʈ�ڽ� �����Ͽ� ����
		TextField t= new TextField(20); // ���ڸ� ������ �ش� n�� ũ���� �ʺ� Ȯ��.

		// üũ�ڽ�
		Checkbox ck1= new Checkbox("Movie");
		Checkbox ck2= new Checkbox("Programming");
		Checkbox ck3= new Checkbox("Fitness");
		Checkbox ck4= new Checkbox("Travle");
		
		// �ؽ�Ʈ������
		TextArea tx= new TextArea(5,15);

		// html�� select box�� choice��� ��
		Choice choice= new Choice();
		choice.add("select Email");
		choice.add("@naver.com");
		choice.add("daum.net");
		choice.add("@google.com");

		// �����ӿ� ����
		frame.add(bt);
		frame.add(t);
		frame.add(ck1);
		frame.add(ck2);
		frame.add(ck3);
		frame.add(ck4);
		frame.add(tx);
		frame.add(choice);

		frame.setVisible(true); // frame �⺻ ������ display:none;
		frame.setSize(300,400);// ũ�� ������� ������ ���ϴ� ũ��� ������ ����

	}
}
