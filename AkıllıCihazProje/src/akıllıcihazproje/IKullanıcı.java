
package akıllıcihazproje;

public interface IKullanıcı {
    public boolean kullanıcıDogrula();
    public int veriAl();
    public boolean veritabaniBaglanti(String kullaniciAdi, String sifre);
    public void girisleriKontrolEt();
}
