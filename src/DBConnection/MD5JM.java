package DBConnection;

import java.security.MessageDigest;

public class MD5JM {
	public static String md5Password(String password) {
		try {
			//�õ�һ����ϢժҪ��
			MessageDigest digest=MessageDigest.getInstance("md5");
			byte[] result=digest.digest(password.getBytes());
			StringBuffer buffer=new StringBuffer();
			//��ÿһ��byte��һ�������� 0xff;
			for(byte b:result) {
				//������
				int number=b&0xff;//����
				String str=Integer.toHexString(number);
				if(str.length()==1) {
					buffer.append("0");
				}
				buffer.append(str);
			}			
			//���ر�׼md5���ܺ�Ľ��
			return buffer.toString();
		}catch(Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
