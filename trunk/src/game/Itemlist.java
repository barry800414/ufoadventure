package game;

import java.io.*;

public class Itemlist {
    
    public Itemlist(){
	
	PrintWriter output = null;
    
	try{
	
	    output = new PrintWriter(new FileOutputStream("itemlist.txt"));
    
	} catch(FileNotFoundException e) {
	    System.out.println(".........");
	}
    
	output.print(
		"24\n"
		+"������l 30 �i�H���w�����B��(1~6)\n"
		+"���� 30 �i�H�N�ۤv�Ψ�L����צ�\n"
		+"���p 50 ��m��@�^�X���ΡA��n���Ӯ�h�|�z���A�}�񨮡B�T���|�a��\n"
		+"�w�ɬ��u 60 �g�L�N�|�۰��H�ۦb���⨭�W�A���L����g�L�Q���u�j�����⪺�ɭԡA���u�|�ಾ��t�@�ӤH���W�A���@�B�h��@�A��0�N�z��\n"
		+"�������u 200 ���w�@�Ӱϰ�o�g���u�A�d�򤺫ؿv����@�h�A�����q�u��l���A�åB��|�T�^�X\n"
		+"�ּu 600 ���w�@�Ӱϰ�A�d�򤺩ЫΥ����A�����q�u��l���A�åB��|���^�X\n"
		+"�M�D�� 30 �M���e��Q�B�������B�I���B�c���B�_��\n"
		+"���_�� 300 �ϥΫ�i��T����l(�����͡B�j�ǥͤ���})\n"
		+"�x�W���q�u 50 ���w�@�ؿv�A�N��h�\�@�h\n"   
		+"���g�� 50 ���w�@�ؿv�A�N�䷴�a�@�h\n"
		+"319������j 100 �i�����ù��d�򤺨���A�Ϩ��|3�^�X\n"
		+"��h�u(�ݼ�) 150 ���ݼ֡A�u��h�u�A�d�򤺨����|�T�^�X�A��q�u��l��\n"
		+"���u�I�� 100 �i��פ@���j�B��h�u������\n"
		+"���K�H���� 300 �i��פ@���j�B��h�u�B���u�B���p������(�ּu����)\n" 
		+"�������� 80 �N�̪񪺸��W�����B�I���B�c���B�_���l���ۤv\n"
		+"�ʫΪ��P 80 ���F�o�i���P�A�N��C���ΥD��X��ؿv\n" 
		+"�L���O�W�� 50 �ϬY�@�Ӹ��q�L���Ox2\n"
		+"���׳N 80 �N���n���H���ƥ�Ψ�L����ҬI�񤧫D���z�ʧ����������L����\n"
		+"�ʯv�N 100 �ϬY�Ө���εۡA��a���ʤT�^�X�A���౱��\n"
		+"�Q�t 80 �ϬY����b�T�^�X���A�u�ಾ�ʤ@�B\n" 
		+"���F�v�m�� 150 ���L���⦬����{����10%\n"
		+"�ϦV 30 �Ϩ�����V\n"
		+"�ڹC 100 �T�^�X���L�k����Ө���A�|�ۤv���ʡA���|�R�Ы�\n" 
		+"�f�r 0 �ϤH�ͯf�A�i�J�ͯf���A���^�X�ᶷ��|�T�^�X�A�g�L���H�]��50%���|�Q�ǬV\n"
		);
	output.close();
	
	}
    
}
