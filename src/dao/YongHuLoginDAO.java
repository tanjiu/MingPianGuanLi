package dao;



public interface YongHuLoginDAO {
	//��½��
	public boolean Exists(String User,String Pwd);
	//ע���ж���
	public boolean ExistsZH(String ZhangHao);
	//ע��
	public boolean AddZhangHao(String User,String Pwd);		
	//���ݵ�½���е��˺Ż�ȡ��½��Ϣ�ı��
	public int getBianHao(String ZhangHao);
	//��������
	public boolean updateMiMa(String User,String Pwd);
}
