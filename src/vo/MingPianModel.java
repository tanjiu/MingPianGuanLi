package vo;

public class MingPianModel {
	private String XingMing;
	private String LianXiFangShi;
	private String YouXiang;
	private String GongZuoDanWei;
	private String ZhiWu;	
	private int BianHao;	
	private int ZHBianHao;
	public MingPianModel() {}
	public MingPianModel(int bianHao,String xingMing, String zhiWu, String lianXiFangShi, String youXiang, String gongZuoDanWei,int zHBianhao
			) {
		super();
		XingMing = xingMing;
		LianXiFangShi = lianXiFangShi;
		YouXiang = youXiang;
		GongZuoDanWei = gongZuoDanWei;
		ZhiWu = zhiWu;
		BianHao = bianHao;
		ZHBianHao=zHBianhao;
	}
	public MingPianModel(int bianHao,String xingMing, String zhiWu, String lianXiFangShi, String youXiang, String gongZuoDanWei
			) {
		super();
		XingMing = xingMing;
		LianXiFangShi = lianXiFangShi;
		YouXiang = youXiang;
		GongZuoDanWei = gongZuoDanWei;
		ZhiWu = zhiWu;
		BianHao = bianHao;
	}
	public MingPianModel(String xingMing, String zhiWu, String lianXiFangShi, String youXiang, String gongZuoDanWei) {
		super();
		XingMing = xingMing;
		LianXiFangShi = lianXiFangShi;
		YouXiang = youXiang;
		GongZuoDanWei = gongZuoDanWei;
		ZhiWu = zhiWu;		
	};
	public MingPianModel(String xingMing, String lianXiFangShi) {
		super();
		XingMing = xingMing;
		LianXiFangShi = lianXiFangShi;		
	};
	public String getXingMing() {
		return XingMing;
	}
	public void setXingMing(String xingMing) {
		XingMing = xingMing;
	}
	public String getLianXiFangShi() {
		return LianXiFangShi;
	}
	public void setLianXiFangShi(String lianXiFangShi) {
		LianXiFangShi = lianXiFangShi;
	}
	public String getYouXiang() {
		return YouXiang;
	}
	public void setYouXiang(String youXiang) {
		YouXiang = youXiang;
	}
	public String getGongZuoDanWei() {
		return GongZuoDanWei;
	}
	public void setGongZuoDanWei(String gongZuoDanWei) {
		GongZuoDanWei = gongZuoDanWei;
	}
	public String getZhiWu() {
		return ZhiWu;
	}
	public void setZhiWu(String zhiWu) {
		ZhiWu = zhiWu;
	}
	public int getBianHao() {
		return BianHao;
	}
	public void setBianHao(int bianhao) {
		this.BianHao=bianhao;
	}
	public int getZHBianHao() {
		return ZHBianHao;
	}
	public void setZHBianHao(int zHBianHao) {
		ZHBianHao = zHBianHao;
	}
	
}
